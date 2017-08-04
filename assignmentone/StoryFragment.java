package com.bignerdranch.android.assignmentone;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by sahas.arora on 8/3/17.
 */

public class StoryFragment extends Fragment {
    private static final String ARG_Story_Id = "story_id" ;
    private Story mStory ;
    private EditText mTitleField ;
    private EditText mDescription ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID storyId = (UUID) getArguments().getSerializable(ARG_Story_Id) ;
        mStory = Stories.get(getActivity()).getStory(storyId) ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_story, container, false);

        mTitleField = (EditText) v.findViewById(R.id.story_title);
        mTitleField.setText(mStory.getBandName());

        mTitleField.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start, int count, int after) {
                mStory.setmName(s.toString());
            }

            public void afterTextChanged(Editable s) {


            }
        });

        mDescription = (EditText) v.findViewById((R.id.story_description)) ;
        mDescription.setText(mStory.getmDescription()) ;
        return v ;

    }

    public static StoryFragment newInstance(UUID storyId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_Story_Id, storyId);

        StoryFragment fragment = new StoryFragment();
        fragment.setArguments(args);
        return fragment;

    }

    public void returnResult() {

        getActivity().setResult(Activity.RESULT_OK,null);
    }


}

