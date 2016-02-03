package com.example.elmedin.kirchheim;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by ElmeDin on 03.02.2016.
 */
    class DrawerItemClickListener implements ListView.OnItemClickListener {


    private ListView mDrawerList;
    private CharSequence mDrawerTitle;
    private DrawerLayout mDrawerLayout;
    private String[] mTitles;


    @Override
    public void onItemClick(AdapterView parent, View view, int position, long id) {
        selectItem(position);
    }

    /**
     * Swaps fragments in the main content view
     */
    private void selectItem(int position) {

        // Create a new fragment and specify to show based on position
//        Fragment fragment = new NewsFragment();
//        Bundle args = new Bundle();
//        args.putInt(NewsFragment.ARG_PLANET_NUMBER, position);
//        fragment.setArguments(args);

        // Insert the fragment by replacing any existing fragment
//        android.app.FragmentManager fragmentManager = getFragmentManager();
//        fragmentManager.beginTransaction()
//                .add(R.id.content_frame, fragment)
//                .commit();

        // Highlight the selected item, update the title, and close the drawer
        mDrawerList.setItemChecked(position, true);
//        setTitle(mTitles[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
    }

//    @Override
//    public void setTitle(CharSequence title) {
//        mTitle = title;
//        getActionBar().setTitle("test");
//    }
}
