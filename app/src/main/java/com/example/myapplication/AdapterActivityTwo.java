package com.example.myapplication;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class AdapterActivityTwo extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private ActivityClass activityClass;
    public List<ActivityClass> list;

    public static final int TYPE_1=1;
    public static final int TYPE_2=2;

    public AdapterActivityTwo(ActivityClass activityClass){
        this.activityClass= activityClass;

    }

    public void initList(){
        list=new ArrayList<>();
        list.add(activityClass);
        List<ActivityClass> list1=DataSupport.where("type=? and title!=?","2",activityClass.getTitle()).limit(5).find(ActivityClass.class);
        for (int i=0;i<list1.size();i++)
        {
                list.add(list1.get(i));

        }
//        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0)
        {
            return TYPE_1;
        }
        else {
            return TYPE_2;
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE_1:
                View viewOne =LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_two_1,parent,false);
                final MyViewHorlder1 horlder1=new MyViewHorlder1(viewOne);
            return  horlder1;

            case TYPE_2:
                View viewTwo =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_two_2,parent,false);
                final MyVeiwHorlder2 horlder2=new MyVeiwHorlder2(viewTwo);


                horlder2.viewTwo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int k=horlder2.getAdapterPosition();
                        ActivityClass activityClass=list.get(k);
                        ActivityTwo.actionStart(horlder2.viewTwo.getContext(),activityClass.getTitle(),activityClass.getContent());
                    }
                });

                horlder2.dislike.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                            int k=horlder2.getAdapterPosition();
                            //               删除自带默认动画
                            removeData(k);
                    }
                });
                return  horlder2;
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
            TYPE2((MyVeiwHorlder2) holder, position);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyViewHorlder1 extends RecyclerView.ViewHolder{

        private final TextView title;
        private final TextView content;

        public MyViewHorlder1(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.contentTitle);
            content = (TextView) itemView.findViewById(R.id.content);

        }
    }


    class MyVeiwHorlder2 extends RecyclerView.ViewHolder{
        private  View viewTwo;
        private final TextView title;
        private  final ImageView dislike;


        public MyVeiwHorlder2(View itemView) {
            super(itemView);
            viewTwo=itemView;
            dislike=(ImageView) itemView.findViewById(R.id.dislike) ;
            title = (TextView) itemView.findViewById(R.id.title_Two);
        }
    }

    private void TYPE1(MyViewHorlder1 viewHorlder1,int position){

        ActivityClass activityClass=list.get(position);

        viewHorlder1.title.setText(activityClass.getTitle());
        viewHorlder1.content.setText(activityClass.getContent());

    }

    private void TYPE2(MyVeiwHorlder2 viewHorlder2,int position){

        ActivityClass activityClass=list.get(position);
        viewHorlder2.title.setText(activityClass.getTitle());
        viewHorlder2.dislike.setImageResource(R.drawable.dislike);

    }

    public void removeData(int position) {
        list.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }
}