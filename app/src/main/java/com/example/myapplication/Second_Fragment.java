package com.example.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class Second_Fragment extends Fragment {
    private View view;

    private RecyclerView recyclerView;

    public List<ActivityClass> list=new ArrayList<>();

    public MyAdapterTwo myAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        if (view==null){
            view=inflater.inflate(R.layout.fragemnt_second,null);
        }


        recyclerView = view.findViewById(R.id.recyclerView2);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        myAdapter = new MyAdapterTwo(list);
        recyclerView.setAdapter(myAdapter);

        return view;
    }

    public void getList(List<ActivityClass> list){
        myAdapter.setList(list);
    }
}
