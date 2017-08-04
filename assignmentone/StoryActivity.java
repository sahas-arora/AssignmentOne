package com.bignerdranch.android.assignmentone;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import java.util.UUID;

/**
 * Created by sahas.arora on 7/20/17.
 */

public class StoryActivity extends SingleFragmentActivity {

    private static final String Story_id = "com.example.sahasarora.assignment1.story_id" ;

    public static Intent newIntent(Context packageContext, UUID storyId) {
        Intent intent = new Intent(packageContext, StoryActivity.class);
        intent.putExtra(Story_id, storyId);
        return intent;
    }

        @Override
        protected Fragment createFragment() {
            UUID storyId = (UUID) getIntent().getSerializableExtra(Story_id) ;
            return StoryFragment.newInstance(storyId);

    }

}
