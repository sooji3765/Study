#Basic Sytax

>함수 정의
- 함수는  fun 키워드로 정의
<pre><code>
fun sum(a:int,b:int) :int{
  return a+b
}
</code></pre>

- 함수 몸체가 식인 경우 return 생략
- return 타입이 추론
<pre><code>
fun sum(a:int,b:int) = a+b
</code></pre>
- 리턴 값이 없으면 Unit 으로 리턴
- Unit은 생략 가능
<pre><code>
fun printKotlin() :Unit{
  println("Kotlin")
}
</code></pre>

> 지역 변수 정의 val , var
- val : only read
- 값의 할당이 1회만 가능, final 과 유사
- var : Mutable 변수 , 가변 변수
<pre><code>
// val 사용
val a:int =1
val b =2
val c:int // 반드시 초기화
c=3 // 컴파일 오류

//var 사용
var x=5
x+= 1
</code></pre>

> 문자열 템플릿
- String Interpolation
<pre><code>
var a =1
var s1 = "a is $a"

a=2
val s2 ="${s1.replace("is","was")}, but now is $a"
</code></pre>

>조건문
<pre><code>
fun max(a:int, b:int){
  if(a>b){
    return a
    }else{
    return b
  }
}
</code></pre>
- 조건식으로 사용 가능
<pre><code>
fun max(a:int,b:int) = if(a>b) a else b
</code></pre>

> nullable
- 값이 null일 수 있는 경우 타입에 nullable마크를 명시
<pre><code>
fun sum(str:String) :int?{
  // null을 리턴할수도 있다는 것을 표시
  // ? 물음표
}
</code></pre>

- nullable 타입의 변수를 접근 할때는 반드시 null체크를 해야 함
- 컴파일 오류 발생
<pre><code>
fun printPro(str1:String, str2:String){
  val x :int ? = sum(str1)
  val y :int ? = sum(str2)

  if(x!=null && y!=null){ // null check!
    println(x*y)
  }else{
    println("number is null")
  }
}

</code></pre>

> 자동타입 변환
- 타입 체크만 해도 자동으로 타입 변환
<pre><code>
fun getLength(obj:Any):int?{
  if(obj is String){
    return obj.length
  }
    return null
}
</code></pre>

>반복문 while loop
<pre><code>
val items = listOf("a","b","c")
var index = 0

while(index < items.size){
  println("items at $index is ${items[index]}")
  index++
}
</code></pre>

>when 조건문
<pre><code>
fun getLength(obj:Any):int?{
  when(obj){
  is String -> "string"
  is int  -> "int"
  else   -> " unknown"
}
}

</code></pre>

> ranges
- in 연산자 사용하기
<pre><code>
val x =3
if(x in 1..10){
  println("fits in range")
}
</code></pre>

- for loop
<pre><code>

for(x in 1..10){
  print(x)
}
</code></pre>

- 컬렉션도 in 으로 loop 가능
<pre><code>
val items = listOf("a","b","c")

for(item  in items){
  print(item)
}
</code></pre>

- in 으로 해당 값이 컬렉션에 포함되는지 체크
<pre><code>
val items = setOf("a","b","c")
when{
  "a" in items -> println("A")
   "b" in items -> println("B")
}
</code></pre>

> Collections
- 람다식을 이용해서 컬렉션에 f filter, map 등의 연산 가능
