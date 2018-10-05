## File 저장

- ` enctype="multipart/form-data"` : 파일 저장시 꼭 적어야함
~~~html
<%@ include file="../include/memu.jsp" %>
<form action="${path}/upload/uploadForm" metho="post"
	enctype="multipart/form-data" target="iframe1">
	<input type="file" name="file">
	<input type="submit" value="업로드">
</form>
~~~


### 파일이름 중복 방지 방법

##### UUID

- Universal Unique IDentifier, 범용고유식별자

~~~java
  // post방식 , 업로드된 내용을 처리
  // MultipartFile : 업로드한 파일이 저장 , 임시 경로로 저장
  @RequestMapping(value="/upload/uploadForm", method=RequestMethod.POST)
  public ModelAndView uploadFrom(MultipartFile file, ModelAndView mav) throws Exception{

    // 클라이언트가 업로드한 파일 이름 가져오기
    String savedName = file.getOriginalFilename();
    savedName = uploadFile(savedName, file.getBytes());
    mav.setViewName("upload/uploadResult");
    mav.addObject("savedName",savedName);
    return mav;
  }


  String uploadFile(String originalName, byte[] bytes) throws Exception{

    // 중복파일 네임 걸러내기
    // 랜덤하게 고유한 아이디 발급
    // Universal Unique IDentifier, 범용고유식별자
    UUID uid = UUID.randomUUID();

    // 새로운 파일 네임 생성
    String savedName = uid.toString()+"_"+originalName;

    // new file (디렉토리, 파일명)
    File target = new File(uploadPath,savedName);

    // 첨부파일을 임시디렉토리에서 우리가 지정한 디렉토리 복사
    FileCopyUtils.copy(bytes, target);

    return savedName;

  }

~~~

#### 타임스탬프
- 1970.1.1 ~ 현재 밀리세컨드

#### 파일네임검사- 번호 부여
- 테이블에 저장된 파일 이름 검색
