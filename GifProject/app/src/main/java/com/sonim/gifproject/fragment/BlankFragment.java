package com.sonim.gifproject.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.sonim.gifproject.adapter.MyRecyclerViewAdapter;
import com.sonim.gifproject.R;
public class BlankFragment extends Fragment implements MyRecyclerViewAdapter.ItemClickListener{
    private RecyclerView mRecyclerView;
    MyRecyclerViewAdapter mRecyclerViewAdapter;
    private Context mContext;
    int mImages[];
    private BottomNavigationView navigation;


    public BlankFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_notifications:
                    return true;
            }
            return false;
        }

    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        getData();
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        navigation = (BottomNavigationView) view.findViewById(R.id.navigation);
        mRecyclerViewAdapter = new MyRecyclerViewAdapter(mContext, mImages);
        mRecyclerViewAdapter.setClickListener(this);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        return view;
    }

    private void getData() {
        mImages = new int[]{R.drawable.rotating_earth,R.drawable.rotating_earth,R.drawable.rotating_earth,R.drawable.rotating_earth,R.drawable.rotating_earth};
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}
