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

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class MyAdapterOne extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<ActivityClass> list;

    public static final int TYPE_1=1;
    public static final int TYPE_2=2;
    public static final int TYPE_3=3;

    public MyAdapterOne(List<ActivityClass> list){
        this.list=list;
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


                horlder1.dislike.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (list.size() == 1) {
                            Toast.makeText(view.getContext(), "此条目不能删除", Toast.LENGTH_SHORT).show();
                        } else {
                            int k=horlder1.getAdapterPosition();
                            //               删除自带默认动画
                            removeData(k);
                        }
                    }
                });


                horlder1.like.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ImageView like=view.findViewById(R.id.like);
                        int k=horlder1.getAdapterPosition();
                        ActivityClass activityClass=list.get(k);

                        if(activityClass.getLikeCondition()==0){
                            like.setImageResource(R.drawable.love_press);
                            activityClass.setLikeCondition(1);
                        }
                        else {
                            like.setImageResource(R.drawable.love_normal);
                            activityClass.setLikeCondition(0);
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
                        ActivityClass activityClass=list.get(k);
                        ActivityTwo.actionStart(horlder2.viewTwo.getContext(),activityClass.getTitle(),activityClass.getContent());
                    }
                });

                horlder2.dislike.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (list.size() == 1) {
                            Toast.makeText(view.getContext(), "此条目不能删除", Toast.LENGTH_SHORT).show();
                        } else {
                            int k=horlder2.getAdapterPosition();
                            //               删除自带默认动画
                            removeData(k);
                        }
                    }
                });

                horlder2.like.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ImageView like=view.findViewById(R.id.like);
                        int k=horlder2.getAdapterPosition();
                        ActivityClass activityClass=list.get(k);

                        if(activityClass.getLikeCondition()==0){
                            like.setImageResource(R.drawable.love_press);
                            activityClass.setLikeCondition(1);
                        }
                        else {
                            like.setImageResource(R.drawable.love_normal);
                            activityClass.setLikeCondition(0);
                        }

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
                    ActivityThree.actionStart(horlder3.viewThree.getContext(),activityClass.getTitle(),activityClass.getContent(),activityClass.getVideoUri());
                }
            });

                horlder3.dislike.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (list.size() == 1) {
                            Toast.makeText(view.getContext(), "此条目不能删除", Toast.LENGTH_SHORT).show();
                        } else {
                            int k=horlder3.getAdapterPosition();
                            //               删除自带默认动画
                            removeData(k);
                        }
                    }
                });

                horlder3.like.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ImageView like=view.findViewById(R.id.like);
                        int k=horlder3.getAdapterPosition();
                        ActivityClass activityClass=list.get(k);

                        if(activityClass.getLikeCondition()==0){
                            like.setImageResource(R.drawable.love_press);
                            activityClass.setLikeCondition(1);
                        }

                        else {
                            like.setImageResource(R.drawable.love_normal);
                            activityClass.setLikeCondition(0);
                        }

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
        private final ImageView dislike;
        private final ImageView like;
        private final TextView title_One;


        public MyViewHorlder1(View itemView) {
            super(itemView);

            viewOne=itemView;
            title_One = (TextView) itemView.findViewById(R.id.title_One);
            avaterOne = (ImageView) itemView.findViewById(R.id.avaterOne);
            avaterTwo = (ImageView) itemView.findViewById(R.id.avaterTwo);
            avaterThree = (ImageView) itemView.findViewById(R.id.avaterThree);
            dislike = (ImageView) itemView.findViewById(R.id.dislike);
            like = (ImageView) itemView.findViewById(R.id.like);
        }
    }


    class MyVeiwHorlder2 extends RecyclerView.ViewHolder{
        private  View viewTwo;
        private final TextView title_two;
        private  final ImageView dislike;
        private  final ImageView like;

        public MyVeiwHorlder2(View itemView) {
            super(itemView);
            viewTwo=itemView;
            dislike=(ImageView) itemView.findViewById(R.id.dislike) ;
            like=(ImageView) itemView.findViewById(R.id.like) ;
            title_two = (TextView) itemView.findViewById(R.id.title_Two);

        }
    }


    class MyVeiwHorlder3 extends RecyclerView.ViewHolder{
        private  View viewThree;
        JCVideoPlayer jcVideoPlayerStandard;
        private final TextView title_three;
        private final ImageView dislike;
        private final ImageView like;

        public MyVeiwHorlder3(View itemView) {
            super(itemView);
            viewThree=itemView;
            jcVideoPlayerStandard = (JCVideoPlayerStandard) itemView.findViewById(R.id.video);
            title_three= (TextView) itemView.findViewById(R.id.title_Three);
            dislike=(ImageView) itemView.findViewById(R.id.dislike);
            like=(ImageView) itemView.findViewById(R.id.like);
        }
    }



    private void TYPE1(MyViewHorlder1 viewHorlder1,int position){

        ActivityClass activityClass=list.get(position);

        viewHorlder1.title_One.setText(activityClass.getTitle());
        viewHorlder1.dislike.setImageResource(R.drawable.dislike);
        viewHorlder1.like.setImageResource(R.drawable.love_normal);
        viewHorlder1.avaterOne.setImageResource(activityClass.getImageId());
        viewHorlder1.avaterTwo.setImageResource(activityClass.getImageId());
        viewHorlder1.avaterThree.setImageResource(activityClass.getImageId());


    }
    private void TYPE2(MyVeiwHorlder2 viewHorlder2,int position){

        ActivityClass activityClass=list.get(position);
        viewHorlder2.title_two.setText(activityClass.getTitle());
        viewHorlder2.dislike.setImageResource(R.drawable.dislike);
        viewHorlder2.like.setImageResource(R.drawable.love_normal);

    }

    private void TYPE3(MyVeiwHorlder3 viewHorlder3,int position){

        ActivityClass activityClass=list.get(position);
        viewHorlder3.title_three.setText(activityClass.getTitle());
        viewHorlder3.dislike.setImageResource(R.drawable.dislike);
        viewHorlder3.like.setImageResource(R.drawable.love_normal);
        viewHorlder3.jcVideoPlayerStandard.setUp(activityClass.getVideoUri(),JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"");
    }

    @Override
    public int getItemViewType(int position) {

     return list.get(position).getType();
    }

    public void removeData(int position) {

        list.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }


}


