## Basic Types

>기본 타입
- 코틀린에서 모든 것을 객체임
- 멤버 함수, 프로퍼티 호출 가능

>숫자
- char가 kotlin에서는 숫자 형이 아님
- kotlin에서 Number는 클래스

> Representation
- Nullable이나 제네릭의 경우에는 박싱
- Java 플랫폼에서 숫자형은 JVM primitive type으로 저장됨

<pre><code>
fun test(){
    var a: Int = 1000
    var b: Int = 1000

    // 같은 identity ?
    println("a===b: ${a===b}")

    println("a==b: ${a==b}")

    // decomplie 로 해서 확인 가

}
</code></pre>

> Explict Conversions
- 작은 타입(int)은 큰 타입 (Long)의 하위 타입이 아니다.
- 작은 타입은 큰 타입으로 대입이 불가,
<pre>
<code>
val a : Int =1
val b :Long = a // 오류
val b: Long = a.toLong()
</code></pre>
- 명시적 변환을 해주어야 함
<pre><code>
val i:Int = b.toInt()
</code></pre>

>문자
<pre><code>
fun check(c:Char){
  if(c==1){ } // 에러
}

fun check(c:Char){
  if(c=='a'){ }
}
</code></pre>

>배열
- 배열은 Array클래스
- get/set

<pre><code>

//배열 선언
// 1.  라이브러리 함수 이용
var array :Array<String> = arrayOf(" apple" ,"eat")

//2.Array의 팩토리 함수 이용
val array2 = Array(5, {i->i.toString()})

//get 메서드
println(array.get(0))
println(array[0

println(array.size)

</code></pre>

> 특별한 Array클래스
- primitive 타입의 박싱 오버헤드를 없애기 위한 배열
- IntArray, ShortArray ..등
<pre><code>
val x :IntArray = intArrayOf(1,2,3)
x[0] = 7
println(x.get(0))
println(x[0])

</code></pre>
