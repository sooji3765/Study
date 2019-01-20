# JavaScript 정리

> 개념

   - 동적인 웹페이지 작성을 위해 사용
   - 클라이언트 pc에서 실행
   - 인터프린터 언어 

> 사용 방법


1. 인라인 자바스트립트 : 태그 내부에 직접 작성

	< 태그 이벤트 ="자바스크립트 코드"> 
		
	~~~html
	<input type="button" onclick='alert("ok")'>
	~~~


 2. 내부 자바스트립트
    
    `<head>` 태그 or `<body>` 태그 내부에 작성
    ~~~html
    <script type="text/javascript">
    //자바 스트립트
    </script>    
    ~~~

3. 외부 자바스크립트
        
    ~~~html
    <script src="자바스크립트파일.js"></script>
    ~~~


> 자바스크립트 대화상자

 - `alert("메세지");` : 단순 메시지 박스
 - `var value =prompt("메시지","기본값");` : 입력받은 값을 변수에 저장
 - `confirm("메시지")` : 사용자의 확인을 받을 경우

> HTML 요소에 접근 방법

 - id로 접근 : id는 중복 <strong>불가능</strong>
    ~~~html
    document.getElementById("태그의 id");
    ~~~

 - name으로 접근 : name은 중복 가능 (라디오)
    ~~~html
    document.getElementsByName("태그의 name");
    ~~~

> 배열

 - 배열 선언           
    
    ~~~html
    var fruits = ["apple","banana","peach"];

    var array = new Array();
    array[0] ="apple";
    array[1] ="banana";
    array[2] ="peach";
    ~~~

> 함수 
 
 - 함수 이름이 있는 경우
 ~~~html
 function 함수 이름(매개변수){
    //
 }
 ~~~

 - 함수 이름이 없는 경우
 ~~~html
 function(매개변수){

 }
 ~~~

 