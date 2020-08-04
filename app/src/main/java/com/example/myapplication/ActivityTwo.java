package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class ActivityTwo extends AppCompatActivity {

    public ActivityClass activityClass=new ActivityClass();
    public RecyclerView recyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Intent intent = getIntent();
        activityClass.setTitle(intent.getStringExtra("title"));
        activityClass.setContent(intent.getStringExtra("content"));

        recyclerView = findViewById(R.id.recyclerView_activityTwo);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        AdapterActivityTwo myAdapter = new AdapterActivityTwo(activityClass);
        myAdapter.initList();
        recyclerView.setAdapter(myAdapter);
    }

    public static void actionStart(Context context, String title, String content) {
        Intent intent = new Intent(context, ActivityTwo.class);   //创建intent实例
        intent.putExtra("title",title);
        intent.putExtra("content",content);
        //放入要传递的参数
        context.startActivity(intent);
    }

}