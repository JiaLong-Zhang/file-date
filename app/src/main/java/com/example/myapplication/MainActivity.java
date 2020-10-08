package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button creat_album;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestPermission();
        File pictureDir = Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String GalleryPath = pictureDir
                + File.separator + "MyCameraGallery";

        File file=new File(GalleryPath);
        File[] files=file.listFiles();
        if (files==null ){
            Toast.makeText(MainActivity.this, "无相册", Toast.LENGTH_SHORT).show();}
        else {
            List<String> s = new ArrayList<>();
            for (int i = 0; i < files.length; i++) {
                s.add(files[i].getName());
//            Log.d("aaa","12"+s.get(i));
            }
            recyclerView = findViewById(R.id.recyclerView1);
            StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
            //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(manager);

            AdapterHome myAdapter = new AdapterHome(s);
            recyclerView.setAdapter(myAdapter);
        }

        creat_album=findViewById(R.id.creat_album);
        creat_album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Creat_album.actionStart(MainActivity.this);
            }
        });
    }

    void requestPermission(){
        final int REQUEST_CODE = 1;
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                            Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_CODE);
        }
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, MainActivity.class);   //创建intent实例
        //放入要传递的参数
        context.startActivity(intent);
    }

}