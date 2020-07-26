package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class ActivityThree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        TextView title=(TextView) findViewById(R.id.contentTitle);
        TextView content=(TextView) findViewById(R.id.content);
        JCVideoPlayerStandard contentvideo=(JCVideoPlayerStandard)findViewById(R.id.contentVideo);


        Intent intent = getIntent();
        title.setText(intent.getStringExtra("title"));
        content.setText(intent.getStringExtra("content"));
        contentvideo.setUp(intent.getStringExtra("videoUri"),JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"");
    }

    public static void actionStart(Context context, String title, String content, String videoUri) {
        Intent intent = new Intent(context, ActivityOne.class);   //创建intent实例
        intent.putExtra("title",title);
        intent.putExtra("content",content);
        intent.putExtra("videoUri",videoUri);
        //放入要传递的参数
        context.startActivity(intent);
    }

}