### UI

1. 액티비티 - 뷰 구조
  - 액티비티는 앱의 실행 단위 컴포넌트
  - 버튼, 문자열, 이미지 출력
  - 액티비티 내에서 화면 구성을 위한 적절한 뷰 클래스 출력
    ~~~java
    public void setContentView(View view)
    public void setContentView(int layoutResID)
    ~~~

  > 자바 코드로 화면 구성
  - 레이아웃 파일 자체를 만들지 않고 순수 자바 코드로 뷰를 직접 생성 가능

  ~~~java
  package com.example.user.testcode;

  import android.app.Activity;
  import android.os.Bundle;
  import android.support.annotation.Nullable;
  import android.widget.Button;
  import android.widget.LinearLayout;

  public class MainActivity extends Activity {
      @Override
      protected void onCreate(@Nullable Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);

          LinearLayout linearLayout = new LinearLayout(this);
          Button button = new Button(this);
          button.setText(" 버튼 1");

          linearLayout.addView(button);

          Button button2 = new Button(this);
          button2.setText(" 버튼 2");

          linearLayout.addView(button2);
          setContentView(linearLayout);

      }
  }
  ~~~

  > UI 기본 구조

  `margin`은 뷰와 뷰 사이의 간격
  `padding`은 뷰 내부에서 내용과 뷰의 테두리 간의 간격을 지정하는 속성


  ![margin](https://t1.daumcdn.net/cfile/tistory/1541B9394EE127C728)

  `clickable` : textView, ImageView 등에 클릭 이벤트가 발생하게 하는 속성
  `visibility` : 기본값 true , "invisible" ,"gone"으로 지정하여 화면에 안보이게 가능

  ~~~java
  public void onClick(View v){
    if (v==targetButton1) {
      targetButton.setVisibility(View.VISIBLE);
    }else if (v==targetButton2) {
      targetButton.setVisibility(View.INVISIBLE);
    }else {
      targetButton.setVisibility(View.GONE);
    }
  }

  ~~~

  > 뷰 계층 구조

  - DOM(Document Object Model) 구조와 Gof 디자인 패턴의 Composite 패턴 구조

  View 구조
  ![view](https://t1.daumcdn.net/cfile/tistory/15396A514E117B841D)

  View : 안드로이드 뷰 클래스의 최상위 클래스

  ViewGroup 구조
  ![viewgroup](https://t1.daumcdn.net/cfile/tistory/1464B2524E117B9926)

  ViewGroup : 다른뷰 여러 개를 뷰그룹에 포함하여 한번에 제어하기 위한 목적

  TextView : 특정 UI를 출력할 목적으로 제공되는 클래스
