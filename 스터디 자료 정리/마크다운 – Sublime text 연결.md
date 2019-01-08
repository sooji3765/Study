# 마크다운 – Sublime text 연결

1. Sublime Text3를 실행한다.
2. Ctrl+Shift+P를 누르고 Package Control: Install Package를 선택한다.
![image](https://user-images.githubusercontent.com/26784875/50677157-9b87e480-103b-11e9-82e9-b10d0c5781a0.png)
3. 각각의 Plugin을 찾아 설치한다.
    * Markdown Editing
    * Markdown Preview
    
    ![image](https://user-images.githubusercontent.com/26784875/50677178-b8241c80-103b-11e9-943f-85245ea0c099.png)

4. Preferences -> Key Bindings에 단축키를 추가한다.
  ![image](https://user-images.githubusercontent.com/26784875/50677187-c70acf00-103b-11e9-8826-6a39473e39c7.png)

5. 파일을 하나 생성하고 저장시 확장자를 .md로 한다.
 
    파일 예시
      ~~~txt
      #Properites and Fields

      > 프로퍼티 선언
      * 코틀린 클래스는 프로퍼티를 가질수 있음

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

      * 프로퍼티 사용은 자바의 필드를 사용하듯이 하면 됨
      <pre><code>
      fun copyAddress(address : Address) : Address{
        val result = Address()
        result.name = address.name
        result.city = address.city

        return result
      }
      </code></pre>
      ~~~
6. 마크다운 확인시, ALT + m을 누르면 브라우저에서 확인 가능
  ![image](https://user-images.githubusercontent.com/26784875/50677199-d558eb00-103b-11e9-8fec-35a9d39b2651.png)


<br>
### Markdown 참고 사이트 

- https://heropy.blog/2017/09/30/markdown/  
- 마크다운 설명, 문법 사용법 정리 `git`과 연동하여 프로젝트 설명 및 소스 코드 정리에 좋음