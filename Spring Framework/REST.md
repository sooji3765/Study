# REST URI

> REST : REpresentational State Transter

  - 하나의 uri가 하나의 고유한 리소스를 대표하도록 설계된 개념

> REST 방식이 아닌 파라미터로 표시되는 uri

  http://localhost:8080/spring02/reply/list?bno=1
  http://localhost:8080/spring02/reply/list?bno=2
  http://localhost:8080/spring02/reply/list?bno=3

> REST 방식

  http://localhost:8080/spring02/reply/list/1
  http://localhost:8080/spring02/reply/list/2
  http://localhost:8080/spring02/reply/list/3

> ResponseEntity

- 컨트롤러를 호출하여 데이터와 http 상태 코드를 동시에 리턴 가능

// ResponseEntity<T> : Http Status Code + 데이터 전달
//RequestBody : 클라이언트->서버  (json 데이터가 입력될때)
//ResponseBody : 서버-> 클라이언트(json)

> 컨트롤러에 json 데이터를 전달하는 테스트를 위해 크롬에 확장 프로그램 설치

https://chrome.google.com/webstore/detail/advanced-rest-client/hgmloofddffdnphfgcellkdfbfbjeloo?hl=ko

> http 응답 코드

![http](https://slidesplayer.org/slide/11188122/60/images/18/02.+HTTP+HTTP+%EC%83%81%ED%83%9C+%EC%BD%94%EB%93%9C+%EC%9D%BC%EB%B0%98%EC%A0%81%EC%9D%B8+%EC%9B%B9+%EC%84%9C%EB%B2%84+%EC%83%81%ED%83%9C+%EC%BD%94%EB%93%9C+%EC%9B%B9+%EC%84%9C%EB%B2%84+%EC%83%81%ED%83%9C+%EC%BD%94%EB%93%9C+%ED%95%A8%EC%B6%95%EC%A0%81+%EC%9D%98%EB%AF%B8+%EB%82%B4%EC%9A%A9+100%EB%B2%88+%EB%8C%80+%EC%A0%95%EB%B3%B4+%EC%A0%84%EC%86%A1.jpg)


> http method

![fsdf](https://image.slidesharecdn.com/20170331-170213130033/95/-16-638.jpg?cb=1488171623)
