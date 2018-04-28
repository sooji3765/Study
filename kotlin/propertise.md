#Properites and Fields

> 프로퍼티 선언
- 코틀린 클래스는 프로퍼티를 가질수 있음

<pre><code>
class Address{
  var name : String ="kotlin"
  val city : String ="Seoul"

  get() {
    return field
  }
  set(value) {
    field =value
  }
}
</code></pre>

- 프로퍼티 사용은 자바의 필드를 사용하듯이 하면 됨
<pre><code>
fun copyAddress(address : Address) : Address{
  val result = Address()
  result.name = address.name
  result.city = address.city

  return result
}
</code></pre>
