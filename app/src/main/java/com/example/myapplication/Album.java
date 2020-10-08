package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Album extends AppCompatActivity {

    private String string;
    private RecyclerView recyclerView;
    List<String> s = new ArrayList<>();

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        Intent intent = getIntent();
        string=intent.getStringExtra("string");

        File file=new File(string);
        File[] files=file.listFiles();
        if (files.length == 0){
            Toast.makeText(Album.this, "无照片", Toast.LENGTH_SHORT).show();}
        else {
            for(int i =0;i<files.length;i++) {
                s.add(string+File.separator+files[i].getName());
//            Log.d("aaa","12"+s.get(i));
            }
        }
        if(s!=null) {
            recyclerView = findViewById(R.id.recyclerView1);
            StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
            //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(manager);
            AdapterAlbum myAdapter = new AdapterAlbum(s);
            recyclerView.setAdapter(myAdapter);
        }

        button=findViewById(R.id.take_photo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CameraActivity.actionStart(Album.this,string);
            }
        });

    }

    public static void actionStart(Context context,String string) {
        Intent intent = new Intent(context, Album.class);   //创建intent实例
        //放入要传递的参数
        intent.putExtra("string",string);
        context.startActivity(intent);

    }
}