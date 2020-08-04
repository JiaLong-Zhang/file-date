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

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class AdapterActivityThree extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private ActivityClass activityClass;
    public List<ActivityClass> list;

    public static final int TYPE_1=1;
    public static final int TYPE_2=2;

    public AdapterActivityThree(ActivityClass activityClass){
        this.activityClass= activityClass;

    }

    public void initList(){
        list=new ArrayList<>();
        list.add(activityClass);
        List<ActivityClass> list1=DataSupport.where("type=? and title!=?","3",activityClass.getTitle()).limit(5).find(ActivityClass.class);
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
                View viewOne =LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_three_1,parent,false);
                final MyViewHorlder1 horlder1=new MyViewHorlder1(viewOne);
            return  horlder1;

            case TYPE_2:
                View viewTwo =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_three_2,parent,false);
                final MyVeiwHorlder2 horlder2=new MyVeiwHorlder2(viewTwo);


                horlder2.viewTwo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int k=horlder2.getAdapterPosition();
                        ActivityClass activityClass=list.get(k);
                        ActivityThree.actionStart(horlder2.viewTwo.getContext(),activityClass.getTitle(),activityClass.getContent(),activityClass.getVideoUri());
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
        JCVideoPlayer jcVideoPlayerStandard;
        private final TextView title;
        private final TextView content;

        public MyViewHorlder1(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.contentTitle);
            content = (TextView) itemView.findViewById(R.id.content);
            jcVideoPlayerStandard = (JCVideoPlayerStandard) itemView.findViewById(R.id.contentVideo);
        }
    }


    class MyVeiwHorlder2 extends RecyclerView.ViewHolder{
        private  View viewTwo;
        private final TextView title;
        private  final ImageView dislike;
        JCVideoPlayer jcVideoPlayerStandard;


        public MyVeiwHorlder2(View itemView) {
            super(itemView);
            viewTwo=itemView;
            dislike=(ImageView) itemView.findViewById(R.id.dislike) ;
            jcVideoPlayerStandard = (JCVideoPlayerStandard) itemView.findViewById(R.id.video);
            title = (TextView) itemView.findViewById(R.id.title_Three);
        }
    }

    private void TYPE1(MyViewHorlder1 viewHorlder1,int position){

        ActivityClass activityClass=list.get(position);

        viewHorlder1.title.setText(activityClass.getTitle());
        viewHorlder1.content.setText(activityClass.getContent());
        viewHorlder1.jcVideoPlayerStandard.setUp(activityClass.getVideoUri(),JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"");
    }

    private void TYPE2(MyVeiwHorlder2 viewHorlder2,int position){

        ActivityClass activityClass=list.get(position);
        viewHorlder2.title.setText(activityClass.getTitle());
        viewHorlder2.dislike.setImageResource(R.drawable.dislike);
        viewHorlder2.jcVideoPlayerStandard.setUp(activityClass.getVideoUri(),JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"");

    }

    public void removeData(int position) {
        list.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();

    }
}