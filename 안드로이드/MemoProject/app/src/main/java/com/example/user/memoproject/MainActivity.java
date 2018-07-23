package com.example.user.memoproject;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText title ;
    EditText content;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (EditText) findViewById(R.id.title);
        content = (EditText) findViewById(R.id.content);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("title",title.getText().toString());
        contentValues.put("content",content.getText().toString());

        DBhelper dBhelper = new DBhelper(this);
        SQLiteDatabase db = dBhelper.getWritableDatabase();

        db.insert("tb_memo",null,contentValues);
        db.close();

        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
        finish();
    }
}
