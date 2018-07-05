# 사용자 알림

> 진동, 소리 울리기

~~~xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.user.a4test">
    <!-- 진동 퍼미션 설정-->
    <uses-permission android:name="android.permission.VIBRATE"/>

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
~~~  
~~~java
package com.example.user.a4test;

import android.content.res.Resources;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1;
    Button button2;
    Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    public void onClick(View v){
        if (v==button1){
            Vibrator vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
            vibrator.vibrate(1000);

            // 진동 반복
            /*vibrator.vibrate(new long[]{500,1000,500,1000},-1);*/

        }else if (v == button2){
            // 안드로이드 스마트폰 기본 내장 효과능
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(),notification);
            ringtone.play();

        }else {
            // 개발자 임의의 효과음
            MediaPlayer player = MediaPlayer.create(this,R.raw.fallbackring);
            player.start();
        }
    }

}
~~~

~~~xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <Button
        android:text="진동"
        android:onClick="button1"
        android:id="@+id/button1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <Button
        android:text="사운드"
        android:onClick="button2"
        android:id="@+id/button2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <Button
        android:text="커스텀 사운드"
        android:onClick="button3"
        android:id="@+id/button3"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
</LinearLayout>

~~~



> 다이얼로그

  1. 토스트 : 검정 바탕의 흰색 글이 잠깐 보이다가 사라지는 다이얼로그

  ![tost](http://cfile29.uf.tistory.com/image/27310A4D558C03BD0B5F07)
  - makeText(Context context, int resId, int duration)
  - makeText(Context context, CharSequence text, int duration)

  2. AlertDialog : 알림창

  ![alert](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCVSVu9kTA6OFoHn2wluE5mmum_f9vjkTVfbuN7yq8-TheRnrR)
  - `Builder` 클래스로 생성
    AlertDialog.Builder builder = new AlertDialog.Builder(this);

  - `setter` 메서드를 이용하여 다이얼로그 구성
    setIcon : 타이틀 영역의 아이콘 지정
    setMessage : 본문을 단순 문자열로 구성
    setTitle : 타이틀 문자열 지정

  - `button`
    setPositiveButton
    setNegativeButton
    setNeutralButton

  3. 목록 다이얼로그 : AlertDialog 의 본문 영역을 문자열 배열로 지정

  ![selectItem](https://t1.daumcdn.net/cfile/tistory/22504D495539761F2D)

  - `setItems`
    builder.setItems(R.array.dialog_array, dialogListener);

  - `setMultiChoiceItems` : 여러개 선택
  - `setSingleChoiceItems`  : 하나만 선택

  4. ProgressDialog
  ![progress](https://antonioleiva.com/wp-content/uploads/2017/04/alert-anko-kotlin-4-e1477125509982.png)

  - `setIndeterminate`
  - `setProgressNumberFormat`
  - `setProgressPercentFormat`

  5. TimePickerDialog , DatePickerDialog : 시간,날짜 선택

  ![date](https://inducesmile.com/wp-content/uploads/2016/06/datepicker.jpg)
    DatePickerDialog datedialog = new DatePickerDialog(this,null,year,month,day);

  6. 커스텀 다이얼로그 : 개발자가 원하는 임의의 화면을 다이얼로그

  - AlertDialog 화면에 개발자가 구성한 뷰를 지정

  ~~~java
  LayoutInflater inflater= (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
  View view = inflater.inflate(R.layout.dialog_custom,null);
  builder.setView(view);
  ~~~


> 다이얼로그 사용 예

  ~~~java
  package com.example.user.a4test;

  import android.app.DatePickerDialog;
  import android.app.ProgressDialog;
  import android.app.TimePickerDialog;
  import android.content.DialogInterface;
  import android.content.res.Resources;
  import android.media.MediaPlayer;
  import android.media.Ringtone;
  import android.media.RingtoneManager;
  import android.net.Uri;
  import android.os.Vibrator;
  import android.support.v4.content.res.ResourcesCompat;
  import android.support.v7.app.AlertDialog;
  import android.support.v7.app.AppCompatActivity;
  import android.os.Bundle;
  import android.view.LayoutInflater;
  import android.view.View;
  import android.widget.Button;
  import android.widget.DatePicker;
  import android.widget.TabHost;
  import android.widget.TimePicker;
  import android.widget.Toast;

  import java.util.Calendar;

  public class MainActivity extends AppCompatActivity implements View.OnClickListener {

      Button button1;
      Button button2;
      Button button3;
      Button button4;
      Button button5;
      Button button6;

      AlertDialog customDialog;
      AlertDialog listDialog;
      AlertDialog alertDialog;
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);

          button1 = (Button)findViewById(R.id.button1);
          button2 = (Button)findViewById(R.id.button2);
          button3 = (Button)findViewById(R.id.button3);
          button4 = (Button)findViewById(R.id.button4);
          button5 = (Button)findViewById(R.id.button5);
          button6 = (Button)findViewById(R.id.button6);

          button1.setOnClickListener(this);
          button2.setOnClickListener(this);
          button3.setOnClickListener(this);
          button4.setOnClickListener(this);
          button5.setOnClickListener(this);
          button6.setOnClickListener(this);


      }

      public void showMessage(String message){
          Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
      }

      DialogInterface.OnClickListener dialogListener = new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
             if (dialog==customDialog&&which==DialogInterface.BUTTON_POSITIVE){
                 showMessage("custom dialog 확인");
             }else if (dialog==listDialog&& which==DialogInterface.BUTTON_POSITIVE){
                 String[] datas = getResources().getStringArray(R.array.dialog_array);
                 showMessage(datas[which]+"선택했습니다.");
             }else if (dialog == alertDialog && which ==DialogInterface.BUTTON_POSITIVE) {
                  showMessage("alert DIALOG OK");
             }
          }
      };

      @Override
      public void onClick(View v) {

          if (v==button1){
              AlertDialog.Builder builder = new AlertDialog.Builder(this);
              builder.setTitle("알림");
              builder.setMessage("종료 하시겠습니까?");
              builder.setPositiveButton("OK",dialogListener);
              builder.setNegativeButton("CANCEL",null);

              alertDialog = builder.create();
              alertDialog.show();

          }else if (v==button2){

              AlertDialog.Builder builder = new AlertDialog.Builder(this);
              builder.setTitle("과일을 선택하세요");
              builder.setSingleChoiceItems(R.array.dialog_array,0,dialogListener);
              builder.setPositiveButton("OK",null);
              builder.setNegativeButton("취소",null);

              listDialog = builder.create();
              listDialog.show();
          }else if (v == button3){
              ProgressDialog progressDialog = new ProgressDialog(this);
              progressDialog.setIcon(R.drawable.ic_access_time_black_24dp);
              progressDialog.setTitle("wait");
              progressDialog.setMessage("서비 연동중입니다.");
              progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
              progressDialog.setIndeterminate(true);

              progressDialog.show();

          }else if (v == button4){
              Calendar calendar = Calendar.getInstance();
              int year = calendar.get(Calendar.YEAR);
              int month = calendar.get(Calendar.MONTH);
              int day = calendar.get(Calendar.DAY_OF_MONTH);

              DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                  @Override
                  public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                      showMessage(year+"."+(month+1)+"."+dayOfMonth);
                  }
              },year,month,day);
              datePickerDialog.show();
          }else if (v == button5){

              Calendar calendar = Calendar.getInstance();
              final int hour = calendar.get(Calendar.HOUR_OF_DAY);
              int minute = calendar.get(Calendar.MINUTE);
              TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                  @Override
                  public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                      showMessage(hourOfDay+":"+minute);
                  }
              },hour,minute,false);

              timePickerDialog.show();

          }else{
              AlertDialog.Builder builder = new AlertDialog.Builder(this);

              LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
              View view = inflater.inflate(R.layout.dialog_custom,null);
              builder.setView(view);

              builder.setPositiveButton("확인",dialogListener);
              builder.setNegativeButton("취소",null);

              customDialog = builder.create();
              customDialog.show();
          }


      }
  }

  ~~~          
