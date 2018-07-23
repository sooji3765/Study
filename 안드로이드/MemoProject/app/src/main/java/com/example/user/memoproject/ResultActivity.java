package com.example.user.memoproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView titleView;
    TextView contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        titleView = findViewById(R.id.titleResult);
        contentView = findViewById(R.id.contentResult);

        DBhelper helper = new DBhelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select title, content from tb_memo order by _id desc limit 1", null);

        while (cursor.moveToNext()) {
            titleView.setText("Title:" + cursor.getString(0));
            contentView.setText("Content:" + cursor.getString(1));
        }

        db.close();
    }
}
