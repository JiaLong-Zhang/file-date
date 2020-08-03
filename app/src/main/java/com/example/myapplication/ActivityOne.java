package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityOne extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);


        TextView title=(TextView) findViewById(R.id.contentTitle);
        TextView content=(TextView) findViewById(R.id.content);
        ImageView image=(ImageView) findViewById(R.id.contentImage);



        Intent intent = getIntent();

        title.setText(intent.getStringExtra("title"));
        content.setText(intent.getStringExtra("content"));
        image.setImageResource(intent.getExtras().getInt("imageId"));
    }

    public static void actionStart(Context context, String title,String content,int imageId) {

        Intent intent = new Intent(context, ActivityOne.class);   //创建intent实例
       intent.putExtra("title",title);
        intent.putExtra("content",content);
        intent.putExtra("imageId",imageId);
       //放入要传递的参数
            context.startActivity(intent);
    }

}
