package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class ActivityThree extends AppCompatActivity {
    public RecyclerView recyclerView;
    public ActivityClass activityClass=new ActivityClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        Intent intent = getIntent();
        activityClass.setTitle(intent.getStringExtra("title"));
        activityClass.setContent(intent.getStringExtra("content"));
        activityClass.setVideoUri(intent.getStringExtra("videoUri"));

        recyclerView = findViewById(R.id.recyclerView_activityThree);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        AdapterActivityThree myAdapter = new AdapterActivityThree(activityClass);
        myAdapter.initList();
        recyclerView.setAdapter(myAdapter);
    }

    public static void actionStart(Context context, String title, String content, String videoUri) {
        Intent intent = new Intent(context, ActivityThree.class);   //创建intent实例
        intent.putExtra("title",title);
        intent.putExtra("content",content);
        intent.putExtra("videoUri",videoUri);
        //放入要传递的参数
        context.startActivity(intent);
    }
}