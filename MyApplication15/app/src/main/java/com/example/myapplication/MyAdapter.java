package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Created by shido on 2017/9/18.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<ActivityClass> list;
    private Context context;
    public static final int TYPE_1=1;
    public static final int TYPE_2=2;
    public static final int TYPE_3=3;
    public MyAdapter(Context context,List<ActivityClass> list){
        this.list=list;
        this.context=context;
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
                    ActivityClass activityClass=list.get(k);
                    ActivityOne.actionStart(horlder1.viewOne.getContext(),activityClass.getTitle(),activityClass.getContent(),activityClass.getImageId());
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
                        ActivityClass activityClass=list.get(k);
                        ActivityOne.actionStart(horlder2.viewTwo.getContext(),activityClass.getTitle(),activityClass.getContent(),activityClass.getImageId());
                    }
                });
                return  horlder2;
            case TYPE_3:
            View viewThree =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_three,parent,false);
            final MyVeiwHorlder3 horlder3=new MyVeiwHorlder3(viewThree);
            horlder3.viewThree.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int k=horlder3.getAdapterPosition();
                    ActivityClass activityClass=list.get(k);
                    ActivityOne.actionStart(horlder3.viewThree.getContext(),activityClass.getTitle(),activityClass.getContent(),activityClass.getImageId());
                }
            });
            return horlder3;
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHorlder1){
                TYPE1((MyViewHorlder1) holder,position);
        }else
        {
            if ( holder instanceof MyVeiwHorlder2) {
            TYPE2((MyVeiwHorlder2) holder, position);
                    }
            else {
                TYPE3((MyVeiwHorlder3) holder, position);
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyViewHorlder1 extends RecyclerView.ViewHolder{
       private  View viewOne;
        private final ImageView avaterOne;
        private final ImageView avaterTwo;
        private final ImageView avaterThree;
        private final TextView title_One;


        public MyViewHorlder1(View itemView) {
            super(itemView);

            viewOne=itemView;
            title_One = (TextView) itemView.findViewById(R.id.title_One);
            avaterOne = (ImageView) itemView.findViewById(R.id.avaterOne);
            avaterTwo = (ImageView) itemView.findViewById(R.id.avaterTwo);
            avaterThree = (ImageView) itemView.findViewById(R.id.avaterThree);
        }
    }


    class MyVeiwHorlder2 extends RecyclerView.ViewHolder{
        private  View viewTwo;
        private final TextView title_two;

        public MyVeiwHorlder2(View itemView) {
            super(itemView);
            viewTwo=itemView;
            title_two = (TextView) itemView.findViewById(R.id.title_Two);

        }
    }


    class MyVeiwHorlder3 extends RecyclerView.ViewHolder{
        private  View viewThree;
        private final TextView title_three;

        public MyVeiwHorlder3(View itemView) {
            super(itemView);
            viewThree=itemView;
            title_three= (TextView) itemView.findViewById(R.id.title_Three);

        }
    }



    private void TYPE1(MyViewHorlder1 viewHorlder1,int position){

        ActivityClass activityClass=list.get(position);

        viewHorlder1.title_One.setText(activityClass.getTitle());

        viewHorlder1.avaterOne.setImageResource(activityClass.getImageId());
        viewHorlder1.avaterTwo.setImageResource(activityClass.getImageId());
        viewHorlder1.avaterThree.setImageResource(activityClass.getImageId());



    }
    private void TYPE2(MyVeiwHorlder2 viewHorlder2,int position){

        ActivityClass activityClass=list.get(position);
        viewHorlder2.title_two.setText(activityClass.getTitle());

    }

    private void TYPE3(MyVeiwHorlder3 viewHorlder3,int position){

        ActivityClass activityClass=list.get(position);
        viewHorlder3.title_three.setText(activityClass.getTitle());

    }



    @Override
    public int getItemViewType(int position) {
        if (position%3==0) {
            return TYPE_1;
        }else {
            if(position%3==1) {
                return TYPE_2;
            }
            else {
                return TYPE_3;
            }
        }
    }
}
