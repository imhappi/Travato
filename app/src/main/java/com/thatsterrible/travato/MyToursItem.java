package com.thatsterrible.travato;

/**
 * Created by pandominator on 11/06/16.
 */
public class MyToursItem {
    String mImgurl;
    String mGuideName;
    String mActivityName;

    public MyToursItem(String imgurl, String guideName, String activityName){
        mImgurl = imgurl;
        mGuideName = guideName;
        mActivityName = activityName;
    }

    public String getGuideName() {
        return mGuideName;
    }

    public String getImgurl() {
        return mImgurl;
    }

    public String getActivityName() {
        return mActivityName;
    }
}
