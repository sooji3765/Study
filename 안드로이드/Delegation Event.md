# Delegation Event Model

  이벤트 프로그램 구조

  Event Source ---------------------> Event Handler
                    Listener

  - Event Source : 이벤트가 발생한 뷰 객체
  - Event Handler : 이벤트 처리 내용을 가지는 객체
  - 리스너 : 이벤트 소스와 이벤트 핸들러를 연결하는 작업

  [ example ]

  vibrateCheckBox ----------------------------> Event Handler
                      CheckedChangeListener

  ~~~java
  // 객체에 이벤트 발생
  vibrateCheckView.setCheckedChangeListener(new MyEventHandler())

  // 리스너로 등록된 핸들러 함수 실행
  class MyEventHandler implements CompoundButton.OnCheckedChangeListener{

    public void OnCheckedChanged(CompoundButton buttonView, boolean isChecked){
      //이벤트 처리 로직 작성
    }
  }
  ~~~

  이벤트 종류

  ![alttext](http://cfile6.uf.tistory.com/image/2403E34453509FDE2202C5)


  ##### 구현예제

  ![screenshot_1531735047](https://user-images.githubusercontent.com/26784875/42752867-32dfd9b2-892a-11e8-88eb-99606407058f.png)



  ~~~java
  package com.example.user.alarmapp;

  import android.support.v7.app.AppCompatActivity;
  import android.os.Bundle;
  import android.view.View;
  import android.widget.CheckBox;
  import android.widget.CompoundButton;
  import android.widget.Switch;
  import android.widget.TextView;
  import android.widget.Toast;

  public class MainActivity extends AppCompatActivity implements View.OnClickListener,CompoundButton.OnCheckedChangeListener{

      TextView bellTextView;
      TextView labelTextView;
      Switch aSwitch;
      CheckBox repeatCheckView;
      CheckBox virateCheckView;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);

          bellTextView = findViewById(R.id.bellText);
          labelTextView = findViewById(R.id.labelText);
          aSwitch = findViewById(R.id.switchChange);
          repeatCheckView = findViewById(R.id.checkBox);
          virateCheckView = findViewById(R.id.vibrate);

          bellTextView.setOnClickListener(this);
          labelTextView.setOnClickListener(this);

          aSwitch.setOnCheckedChangeListener(this);

          repeatCheckView.setOnCheckedChangeListener(this);
          virateCheckView.setOnCheckedChangeListener(this);
      }

      public void showToast(String message){

          Toast.makeText(getApplicationContext(), message,Toast.LENGTH_SHORT).show();
      }

      @Override
      public void onClick(View v) {

          if (v == bellTextView){
              showToast("bell text Click");
          }else if (v == labelTextView){
              showToast("label text Click");
          }
      }

      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

          if (buttonView == repeatCheckView){
              showToast("repeate is"+ isChecked);
          }else if (buttonView == virateCheckView){
              showToast("virate is"+ isChecked);
          }else if (buttonView == aSwitch){
              showToast("switch is"+ isChecked);
          }

      }
  }

  ~~~                    
