## Control flow

>if else
- if 문이 식으로 사용되는 경우 값을 반환함
- if식의 경우 반드시 else를 동반
<pre><code>
val max = if(a>b) a else b
</code></pre>

- if식의 branches들이 블록 생성 가능, 마지막 구분이 반환 값
<pre><code>
val max = if(a>b) {
  print("choose a")
  a
}else{
  print("choose b")
  b
}
</code></pre>

- 삼항연산자가 없다.
<pre><code>
//java
int max = (a>b) ? a : b;

//kotlin
val max = if(a>b) a else b
</code></pre>

> when
- switch 문 대체
- 위에서 부터 순차적으로 인자값 비교
<pre><code>
when(x){
  1 -> print("x==2")
  2->print("x==2")
else ->{
  print("x is neither 1 nor 2")}
}
</code></pre>

- when이 식으로 사용된 경우 else문이 필수
- 단, 컴파일러가 else문이 없어도 된다는 것을 입증할 수 있스면 생략 가능

<pre><code>
when(x){
  parseInt(x)-> print(" s encodes x")
  1+3 -> print("4")
  else -> print("s does not encode x")
}
</code></pre>

- range 나 Collection에 in / !in 으로 범위 검사 가능

>For Loops
- for 문은 iterator을 제공하는 모든 것을 반복할 수 있음
<pre><code>
for(item in items){
  print(item)
}
</code></pre>

- For문을 지원하는 iterator의 조건
1. 멤버 함수나 확장함수 중에 iterator를 반환하는 것이 있는 경우
next() , hasNext() : Boolean를 가지는 경우
2. operator로 표기 필수

<pre><code>
fun main(){

  val myData = MyData()
  myData.iterator()
  for(item in myData){
    print(item)
  }
}
</code></pre>
<pre><code>
class MyData{
  operator fun itarator(): MyIterator{
    return MyIterator()
  }
}
</code></pre>
<pre><code>
class MyIterator{
  val data = listOf(1,2,4,5,6)
  var idx = 0
  operator fun hasNext() : Boolean{
    return data.size >idx
  }

  operator fun next():Int{
    return data[idx++]
  }
}
</code></pre>

- 배열리나 리스트를 반복할 때, index를 이용하고 싶다면 indices를 이용
<pre><code>
val array = arrayOf("가","나","다")
for(i in array.indices){
  println("$i : ${array[i]}")
}
</code></pre>

- index를 이용하고 싶을때, withIndex() 이용 가능
<pre><code>
val array = arrayOf("가","나","다")
for((index, value) in array.withIndex()){
  println("$index : ${value}")
}
</code></pre>
