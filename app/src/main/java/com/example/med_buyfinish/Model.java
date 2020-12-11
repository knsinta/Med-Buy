package com.example.med_buyfinish;

public class Model {

    String mNamaAlat;
    String mDeskAlat;
    int mFotoAlat;

    public Model(String mNamaAlat, String mDeskAlat, int mFotoAlat) {
        this.mNamaAlat = mNamaAlat;
        this.mDeskAlat = mDeskAlat;
        this.mFotoAlat = mFotoAlat;
    }

    public String getmNamaAlat() {
        return mNamaAlat;
    }

    public String getmDeskAlat() {
        return mDeskAlat;
    }

    public int getmFotoAlat() {
        return mFotoAlat;
    }


}
