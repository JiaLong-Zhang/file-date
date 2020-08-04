package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.List;

public class ActivityOne extends Activity {

    public RecyclerView recyclerView;

    public ActivityClass activityClass=new ActivityClass();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        Intent intent = getIntent();
        activityClass.setTitle(intent.getStringExtra("title"));
        activityClass.setContent(intent.getStringExtra("content"));
        activityClass.setImageId(intent.getExtras().getInt("imageId"));

        recyclerView = findViewById(R.id.recyclerView_activityOne);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        AdapterActivityOne myAdapter = new AdapterActivityOne(activityClass);
        myAdapter.initList();
        recyclerView.setAdapter(myAdapter);
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
