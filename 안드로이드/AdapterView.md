# AdapterView

>  Adapter 와 AdapterView

1. AdapterView 구조
  - 항목을 나열하는 뷰
  - 하나의 뷰에 여러 데이터를 나열하고 그중 하나를 사용자에게 선택받는 뷰

  ##### 뷰 구조
  ![Adapter](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQiLtctSSYIozDDl2LusAFUyrlNSNwS-OajpjhrIj2sRWzdnhkK)


  ##### Adapter

  ![Adapter](http://mblogthumb3.phinf.naver.net/MjAxNzEyMTNfMTAy/MDAxNTEzMTUwMTc5NjE5.fqndKV4gA5fU7nCn45-gJOwB6-yrBT1PTedKZb22jtIg.HpfO6fc8IqW6iiIW_p4oWoRsf8U7FDWhqG7tKMP-_5Ig.PNG.gi_balja/Adapter.png?type=w800)


  ##### Adapter 활용
  `Adapter` <----완성---- `Adapter` <----이용---- `Activity`





2. 라이브러리의 Adapter

  ##### ArrayAdapter
  각 항목에 문자열 데이터를 순서대로 하나씩 나열할 때 사용


  ListView을 위해 제공되는 라이브러리의 xml파일
  - simple_list_item1 : 항목에 문자열 데이터 하나
  ![simple_list_item_1](https://user-images.githubusercontent.com/26784875/43193804-eaf920c2-903b-11e8-9732-12e87745a578.png)
  - simple_list_item2 : 항목에 문자열 데이터 두 개 위아래 나열
  - simple_list_item_multiple_choice : 문자열과 오른쪽 체크박스 제공
  ![simple_list_item_multi_choice](https://user-images.githubusercontent.com/26784875/43193805-eb251f06-903b-11e8-8645-81f5994983ea.png)
  - simple_list_item_single_choice : 문자열과 오른쪽 라디오 버튼


  ##### SimpleAdapter
  한 항목에 문자열 데이터를 여러 개 나열해야 하는 경우


  ~~~java
  package com.example.user.memoproject;

  import android.support.v7.app.AppCompatActivity;
  import android.os.Bundle;
  import android.widget.ArrayAdapter;
  import android.widget.ListView;
  import android.widget.SimpleAdapter;

  import java.util.ArrayList;
  import java.util.HashMap;

  public class Main2Activity extends AppCompatActivity {

      ListView listView;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main2);

          listView = findViewById(R.id.main_list);

          ArrayList<HashMap<String,String>> datas = new ArrayList<>();
          HashMap<String,String> map = new HashMap<>();
          map.put("name","안치홍");
          map.put("content","키스톤 콤비 짱!");
          datas.add(map);

          map = new HashMap<>();
          map.put("name","김선빈");
          map.put("content","작은거인 ~~~ ");
          datas.add(map);


          SimpleAdapter adapter = new SimpleAdapter(this,datas,android.R.layout.simple_list_item_2
                  ,new String[]{"name","content"} // HashMap에서 데이터를 추출할 키값
                  ,new int[]{android.R.id.text1 // 레이아웃 내부 뷰 id 값
                  ,android.R.id.text2});

          listView.setAdapter(adapter);

      }
  }
  ~~~

  ![screenshot_1532513086](https://user-images.githubusercontent.com/26784875/43194565-a0dfecc6-903d-11e8-8abd-5838cb1bdfd8.png)



> 커스텀 Adapter
  개발자가 직접 adapter를 만들어서 이용하는 방법

  ##### 직접 만들어 개발해야 하는 상황 3가지
  - 개발자 알고리즘대로 항목의 데이터가 설정되어야 할때
  - 개발자 알고리즘대로 항목별 뷰의 이벤트를 다르게 처리해야 할떼
  - 개발자 알고리즘대로 항목별 레이아웃을 다르게 적용해야 할때
