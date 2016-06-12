package com.thatsterrible.travato;

/**
 * Created by naomikoo on 16-06-11.
 */
public class LocalActivityItem {
    String mImgurl;
    String mTourTitle;
    String mGuideName;
    String mCityName;
    String mDescription;
    String mPrice;
    String mStartDate;
    String mEndDate;
    String mCapacity;


    public LocalActivityItem(String imgurl, String tourTitle, String guideName, String cityName,
                             String description, String price, String startDate, String endDate,
                             String capacity) {
        mImgurl = imgurl;
        mTourTitle = tourTitle;
        mGuideName = guideName;
        mCityName = cityName;
        mDescription = description;
        mPrice = price;
        mStartDate = startDate;
        mEndDate = endDate;
        mCapacity = capacity;
    }

    public String getGuideName() {
        return mGuideName;
    }

    public String getImgurl() {
        return mImgurl;
    }

    public String getTourTitle() {
        return mTourTitle;
    }

    public String getCityName() {
        return mCityName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getPrice() {
        return "$"+mPrice;
    }

    public String getDate() {
        return mStartDate + " - " + mEndDate;
    }

    public String getCapacity() {
        return mCapacity;
    }
}
