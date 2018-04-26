#Immutable Object

> Immutable Class
- 변경이 불가능한 클래스 .
- 즉, 불가변 클래스

> Java 에서 Immutable Class
-  String, Boolean, Integer, Float , Long ...이 존재

> Immutable 의 특징

- 장점 : 생성자, 접근메소드에 대한 방어 복사가 필요없습니다. 멀티스레드 환경에서 동기화 처리없이 객체를 공유할 수 있습니다.(Thread-safe) 불변이기 때문에 객체가 안전합니다.


- 단점 : 객체가 가지는 값마다 새로운 객체가 필요합니다. 따라서 메모리 누수와 새로운 객체를 계속 생성해야하기 때문에 성능저하를 발생시킬 수 있습니다.

<pre><code>
  String a = "Hello";
  a = a.concat("World");
  System.out.println(a);
</code></pre>

- 메모리 주소 값이 다르다.

> Kotlin 에서 적용시
<pre><code>
/*
* 2.2 컬렉션
* 자료의 가변 / 불변
* */

fun main(args: Array<String>) {

    //자료를 수정할수 없는 리스트
    val immutableList1 :List<String> = listOf("hello","word","hey")

    val list2 : MutableList<String> = immutableList1 as MutableList<String>;

    list2.add("num");
    //컴파일 에러
    //immutableList1.add("amet")

    //자료를 수정할수 있는 리스트
    val immutableList2 :MutableList<String> = arrayListOf("hello","word","hey")

    immutableList2.add("amet")
    for (item in immutableList2){
        println(item)
    }

    //자료를 수정하지 않는 자료형으로 재 할당
    val immutableList3 :List<String> = immutableList2

    for (item in immutableList3){
        println(item)
    }
    immutableList2.add("check")

    for (item in immutableList2){
        println(item)
    }
}

</code></pre>
