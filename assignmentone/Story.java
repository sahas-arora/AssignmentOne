package com.bignerdranch.android.assignmentone;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Created by sahas.arora on 7/16/17.
 */

public class Story implements Serializable {
    private UUID mId ;
    private String mName ;
    private String mDescription ;
    int image ;
    String leadVocalist ;
    int id ;
    String bandName ;

    public String getBandName()
    {
        return bandName;
    }

    public Story(){
        mId = UUID.randomUUID() ;
    }

    public Story(String mName, String band, int id_, String mDescription, int image)
    {

        mId = UUID.randomUUID();
        this.mName = mName ;
        this.mDescription = mDescription ;
        this.image = image ;
        this.bandName = band ;

    }
    public UUID getId() {
        return mId;
    }


    public String getmName()
    {
        return mName;
    }

    public String getmDescription()
    {
        return mDescription;
    }

    public int getImage() {
        return image;
    }

    public void setDescription(String input) {
        mDescription = input ;
    }

    public void setmName(String input) {
        mName = input ;
    }







}