package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class TypeThreeHolder extends TypeAbstarctViewHolder<ActivityThreeClass> {
    public   View viewThree;
    JCVideoPlayer jcVideoPlayerStandard;
    public   TextView title_three;
    public   ImageView dislike;
    public   ImageView like;

    public TypeThreeHolder(View itemView) {
        super(itemView);
        viewThree=itemView;
        jcVideoPlayerStandard = (JCVideoPlayerStandard) itemView.findViewById(R.id.video);
        title_three= (TextView) itemView.findViewById(R.id.title_Three);
        dislike=(ImageView) itemView.findViewById(R.id.dislike);
        like=(ImageView) itemView.findViewById(R.id.like);

    }

    @Override
    public void bindHolder(ActivityThreeClass item) {

        title_three.setText(item.getTitle());
        dislike.setImageResource(R.mipmap.dislike);
        like.setImageResource(R.drawable.love_normal);
        jcVideoPlayerStandard.setUp(item.getVideoUri(),JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"");
    }
}
