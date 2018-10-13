## AOP

> 정리(이전 프로그래밍)

절차 지향적인 프로그래밍
- c언어: 구조체(다양한 타입의 변수들), 함수 중심 ,순서대로 실행


객체 지향적인 프로그래밍
- c++ : 클래스 추가(변수+함수)
- java
_____

> AOP(Aspect Oriented Programming) , 관점 지향 프로그래밍

- OOP를 보완하는 확장적인 개념
- Aspect(관점) : 핵심적인 비지니스 로직은 아니지만 반드시 해야 하는 작업들
- 관심의 분리를 통해 핵심관점(업무 로직) + 횡단관점(트랜잭션, 로그, 보안, 인증 처리)등으로 관심의 분리 실현
- 장점 : 중복되는 코드 제거, 효율적인 유지보수, 높은 생산성, 재활용성 극대화, 변화 수용의 용이성

![imgea](https://t1.daumcdn.net/cfile/tistory/2514694E55D5B03433)

- 매번 메인 코드에 비슷한 작업을 똑같이 반복하는 것을 방지함, 메인 업무만 따로 작성, 관점 면에서 중복되는 작업을 따로 작성해서 적용
- 개발자가 메인 업무에 집중


> AOP 의 주요 용어

- Aspect : 공통 관심사(로깅 ,보안, 트랜잭션)
- Join Points : method를 호출하는 시점, 예외가 발생하는 시점 등과 같이 특정 작업이 실행되는 시점
- Advice : Join Points에서 실행되어야 하는 코드(실제 AOP기능을 구현한 객체)
- Pointcuts : 실제로 Advice를 적용시킬 대상 method
- Proxy : Advice가 적용되었을때 만들어지는 객체

> Advice 종류

- Before : target method 호출 전
- After : method 호출 후
- Around : 이전 이후 모두 적용


> pom.xml 라이브러리 추가

~~~xml
<org.aspectj-version>1.8.10</org.aspectj-version>

<!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.8.10</version>
</dependency>

~~~

> servlet-context.xml

- Namespace에 aop, tx(트랜잭션) 추가

~~~xml
<!-- aop의 설정을 통한 자동적인 Proxy 객체 생성 -->
	<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
~~~

> Class 작성

- 로그 수집 작업을 하려면 모든 메소드에 해야함
- 로그 수집은 중요한 업무이지만 핵심적인 업무는 아님, 공통적인 업무에 해당(횡단)
- Advice에 모아서 작성

~~~java
package com.example.spring02.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component // 스프링에서 공통으로 등록
@Aspect
public class LogAdvice {
	private static final Logger logger
		= LoggerFactory.getLogger(LogAdvice.class);


	@Around("execution(* com.example.spring02.controller..*Controller.*(..))"
			+ " or execution(* com.example.spring02.service..*Impl.*(..))"
			+ " or execution(* com.example.spring02.model..dao.*Impl.*(..))")
	public Object logPrint(ProceedingJoinPoint joinPoint)
			throws Throwable{
		//실행 1
		long start = System.currentTimeMillis();

		// 메인 메서드 실행 2

		// 메인 후 실행 3
		Object result = joinPoint.proceed();

		String type =
				joinPoint.getSignature().getDeclaringTypeName();
		String name = "";
		if(type.indexOf("Controller") > -1) {
			name ="Controller \t:";
		}else if (type.indexOf("Service") > -1) {
			name ="ServiceImpl \t:";
		}else if (type.indexOf("DAO") >-1) {
			name ="DaoImple \t:";
		}

		//호출한 클래스, method 정보
		logger.info(name+type+"."+joinPoint.getSignature()
				.getName()+"()");

		//method에 전달되는 매개변수들
		logger.info(Arrays.toString(joinPoint.getArgs()));
		// 로그 수집 끝난 시간
		long end=System.currentTimeMillis();
		long time=end-start;
		logger.info("실행시간:"+time);
		return result;
	}

}
~~~

~~~text
16:25:20.121 [http-nio-8080-exec-2] INFO [jdbc.sqltiming.sqlTimingOccurred:373]-
				select * from product order by product_name
 {executed in 1 msec}
16:25:20.124 [http-nio-8080-exec-2] INFO [jdbc.connection.connectionClosed:568]-
				9. Connection closed
16:25:20.124 [http-nio-8080-exec-2] INFO [com.example.spring02.aop.LogAdvice.logPrint:44]-
				DaoImple 	:com.example.spring02.model.shop.dao.ProductDAO.listProduct()
16:25:20.124 [http-nio-8080-exec-2] INFO [com.example.spring02.aop.LogAdvice.logPrint:48]-
				[]
16:25:20.125 [http-nio-8080-exec-2] INFO [com.example.spring02.aop.LogAdvice.logPrint:52]-
				실행시간:40
16:25:20.125 [http-nio-8080-exec-2] INFO [com.example.spring02.aop.LogAdvice.logPrint:44]-
				ServiceImpl 	:com.example.spring02.service.shop.ProductService.listProduct()
16:25:20.125 [http-nio-8080-exec-2] INFO [com.example.spring02.aop.LogAdvice.logPrint:48]-
				[]
16:25:20.125 [http-nio-8080-exec-2] INFO [com.example.spring02.aop.LogAdvice.logPrint:52]-
				실행시간:40
16:25:20.126 [http-nio-8080-exec-2] INFO [com.example.spring02.aop.LogAdvice.logPrint:44]-
				Controller 	:com.example.spring02.controller.shop.ProductController.list()
16:25:20.126 [http-nio-8080-exec-2] INFO [com.example.spring02.aop.LogAdvice.logPrint:48]-
				[]

~~~

> 트랜잭션

- 트랜잭션이 완료되지 않은 상태에서 에러가 발생하면 데이터에 오류가 발생함


- 글쓰기 + 포인트 10 부여
- 글 읽기 + 열람포인트 5 부여 + 열람시간 수정

> root-context.xml

~~~xml
<!-- 트랜잭션 관련 설정 -->
	<bean id="transactionManager"
		class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource"></property>
	</bean>

	<!-- 트랜잭션 관련 어노테이션 자동 인식하는 옵션 -->
	<tx:annotation-driven/>
~~~
