package com.example.customadapter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.customadapter.DTO.DriveDto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listView);


        DBHelper helper = new DBHelper(this);
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select title,date,type * from tb_drive",null);

        ArrayList<DriveDto> datas = new ArrayList<>();

        while (cursor.moveToNext()){
            DriveDto dto = new DriveDto();
            dto.setType(cursor.getString(3));
            dto.setTitle(cursor.getString(1));
            dto.setDate(cursor.getString(2));
            datas.add(dto);
        }
        sqLiteDatabase.close();

        DriveAdapter adapter = new DriveAdapter(this,R.layout.item_layout,datas);
        listView.setAdapter(adapter);
    }
}
