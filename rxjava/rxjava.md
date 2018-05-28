## 리액티브 프로그래밍

RxJava 1.0 -> RxJava2.0 변화

> RxJava 라이브러리
> RxJava2 와 RxJava1의 차이점

#### 리액티브 프로그래밍이란?
  - 데이터 흐름과 전달에 관한 프로그래밍 패러다임

  - 데이터의 흐름 정의 -> 데이터 변경 발생 -> 연관된 함수, 수식 변경

  - 이전부터 모델의 값에 변화가 생겼을때, 뷰를 자동으로 업데이트 헤주는 목적으로 사용됨

  -즉, 내가 어떤 기능을 직접 실행하는 것이 아니라, <u>시스템에 어떤 시스템에 어떤 이벤트가 발생했을때 처리하는 것</u>

  - java에서 리액티브 프로그래밍이 되려면 `함수형 프로그래밍`이 필요

#### RxJava예시

~~~java

  // io.reactivex : 기본 패키지 이름
  // Observable 클래스 : 데이터의 변화가 발생하는 데이터 소스
  import io.reactivex.Observable

  public class FirstExample{
    public void emit(){
      Observable.just("Hello","RxJava 2")
      .subscribe(System.out::println);

      // just() : 단순한 Observable 선언 방식
      // subscribe() : Observable은 subscribe() 함수를 호출해야 비로소 변화한 데이터를 구독자에게 발행

      //System.out::println ==  data -> System.out.println(data)
    }

    public static void main(String arg[]){
      FirstExample demo = new FirstExample();
      demo.emit();

    }
  }
~~~  

#### RxJava 공부 순서

  1. `Observable` 클래스의 명확한 이해 , Hot Observable과 cold Observable의 개념 이해

  2. `map()`, `filter()`, `reduce()`, `flatMap()` 함수 사용법

  3. 생성 연산자, 결합 연산자, 변환 연산자 등 카테고리별 주요 함수를 공부

  4. 스케줄러의 의미와 subscribeOn() , ObservableOn() 함수 차이

  5. 디버깅, 흐름제어 함수

###### RxJava는 자바 8에서 제공하는 Consumer, Predicate , Function 과 같은 함수형 인터페이스를 자체 구현했으므로 자바 6이상에서 동작을 한다.

