# Layout

> LinearLayout

  `orientation` : 뷰의 가로/세로를 지정


  ![linearlayout](https://user-images.githubusercontent.com/26784875/42209376-73713ad4-7ee9-11e8-9253-42706aabab50.png)  

  ~~~xml
  <?xml version="1.0" encoding="utf-8"?>
  <LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="100dp"
    android:orientation="horizontal"
    tools:context=".MainActivity">

    <ImageView
        android:padding="10dp"
        android:id="@+id/imageView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_weight="right"
        app:srcCompat="@mipmap/ic_launcher_round" />
    <LinearLayout
        android:padding="10dp"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:orientation="vertical">
        <TextView
            android:padding="10dp"
            android:layout_width="wrap_content"
            android:text="@string/textname"
            android:layout_height="wrap_content" />
        <TextView
            android:padding="10dp"
            android:layout_width="wrap_content"
            android:text="@string/textSome"
            android:layout_height="wrap_content" />

    </LinearLayout>
    <TextView
        android:layout_gravity="center_vertical"
        android:text="2018-07-03"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />
  </LinearLayout>
  ~~~


> FrameLayout

  레이아웃에 포함된 뷰들을 같은 영역에 겹쳐서 배치 가능

  ![frame](https://user-images.githubusercontent.com/26784875/42210932-39ac4fba-7eed-11e8-8f7a-83d29d4cd174.png)

  ~~~xml
  <?xml version="1.0" encoding="utf-8"?>
 <FrameLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

   <TextView
       android:background="#ff0000"
       android:layout_width="300dp"
       android:layout_height="300dp" />
    <TextView
        android:background="#00ff00"
        android:layout_width="200dp"
        android:layout_height="200dp" />
    <TextView
        android:background="#0000ff"
        android:layout_width="100dp"
        android:layout_height="100dp" />
  </FrameLayout>
  ~~~

> TabHost
  탭 전제 영역을 지칭

  ![screenshot_1530687693](https://user-images.githubusercontent.com/26784875/42261552-8e9b060e-7fa3-11e8-959c-79f49e5e1e4b.png)


  TabWidget : 탭 버튼이 들어갈 영역
  FrameLayout : 탭 버튼 클릭시 나올 화면 영역

  ~~~xml
  <?xml version="1.0" encoding="utf-8"?>
 <TabHost xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:id="@+id/host">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <TabWidget
            android:id="@android:id/tabs"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@color/colorPrimary"/>

        <FrameLayout
            android:id="@android:id/tabcontent"
            android:layout_width="match_parent"
            android:layout_height="match_parent">

            <TextView
                android:id="@+id/tab_content1"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:text="Tab 1"
                android:textSize="30dp"
                android:textStyle="bold"
                android:gravity="center"/>

            <TextView
                android:id="@+id/tab_content2"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:text="Tab 2"
                android:textSize="30dp"
                android:textStyle="bold"
                android:gravity="center"/>

            <TextView
                android:id="@+id/tab_content3"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:text="Tab 3"
                android:textSize="30dp"
                android:textStyle="bold"
                android:gravity="center"/>
        </FrameLayout>
    </LinearLayout>

  </TabHost>
  ~~~

  ~~~java
  package com.example.user.a4test;

  import android.content.res.Resources;
  import android.support.v4.content.res.ResourcesCompat;
  import android.support.v7.app.AppCompatActivity;
  import android.os.Bundle;
  import android.widget.TabHost;

  public class MainActivity extends AppCompatActivity {

      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);

          TabHost host=(TabHost)findViewById(R.id.host);
          host.setup();

          TabHost.TabSpec spec=host.newTabSpec("tab1");
          spec.setIndicator(null, ResourcesCompat.getDrawable(getResources(), R.drawable.ic_star_black_24dp, null));
          spec.setContent(R.id.tab_content1);
          host.addTab(spec);

          spec=host.newTabSpec("tab2");
          spec.setIndicator(null, ResourcesCompat.getDrawable(getResources(), R.drawable.ic_person_black_24dp, null));
          spec.setContent(R.id.tab_content2);
          host.addTab(spec);

          spec=host.newTabSpec("tab3");
          spec.setIndicator(null, ResourcesCompat.getDrawable(getResources(), R.drawable.ic_access_time_black_24dp, null));
          spec.setContent(R.id.tab_content3);
          host.addTab(spec);

      }
  }
  ~~~
