package com.example.eventogram.helperClass.HomeAdapter;

public class MostViewedHelperClass {


    int image;
    String title , desc;

    public MostViewedHelperClass(int image, String title, String desc) {
        this.image = image;
        this.title = title;
        this.desc = desc;
    }

    public MostViewedHelperClass(String s, String title, int i) {

        this.image = i;
        this.title = title;
        this.desc = s;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}
