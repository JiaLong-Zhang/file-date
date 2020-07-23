package com.example.firstapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_1 extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        Bundle bundle=getIntent().getExtras();
        int id=bundle.getInt("photo");
        String message=bundle.getString("message");
        String name=bundle.getString("name");

        ImageView Iv=(ImageView) findViewById(R.id.imageView2);
        Iv.setImageResource(id);

        TextView tv=(TextView) findViewById(R.id.textView4);
        tv.setText(message);

        TextView ti=(TextView) findViewById(R.id.textView3);
        ti.setText(name);

    }

}
