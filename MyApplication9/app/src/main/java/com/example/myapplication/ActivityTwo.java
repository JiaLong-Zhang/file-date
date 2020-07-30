package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityTwo extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);


        TextView title=(TextView) findViewById(R.id.contentTitle);
        TextView content=(TextView) findViewById(R.id.content);

        Intent intent = getIntent();
        title.setText(intent.getStringExtra("title"));
        content.setText(intent.getStringExtra("content"));
    }

    public static void actionStart(Context context, String title, String content) {
        Intent intent = new Intent(context, ActivityTwo.class);   //创建intent实例
        intent.putExtra("title",title);
        intent.putExtra("content",content);
        //放入要传递的参数
        context.startActivity(intent);
    }

}