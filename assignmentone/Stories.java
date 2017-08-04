package com.bignerdranch.android.assignmentone;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by sahas.arora on 7/20/17.
 */

public class Stories {
    private static Stories sStories;
    private List<Story> mStories;
    private List<Story> mSearchStories ;


    public static Stories get(Context context) {
        if (sStories == null) {
            sStories = new Stories(context);
        }
        return sStories;
    }

    private Stories(Context context) {

        mStories = new ArrayList<>() ;
        for (int i = 0; i < 100; i++) {
            Story story = new Story();
            story.setDescription("Story #" + i);
            mStories.add(story);
        }

    }

    public List<Story> getStories() {
        return mStories;
    }

    public List<Story> getSearchStories(String search) {
        mSearchStories = new ArrayList<>() ;
        Story myStory ;
        for (int i=0 ; i<mStories.size();i++)
        {
            myStory = mStories.get(i) ;
            if (myStory.getmName().contains(search)|| myStory.getmDescription().contains(search)||myStory.getBandName().contains(search))
            {
                mSearchStories.add(myStory) ;
            }
        }
        return mSearchStories ;
    }
    public Story getStory(UUID id){

        for (Story story :mStories)
        {
            if (story.getId().equals(id)){
                return story ;
            }
        }
        return null ;
    }
}
