# 동반 객체란?
> 동반 객체
>  companion object 사용법

1. companion
>Kotlin에는 Java의 static 이 없다. Kotlin 에서는 Java 의 static 함수 등과 같이 인스턴스 생성 없이 해당 클래스의 함수나 프로퍼티를 참조하기 위해서 사용하는 키워드가 companion 키워드다. companion 은 object와 함께 쓰이는데 예를 들어 Java에서 Util 함수를 구현한다고 하였을 때 보통 아래와 같이 static 함수를 정의해서 사용한다.


<pre>
<code>
public class Util{
  public static void doSome(){  
  }
}
</code></pre>


Kotlin에서는 해당 클래스를 한정자로 해서 Java의 static 과 같은 접근이 필요할 때 companion object를 사용한다.

<pre>
<code>
class Util {
  companion object {
    fun doSomething()
  }
}
</code></pre>
