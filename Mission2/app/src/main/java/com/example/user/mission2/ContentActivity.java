package com.example.user.mission2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Intent intent= new Intent(this.getIntent());
        String title = intent.getStringExtra("title");
        String title2 = intent.getStringExtra("title2");
        String content = intent.getStringExtra("content");

        Log.i("title",title);

        TextView titleView = (TextView) findViewById(R.id.title);
        TextView titleView2 = (TextView) findViewById(R.id.title2);
        TextView contentView = (TextView) findViewById(R.id.content);

        titleView.setText(title);
        titleView2.setText(title2);
        contentView.setText(content);
    }
}
