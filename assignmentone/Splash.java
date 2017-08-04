package com.bignerdranch.android.assignmentone;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by sahas.arora on 8/3/17.
 */

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_splash);


    Intent intent = new Intent(this, StoryListActivity.class);

    startActivity(intent);

    finish();
}
}

