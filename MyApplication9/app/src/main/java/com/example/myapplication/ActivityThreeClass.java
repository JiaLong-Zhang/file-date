package com.example.myapplication;

public class ActivityThreeClass {
    private String title;
    private String content;
    private String videoUri;

    public ActivityThreeClass(String title, String content, String videoUri) {
        this.title = title;
        this.content=content;
        this.videoUri = videoUri;
    }


    public String getTitle() {

        return title;
    }


    public String getContent() {
        return content;
    }


    public String getVideoUri() {

        return videoUri;
    }

}