##### 마블 다이어그램

  - flip() 함수의 마블 다이어그램 살펴보기

  ![alt text](https://t1.daumcdn.net/thumb/R1280x0/?fname=http://t1.daumcdn.net/brunch/service/user/SQo/image/nYWEQDBFYVyGyg5uN6H0YP3vWXw.png)


#### Observable

> RxJava 1.x에서는 데이터 소스를 Observable과 Single 클래스로 구성

> RxJava 2.x 두 클래스 이외에 Maybe , Flowable클래스로 구분

  - 옵저버 패턴을 구현한다.

###### Observable 패턴
  - 객체의 상태 변화를 관찰하는 관찰자(Observer) 목록을 객체에 등록하고 <u>상태 변화가 있을때마다 메서드를 호출</u>하여 객체가 직접 목록의 각 옵서버에세 변화를 알려준다.
  - 라이플 사이플이 존재하지 않으며 단일 함수를 통해 변화
  - onClik() 메서드

#### Rxjava의 Observable은 세가지 알림을 구독자에게 전달

  - `onNext` : Observable이 데이터의 발행을 알림
  - `onComplete` : 모든 데이터의 발행을 완료했음을 알림, 이 이벤트는 단 한번만 발생하며, 발생 후에는 더이상 `onNext`이벤트가 발생해서는 안된다.
  - `onError` : Observable 에서 에러 발생 , 실행 종료

#### Observable 메서드

###### just() 함수
  - 인자로 넣은 데이터를 차례로 발행하려고 Observable 생성
  - 최대 10개의 인자값을 넣는다. 단, 타입은 동일
  - 실제 데이터의 발행은 `subscribe()` 함수 호출해야 시작

  ~~~java

  public class FirstExample{
    public void emit(){
      Observable.just(1,2,3,4,5,6)
      .subscribe(System.out::println);
    }
  }

  ~~~

###### subscribe() 함수와 Disposable 객체

  - 동작시키기 원하는 것을 사전에 정의해둔 다음 그것이 실행되는 시점을 조절 ---> subscribe() 함수 사용

  ~~~java

  Observable<String> source = Observable.just("red","green","yellow");

  Disposable d = source.subscribe(
    v-> System.out.println("onNext() : value :" +v),
    err -> System.out.println("onError() : error :" +err.getMessage()),
    () -> System.out.println("onComplete() ")
  );

  System.out.println("isDisposed : " +d.isDisposed()),
  //isDisposed() : Observable 구독 해지 여부 확인

  ~~~


###### create() 함수
  - create() 함수는 3가지 알림을 개발자가 직접 호출해야함.

  ~~~java

    Observable<Integer> source = Observable.create(
    (ObservableEmitter<Integer> emitter)->{

      emitter.onNext(100);
      emitter.onNext(200);
      emitter.onNext(300);
      emitter.onComplete();
    });

    source.subscribe(System.out::println);
  ~~~

###### fromArray() :단일 데이터가 아닌 배열인 경우 Observable 생성

  // 단 기본 데이터형이 아닌 래퍼런스 형으로 해야함 ** 변경 필수

  ~~~java
  Integer[] arr = {100,200,300};
  Observable<Integer> source = Observable.fromArray(arr);

  source.subscribe(System.out::println);
  ~~~

#### map() 함수
  - 입력값을 어떤 함수에 넣어서 원하는 값으로 변환하는 함수

  ~~~java
  String [] arr = {"100","200","300"};
  Observable<String> source = Observable.fromArray(arr)
    .map(arrs -> arrs + "@");

  source.subscribe(Log::i);
  ~~~


#### flatMap() 함수
  - flatMap() 결과는 Observable
  - 일대일 혹은 일애일 Observable 함수

  ~~~java

  Function<String, Observable<String>> getDoubleDiamods =
    ball -> Observable.just(ball + "◇", ball + "◇");

  String [] balls = {"100","200","300"};
  Observable<String> source = Observable.fromArray(balls)
    .flatMap(getDoubleDiamods);

  source.subscribe(Log::i);
  ~~~

#### fliter() 함수
  - 원하는 데이터만 걸러내는 함

  ~~~java
  String[] objs ={"1 CIRCLE" ,"2 DIAMOND" ,"3 TRIANGLE"}

  Observable<String> source = Observable.fromArray(objs)
    .filter(obj -> obj.endWith("CIRCLE"));

  source.subscribe(System.out::println);

  ~~~

#### reduce() 함수
  - 상황에 따라 발행된 데이터를 취합하여 어떤 결과를 만들때 사용

  ~~~java
  String [] arr = {"100","200","300"};
  Maybe<String> source = Observable.fromArray(arr)
    .reduce((arrs1,arrs2) -> arrs2 + "("+arrs1+")");

  source.subscribe(System.out::println);
  ~~~

#### 데이터 쿼리 예제
  1. 전체 매출 데이터 입력
  2. 매출 데이터 중 tv 매출 필터링
  3. tv 매출 합 구하기


  ~~~java

  List<Pair<String,Integer>> sales = new ArrayList<>();

  sales.add(Pair.of("TV",2500));
  sales.add(Pair.of("Camera",3000));
  sales.add(Pair.of("TV",2900));
  sales.add(Pair.of("Phone",900));

  Maybe<Integer> tvSales = Observable.fromIterable(sales)
    .filter(sale -> "TV".equals(sales.getLeft()))
    .map(sale -> sale.getRight())
    .reduce((sale1,sale2)-> sale1+sale2);

  tvSales.subscribe(total -> System.out::println("Tv Sales: $"+total));  
  ~~~
