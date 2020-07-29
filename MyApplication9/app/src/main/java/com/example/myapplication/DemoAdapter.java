package com.example.myapplication;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

    private int typeOne=0;
    private int typeTwo=0;
    private int typeThree=0;

    public DemoAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }
    //存放各个list的type
    private List<Integer> types = new ArrayList<>();
    //存放各个list的大小，键是type，值是大小
    private Map<Integer,Integer> mPositions = new HashMap<>();

    private List<ActivityOneClass> items1;
    private List<ActivityTwoClass> items2;
    private List<ActivityThreeClass> items3;

    //使用此方法从mainactivity获取数据,这样就不用从构造方法里传数据了
    public void addList_ONE(List<ActivityOneClass> itemOnes){
        addItemByType(TYPE_ONE,itemOnes);

        items1 = itemOnes;

    }
    public void addList_TWO(List<ActivityTwoClass> itemTwos){
        addItemByType(TYPE_TWO,itemTwos);

        items2 = itemTwos;
    }
    public void addList_THREE(List<ActivityThreeClass> itemThrees){
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
            case TYPE_ONE:

                View viewOne =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_one,parent,false);
                final TypeOneHolder horlder1=new TypeOneHolder(viewOne);

                horlder1.viewOne.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        ActivityOneClass activityClass=items1.get(0);
                        ActivityOne.actionStart(horlder1.viewOne.getContext(),activityClass.getTitle(),activityClass.getContent(),activityClass.getImageId());
                    }
                });


//                horlder1.dislike.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if (list1.size() == 1) {
//                            Toast.makeText(view.getContext(), "此条目不能删除", Toast.LENGTH_SHORT).show();
//                        } else {
//                            int k=horlder1.getAdapterPosition();
//                            //               删除自带默认动画
//                            removeData(k);
//
//                            for (int i=k;i<=list1.size()-1;i++){
//                                number[i]=number[i+1];
//                            }
//                        }
//                    }
//                });

//                horlder1.like.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Toast.makeText(view.getContext(), "此条目不能删除", Toast.LENGTH_SHORT).show();
//                    }
//                });
                return  horlder1;

            case TYPE_TWO:
                View viewTwo =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_two,parent,false);
                final TypeTwoHolder horlder2=new TypeTwoHolder(viewTwo);


                horlder2.viewTwo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        ActivityTwoClass activityClass=items2.get(0);
                        ActivityTwo.actionStart(horlder2.viewTwo.getContext(),activityClass.getTitle(),activityClass.getContent());
                    }
                });

//                horlder2.dislike.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if (list1.size() == 1) {
//                            Toast.makeText(view.getContext(), "此条目不能删除", Toast.LENGTH_SHORT).show();
//                        } else {
//                            int k=horlder2.getAdapterPosition();
//                            //               删除自带默认动画
//                            removeData(k);
//
//                            for (int i=k;i<=list1.size()-1;i++){
//                                number[i]=number[i+1];
//                            }
//                        }
//                    }
//                });
//
//
//                horlder2.like.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Toast.makeText(view.getContext(), "此条目不能删除", Toast.LENGTH_SHORT).show();
//                    }
//                });

                return  horlder2;

            case TYPE_THREE:
                View viewThree =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_three,parent,false);
                final TypeThreeHolder horlder3=new TypeThreeHolder(viewThree);
                horlder3.viewThree.setOnClickListener(new View.OnClickListener() {
                    @Override

                    public void onClick(View view) {

                        ActivityThreeClass activityClass=items3.get(0);
                        ActivityThree.actionStart(horlder3.viewThree.getContext(),activityClass.getTitle(),activityClass.getContent(),activityClass.getVideoUri());
                    }
                });

//                horlder3.dislike.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if (list1.size() == 1) {
//                            Toast.makeText(view.getContext(), "此条目不能删除", Toast.LENGTH_SHORT).show();
//                        } else {
//                            int k=horlder3.getAdapterPosition();
//                            //               删除自带默认动画
//                            removeData(k);
//
//                            for (int i=k;i<=list1.size()-1;i++){
//                                number[i]=number[i+1];
//                            }
//                        }
//                    }
//                });
//
//                horlder3.like.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Toast.makeText(view.getContext(), "此条目不能删除", Toast.LENGTH_SHORT).show();
//                    }
//                });
                return horlder3;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);       //获取每个view在列表里相对位置
        switch (viewType){
            case TYPE_ONE:
                ((TypeOneHolder)holder).bindHolder(items1.get(typeOne++));
                break;
            case TYPE_TWO:
                ((TypeTwoHolder)holder).bindHolder(items2.get(typeTwo++));
                break;
            case TYPE_THREE:
                ((TypeThreeHolder)holder).bindHolder(items3.get(typeThree++));
                break;
        }

    }

    @Override
    public int getItemCount() {
        return types.size();
    }
}
