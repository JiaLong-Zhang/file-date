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
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<ActivityOneClass> list1;
    private List<ActivityTwoClass> list2;
    private List<ActivityThreeClass> list3;

    private int typeOne=0;
    private int typeTwo=0;
    private int typeThree=0;

    private List<Integer> types=new ArrayList<>();
    private Context context;
    private int size;
    private int[] number;


    public static final int TYPE_1=1;
    public static final int TYPE_2=2;
    public static final int TYPE_3=3;

    public MyAdapter(Context context, List<ActivityOneClass> list1,List<ActivityTwoClass>list2,List<ActivityThreeClass>list3){
        this.list1=list1;
        this.list2=list2;
        this.list3=list3;
        this.context=context;
    }

    public void addItemOne(List<ActivityOneClass> list){
        for (int i=0;i<list.size();i++){
            types.add(TYPE_1);
        }
    }

    public void addItemTwo(List<ActivityTwoClass> list){
        for (int i=0;i<list.size();i++){
            types.add(TYPE_2);
        }
    }

    public void addItemThree(List<ActivityThreeClass> list){
        for (int i=0;i<list.size();i++){
            types.add(TYPE_3);
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
                    ActivityOneClass activityClass=list1.get(typeOne);
                    typeOne++;
                    ActivityOne.actionStart(horlder1.viewOne.getContext(),activityClass.getTitle(),activityClass.getContent(),activityClass.getImageId());
                }
            });


//                horlder1.dislike.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if (types.size() == 1) {
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
            return  horlder1;


            case TYPE_2:
                View viewTwo =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_two,parent,false);
                final MyVeiwHorlder2 horlder2=new MyVeiwHorlder2(viewTwo);


                horlder2.viewTwo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ActivityTwoClass activityClass=list2.get(typeTwo);
                        typeTwo++;
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
                return  horlder2;


            case TYPE_3:
            View viewThree =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_three,parent,false);
            final MyVeiwHorlder3 horlder3=new MyVeiwHorlder3(viewThree);
            horlder3.viewThree.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View view) {
                    ActivityThreeClass activityClass=list3.get(typeThree);
                    typeThree++;
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
            return horlder3;
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHorlder1){
                TYPE1((MyViewHorlder1) holder,typeOne-1);
        }else
        {
            if ( holder instanceof MyVeiwHorlder2) {
            TYPE2((MyVeiwHorlder2) holder, typeTwo-1);
                    }
            else {
                TYPE3((MyVeiwHorlder3) holder, typeThree-1);
            }
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


    class MyVeiwHorlder3 extends RecyclerView.ViewHolder{
        private  View viewThree;
        JCVideoPlayer jcVideoPlayerStandard;
        private final TextView title_three;
        private final ImageView dislike;

        public MyVeiwHorlder3(View itemView) {
            super(itemView);
            viewThree=itemView;
            jcVideoPlayerStandard = (JCVideoPlayerStandard) itemView.findViewById(R.id.video);
            title_three= (TextView) itemView.findViewById(R.id.title_Three);
            dislike=(ImageView) itemView.findViewById(R.id.dislike);
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

        ActivityTwoClass activityClass=list2.get(position);

        viewHorlder2.title_two.setText(activityClass.getTitle());
        viewHorlder2.dislike.setImageResource(R.mipmap.dislike);

    }

    private void TYPE3(MyVeiwHorlder3 viewHorlder3,int position){

        ActivityThreeClass activityClass=list3.get(position);

        viewHorlder3.title_three.setText(activityClass.getTitle());
        viewHorlder3.dislike.setImageResource(R.mipmap.dislike);
        viewHorlder3.jcVideoPlayerStandard.setUp(activityClass.getVideoUri(),JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"");
    }




    public void removeData(int position) {

        list1.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }
}


