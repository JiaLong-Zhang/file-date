package com.example.myapplication;

import org.litepal.crud.DataSupport;

public class ActivityClass extends DataSupport {
    public String title;
    public String content;
    public int imageId;
    public int type;
    public String videoUri;
    public int likeCondition;

    public String getTitle() {
        return title;
    }

    public void  setTitle(String title){
        this.title=title;
    }

    public String getContent() {
        return content;
    }

    public void  setContent(String content){
        this.content=content;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId){
        this.imageId=imageId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type){
        this.type=type;
    }

    public String getVideoUri() {
        return videoUri;
    }

    public void setVideoUri(String videoUri){
        this.videoUri=videoUri;
    }

    public int getLikeCondition() {
        return likeCondition;
    }

    public void setLikeCondition(int likeCondition){
        this.likeCondition=likeCondition;
    }


}
