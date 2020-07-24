package com.example.myapplication;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater mLayoutInflater;
    protected static final int TYPE_ONE = 1;
    protected static final int TYPE_TWO = 2;
    protected static final int TYPE_THREE = 3;

    public DemoAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    //存放各个list的type
    private List<Integer> types = new ArrayList<>();

    //存放各个list的大小，键是type，值是大小
    private Map<Integer,Integer> mPositions = new HashMap<>();

    private List<ItemOne> items1;
    private List<ItemTwo> items2;
    private List<ItemThree> items3;

    //使用此方法从mainactivity获取数据,这样就不用从构造方法里传数据了
    public void addList_ONE(List<ItemOne> itemOnes){
        addItemByType(TYPE_ONE,itemOnes);

        items1 = itemOnes;

    }
    public void addList_TWO(List<ItemTwo> itemTwos){
        addItemByType(TYPE_TWO,itemTwos);

        items2 = itemTwos;
    }
    public void addList_THREE(List<ItemThree> itemThrees){
        addItemByType(TYPE_THREE,itemThrees);

        items3 = itemThrees;
    }


    private void addItemByType(int type,List list){
        //注意传入的是types.size()
        mPositions.put(type,types.size());
        for (int i = 0; i < list.size(); i++) {
            types.add(type);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return types.get(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //根据不同的viewType，创建并返回相应的ViewHolder

        switch (viewType){
            case Item.TYPE_ONE:
                return new TypeOneHolder(mLayoutInflater.inflate(R.layout.item_type_one,parent,false));
            case Item.TYPE_TWO:
                return new TypeTwoHolder(mLayoutInflater.inflate(R.layout.item_type_two,parent,false));
            case Item.TYPE_THREE:
                return new TypeThreeHolder(mLayoutInflater.inflate(R.layout.item_type_three,parent,false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        //获取每个view在列表里相对位置
        int realPositions = position - mPositions.get(viewType);
        switch (viewType){
            case Item.TYPE_ONE:
                ((TypeOneHolder)holder).bindHolder(items1.get(realPositions));
                break;
            case Item.TYPE_TWO:
                ((TypeTwoHolder)holder).bindHolder(items2.get(realPositions));
                break;
            case Item.TYPE_THREE:
                ((TypeThreeHolder)holder).bindHolder(items3.get(realPositions));
                break;
        }

    }

    @Override
    public int getItemCount() {
        return types.size();
    }
}
