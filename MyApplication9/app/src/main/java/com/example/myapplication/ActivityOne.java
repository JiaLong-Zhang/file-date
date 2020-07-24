package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityOne extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

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
