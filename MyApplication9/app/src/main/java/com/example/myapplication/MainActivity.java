package com.example.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Fragment mTab01=new First_Fragment();
    private Fragment mTab02=new Second_Fragment();

    private FragmentManager fm;
    LinearLayout buttonOne;
    LinearLayout buttonTwo;

    ImageButton home;
    ImageButton like;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initFragment();
        initView();
        selectfragment(0);
        initEvent();


    }
    private void initEvent(){
        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);

    }
    private void initFragment(){
        fm = getFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        transaction.add(R.id.fragment_main,mTab01);
        transaction.add(R.id.fragment_main,mTab02);
        transaction.commit();
    }
    private void initView(){
        buttonOne=findViewById(R.id.bottomOne);
        buttonTwo = findViewById(R.id.buttonTwo);

        home = findViewById(R.id.home);
        like = findViewById(R.id.like);

    }

    private void hideFragment(FragmentTransaction transaction){
        transaction.hide(mTab01);
        transaction.hide(mTab02);

    }
    private void resetImgs(){
        home.setImageResource(R.drawable.evaluate_normal);
        like.setImageResource(R.drawable.atlas_normal);
    }
    private void selectfragment(int i){
        FragmentTransaction transaction=fm.beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 0:
                transaction.show(mTab01);
                home.setImageResource(R.drawable.evaluate_press);
                break;
            case 1:
                transaction.show(mTab02);
                like.setImageResource(R.drawable.atlas_press);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    public void onClick(View v){
        resetImgs();
        switch (v.getId()){
            case R.id.bottomOne:
                selectfragment(0);
                break;
            case R.id.buttonTwo:
                selectfragment(1);
                break;


        }
    }

}