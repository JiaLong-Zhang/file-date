package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class Creat_album extends AppCompatActivity {

    private Button button;
    private String text;
    private EditText edittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_album);

        edittext=(EditText)findViewById(R.id.edittext);

        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text=edittext.getText().toString();

                File pictureDir = Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                final String GalleryPath = pictureDir
                        + File.separator+ "MyCameraGallery" + File.separator+ text;
                File file = new File(GalleryPath);
                if (file.exists()){
                    Toast.makeText(Creat_album.this, "相册已经存在", Toast.LENGTH_SHORT).show();
                }else{
                    //创建一个新的文件
                    file=new File(GalleryPath);
                    file.mkdirs();
                    Toast.makeText(Creat_album.this, "创建成功", Toast.LENGTH_SHORT).show();
                    MainActivity.actionStart(Creat_album.this);
                }
            }
        });
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, Creat_album.class);   //创建intent实例
        //放入要传递的参数
        context.startActivity(intent);

    }

}