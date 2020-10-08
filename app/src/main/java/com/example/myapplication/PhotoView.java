package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.io.File;

public class PhotoView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);


        Intent intent = getIntent();
        com.github.chrisbanes.photoview.PhotoView photoView = findViewById(R.id.photoview);
        photoView.setImageURI(Uri.fromFile(new File(intent.getExtras().getString("picturePath"))));
    }

    public static void actionStart(Context context, String picturePath) {
        Intent intent = new Intent(context, PhotoView.class);   //创建intent实例
        intent.putExtra("picturePath",picturePath);
        //放入要传递的参数
        context.startActivity(intent);
    }

}