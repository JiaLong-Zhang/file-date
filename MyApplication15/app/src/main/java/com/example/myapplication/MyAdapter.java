package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<ActivityOneClass> list1;
    private List<ActivityTwoClass> list2;
    private Context context;
    private int[] number;


    public static final int TYPE_1=1;
    public static final int TYPE_2=2;

    public MyAdapter(Context context){
        this.context=context;
    }

    private Map<Integer,Integer> mPositions = new HashMap<>();

    private List<Integer> types = new ArrayList<>();

    public void addTypeOne(List<ActivityOneClass> list){
        addItemByType(TYPE_1,list1);
        list1 = list;
    }

    public void addTypeTwo(List<ActivityTwoClass> list){

        addItemByType(TYPE_2,list);

        this.list2 = list;
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
        switch (viewType){
            case TYPE_1:
            View viewOne =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_one,parent,false);
            final MyViewHorlder1 horlder1=new MyViewHorlder1(viewOne);


            horlder1.viewOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int k=horlder1.getAdapterPosition();
                    ActivityOneClass activityClass=list1.get(k);
                    ActivityOne.actionStart(horlder1.viewOne.getContext(),activityClass.getTitle(),activityClass.getContent(),activityClass.getImageId());
                }
            });


                horlder1.dislike.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (list1.size() == 1) {
                            Toast.makeText(view.getContext(), "此条目不能删除", Toast.LENGTH_SHORT).show();
                        } else {
                            int k=horlder1.getAdapterPosition();
                            //               删除自带默认动画
                            removeData(k);

                            for (int i=k;i<=list1.size()-1;i++){
                                number[i]=number[i+1];
                            }
                        }
                    }
                });
            return  horlder1;


            case TYPE_2:
                View viewTwo =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_two,parent,false);
                final MyVeiwHorlder2 horlder2=new MyVeiwHorlder2(viewTwo);


                horlder2.viewTwo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int k=horlder2.getAdapterPosition();
                        ActivityOneClass activityClass=list1.get(k);
                        ActivityOne.actionStart(horlder2.viewTwo.getContext(),activityClass.getTitle(),activityClass.getContent(),activityClass.getImageId());
                    }
                });

                horlder2.dislike.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (list1.size() == 1) {
                            Toast.makeText(view.getContext(), "此条目不能删除", Toast.LENGTH_SHORT).show();
                        } else {
                            int k=horlder2.getAdapterPosition();
                            //               删除自带默认动画
                            removeData(k);

                            for (int i=k;i<=list1.size()-1;i++){
                                number[i]=number[i+1];
                            }
                        }
                    }
                });
                return  horlder2;
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);

        int realPositions = position - mPositions.get(viewType);
        if (holder instanceof MyViewHorlder1){
                TYPE1((MyViewHorlder1) holder,realPositions);
        }else
        {
                TYPE2((MyVeiwHorlder2) holder, realPositions);
            }
        }


    @Override
    public int getItemCount() {
        return types.size();


    }


    class MyViewHorlder1 extends RecyclerView.ViewHolder{
       private  View viewOne;
        private final ImageView avaterOne;
        private final ImageView avaterTwo;
        private final ImageView avaterThree;
        private final ImageView dislike;
        private final TextView title_One;

        public MyViewHorlder1(View itemView) {
            super(itemView);
            viewOne=itemView;
            title_One = (TextView) itemView.findViewById(R.id.title_One);
            avaterOne = (ImageView) itemView.findViewById(R.id.avaterOne);
            avaterTwo = (ImageView) itemView.findViewById(R.id.avaterTwo);
            avaterThree = (ImageView) itemView.findViewById(R.id.avaterThree);
            dislike = (ImageView) itemView.findViewById(R.id.dislike);
        }
    }


    class MyVeiwHorlder2 extends RecyclerView.ViewHolder{
        private  View viewTwo;
        private final TextView title_two;
        private  final ImageView dislike;

        public MyVeiwHorlder2(View itemView) {
            super(itemView);
            viewTwo=itemView;
            dislike=(ImageView) itemView.findViewById(R.id.dislike) ;
            title_two = (TextView) itemView.findViewById(R.id.title_Two);

        }
    }
    private void TYPE1(MyViewHorlder1 viewHorlder1,int position){

        ActivityOneClass activityClass=list1.get(position);

        viewHorlder1.title_One.setText(activityClass.getTitle());
        viewHorlder1.dislike.setImageResource(R.mipmap.dislike);
        viewHorlder1.avaterOne.setImageResource(activityClass.getImageId());
        viewHorlder1.avaterTwo.setImageResource(activityClass.getImageId());
        viewHorlder1.avaterThree.setImageResource(activityClass.getImageId());


    }
    private void TYPE2(MyVeiwHorlder2 viewHorlder2,int position){

        ActivityOneClass activityClass=list1.get(position);
        viewHorlder2.title_two.setText(activityClass.getTitle());
        viewHorlder2.dislike.setImageResource(R.mipmap.dislike);

    }



    public void removeData(int position) {

        list1.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }


}


