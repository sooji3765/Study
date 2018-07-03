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

  ![frame](https://user-images.githubusercontent.com/26784875/42210932-39ac4fba-7eed-11e8-8f7a-83d29d4cd174.png){: width="100" height="100"}

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

> TableLayout


> GridLayout


> ConstraintLayout
