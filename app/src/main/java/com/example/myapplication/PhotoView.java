package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class PhotoView extends AppCompatActivity {

    public ActivityClass activityClass=new ActivityClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);
        Intent intent = getIntent();
        activityClass.setImageOneId(intent.getExtras().getInt("imageOneId"));
        com.bm.library.PhotoView photoView = findViewById(R.id.photoview);
        photoView.setImageResource(activityClass.getImageOneId());
        photoView.enable();

//        TouchImageView img = (TouchImageView) findViewById(R.id.image);
//        img.setImageResource(activityClass.getImageOneId());
//        img.setMaxZoom(4f);
    }


    public static void actionStart(Context context,int imageOneId) {
        Intent intent = new Intent(context, PhotoView.class);   //创建intent实例
        intent.putExtra("imageOneId",imageOneId);
        //放入要传递的参数
        context.startActivity(intent);
    }

}