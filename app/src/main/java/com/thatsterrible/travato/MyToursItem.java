package com.thatsterrible.travato;

/**
 * Created by pandominator on 11/06/16.
 */
public class MyToursItem {
    String mImgurl;
    String mGuideName;
    String mTourDescription;

    public MyToursItem(String imgurl, String guideName, String tourDescription){
        mImgurl = imgurl;
        mGuideName = guideName;
        mTourDescription = tourDescription;
    }

    public String getGuideName() {
        return mGuideName;
    }

    public String getImgurl() {
        return mImgurl;
    }

    public String getTourDescription() {
        return mTourDescription;
    }
}
