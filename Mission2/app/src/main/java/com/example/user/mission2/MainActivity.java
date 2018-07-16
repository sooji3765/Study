package com.example.user.mission2;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView closeButton;
    ImageView saveButton;
   // Button gallerButton;
    //Button colorButton;
    //Button sortButton;

    EditText textTitle;
    EditText textTitle2;
    EditText contentText;

    AlertDialog dialogClose;
    AlertDialog dialogSave;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        closeButton = findViewById(R.id.closeButton);
        saveButton = findViewById(R.id.saveButton);
        //gallerButton = findViewById(R.id.grallerButton);
        //colorButton = findViewById(R.id.colorButton);
        //sortButton = findViewById(R.id.sortButton);

        textTitle = (EditText) findViewById(R.id.textTitle);
        textTitle2 =(EditText) findViewById(R.id.textTitle2);
        contentText = (EditText)findViewById(R.id.editText);

        closeButton.setOnClickListener(this);
        saveButton.setOnClickListener(this);

    }

    DialogInterface.OnClickListener dialogListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (dialog == dialogClose&&which==DialogInterface.BUTTON_POSITIVE){

                finish();

            }else if (dialog == dialogSave&&which==DialogInterface.BUTTON_POSITIVE&&onCheckText()==true){

                    Intent intent = new Intent(MainActivity.this,ContentActivity.class);

                    intent.putExtra("title",textTitle.getText().toString());
                    intent.putExtra("title2",textTitle2.getText().toString());
                    intent.putExtra("content",contentText.getText().toString());
                    startActivity(intent);
                    finish();


            }
        }
    };

    @Override
    public void onClick(View v) {
        if (v == closeButton){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("작성중인 내용을 저장하지 않고 나가시겠습니까?");
            builder.setPositiveButton("OK",dialogListener);
            builder.setNegativeButton("취소",null);

            dialogClose = builder.create();
            dialogClose.show();
        }else if (v == saveButton){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("저장 하시겠습니까?");
            builder.setPositiveButton("OK",dialogListener);
            builder.setNegativeButton("취소",null);

            dialogSave = builder.create();
            dialogSave.show();

        }
    }

    public boolean onCheckText(){
        boolean checkEmpty;
        Log.i("textSize",textTitle.getTextSize()+"");
        if (textTitle.getTextSize()>0&&textTitle2.getTextSize()>0&&contentText.getTextSize()>0) {
            checkEmpty = true;
        } else {
            checkEmpty = false;
        }
        return checkEmpty;
    }
}
