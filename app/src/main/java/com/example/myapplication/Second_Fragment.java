package com.example.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class Second_Fragment extends Fragment {
    private View view;

    private RecyclerView recyclerView;

    public List<ActivityClass> list=new ArrayList<>();

    public AdapterLike myAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        if (view==null){
            view=inflater.inflate(R.layout.fragemnt_second,null);
        }


        recyclerView = view.findViewById(R.id.recyclerView2);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        myAdapter = new AdapterLike(list);
        recyclerView.setAdapter(myAdapter);

        return view;
    }

    public void getList(List<ActivityClass> list){
        myAdapter.setList(list);
    }
}
