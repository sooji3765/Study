# SQLite을 이용한 영속화

  - 오픈소스인 관계형 데이터 베이스
  - 라이브러리를 이용하므로 데이터베이스는 애플리케이션의 일부로 통합
  - 데이터는 파일로 저장되며 `data/data/[package_name]/databases` 경로로 저장

> SQLiteDatabase 클래스

  데이터베이스의 데이터를 저장/수정/삭제하는 모든 질의문은 이 클래스의 함수를 이용
  ~~~java
  // openOrCreateDatabase() : 객체 얻기 , 첫번째 인자는 db파일명
  SQLiteDatabase db = openOrCreateDatabase("memodb",MODE_PRIVATE,null);
  ~~~

  #### SQL문 수행

  `execSQL(String sql)` : insert, update, delete 수행

  ~~~java
  db.execSQL("insert into tb_memo(title, content) values(?,?)", new String[]{title,content});
  ~~~

  `rawQuerey(String sql)` : select 문 수행

  번호 | 제목 | 내용
  -----|-----|-----
  1|title1|content1         


  ~~~java
  // cursor : 선택된 행
  Cursor cursor = db.rawQuerey("select title, content from tb_memo order by _id desc limit 1",null);

  while(cursor.moveToNext()){
    titleView.setText(cursor.getString(1)); // 첫번째 열
    contentView.setText(cursor.getString(2)); // 두번째 열
  }
  ~~~



> SQLiteOpenHelper 클래스

  - 테이블의 생성 , 스키마 변경등의 작업 일원화
  - `추상클래스`이므로 서브 클래스를 만들어 사용

 ~~~java
 public class DBhelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public DBhelper(Context context) {
        super(context, "memodb", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { // 앱설치후, 한번한 호출

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      // 버전 변경될때 마다 호출
    }

 } 
 ~~~

 실제 SQL문 실행

 ~~~java
 DBhelper helper = new DBhelper(this);
 SQLiteDatabase db = helper.getWritableDatabase();
 ~~~
