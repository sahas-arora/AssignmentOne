package com.bignerdranch.android.assignmentone;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sahas.arora on 8/3/17.
 */

public class StoryListFragment extends Fragment {
    private RecyclerView mStoryRecyclerView  ;
    private StoryAdapter mAdapter ;
    private Story mStory ;
    private static final int REQUEST_STORY= 1 ;
    private SearchView mSearchBar ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_story_list, container, false ) ;

        mStoryRecyclerView = (RecyclerView) view
                .findViewById(R.id.story_recycler_view) ;
        mStoryRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity())) ;

        mSearchBar = (SearchView) view.findViewById(R.id.search_bar) ;
        mSearchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            public boolean onQueryTextSubmit(String query) {
                return false ;
            }
            public boolean onQueryTextChange(String search) {
                Stories mStories = Stories.get(getContext()) ;
                StoryAdapter storyAdapter = new StoryAdapter(mStories.getSearchStories(search)) ;
                mStoryRecyclerView.setAdapter(storyAdapter);
                return true ;
            }
        } );


        updateUI() ;

        return view ;

    }

    private void updateUI()
    {
        Stories storyLab = Stories.get(getActivity()) ;
        List<Story> stories = storyLab.getStories() ;

        mAdapter = new StoryAdapter(stories) ;
        mStoryRecyclerView.setAdapter(mAdapter);

        if (mAdapter ==null) {
            mAdapter = new StoryAdapter(stories) ;
            mStoryRecyclerView.setAdapter(mAdapter);
        }
        else {
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private class StoryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitleTextView;
        private Story mStory;
        private TextView mDesciptionTextView ;

        public StoryHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_story, parent, false));
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.story_title);
            mDesciptionTextView = (TextView) itemView.findViewById(R.id.story_description) ;

        }
        @Override
        public void onClick(View view) {
            Intent intent = StoryActivity.newIntent(getActivity(), mStory.getId());
            startActivity(intent);
           // startActivityForResult(intent, REQUEST_STORY);
        }



        public void bind(Story story)
        {
            mStory = story ;
            mTitleTextView.setText(mStory.getmName());

        }
    }

    private class StoryAdapter extends RecyclerView.Adapter<StoryHolder> {
        private List<Story> mStories;

        public StoryAdapter(List<Story> stories) {
            mStories = stories;
        }


        public void updateList(List<Story> list) {
            mStories = list;
            notifyDataSetChanged();
        }

      //  public void onActivityResult(int requestCode, int resultCode, Intent data) {
      //      if (requestCode == null) {
       //     }

       // }

    @Override
    public void onBindViewHolder(StoryHolder holder, int position)
    {
        Story story = mStories.get(position) ;
        holder.bind(story);
    }

    @Override
    public StoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

        return new StoryHolder(layoutInflater, parent);
    }


    @Override
    public int getItemCount()
    {
        return mStories.size();
    }

}
}
