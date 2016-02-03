package com.example.elmedin.kirchheim;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.elmedin.kirchheim.dummy.NewsContainer;

public class MainPage extends FragmentActivity implements AdapterView.OnItemClickListener, NewsFragment.OnListFragmentInteractionListener {

    private String[] mTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private View newsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_page);
        mTitles = getResources().getStringArray(R.array.list);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.activity_list_item, android.R.id.text1, mTitles));
        mDrawerList.setOnItemClickListener(this);
        newsView = findViewById(R.id.leftTitle);


        newsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsFragment nextFrag = new NewsFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.news_container, nextFrag, "TAG_NEWS")
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    /**
     * handle item click events on navigation
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    // TODO: start another fragment...and inflate new layout
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onListFragmentInteraction(NewsContainer.NewsItem item) {

    }
}
