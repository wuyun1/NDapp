package com.nongda.jonney;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.nongda.jonney.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements ViewPager.OnPageChangeListener, NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, OnListFragmentInteractionListener,OnFragmentInteractionListener {

    ActionBarDrawerToggle toggle;
    private FloatingActionButton fab = null;
    private NavigationView navigationView = null;
    private Toolbar toolbar = null;
    private ViewPager mViewPager;
    private List<Fragment> mTabs = new ArrayList<Fragment>();
    private FragmentPagerAdapter mAdapter;
    private DrawerLayout drawer = null;
    private ImageView loginimg = null;

    private String[] mTitles = new String[]{"First Fragment!",
            "Second Fragment!", "Third Fragment!", "Fourth Fragment!"};

    private List<ChangeColorIconWithTextView> mTabIndicator = new ArrayList<ChangeColorIconWithTextView>();

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println(requestCode + "" + data);
        switch (resultCode) {
            case 1:   /*取得来自SecondActivity页面的数据，并显示到画面*/
                Bundle bundle = data.getExtras();            /*获取Bundle中的数据，注意类型和key*/
                String result = bundle.getString("Result");
                Snackbar.make(fab, "服务器返回数据:\n" +
                        result, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                mTabs.get(1).onActivityResult(2,4,data);
                this.onClick(mTabIndicator.get(1));
                break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        initView();

        initDatas();
        // Set up the ViewPager with the sections adapter.
//        Log.v("Tag", "" + mViewPager);
        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(this);
    }

    private void initView() {
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, (Toolbar) getSupportActionBar().getCustomView(), R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        loginimg = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.imageView);
        loginimg.setOnClickListener(this);

        mViewPager = (ViewPager) findViewById(R.id.pager);

        ChangeColorIconWithTextView one = (ChangeColorIconWithTextView) findViewById(R.id.id_indicator_one);
        ChangeColorIconWithTextView two = (ChangeColorIconWithTextView) findViewById(R.id.id_indicator_two);
        ChangeColorIconWithTextView three = (ChangeColorIconWithTextView) findViewById(R.id.id_indicator_three);
        ChangeColorIconWithTextView four = (ChangeColorIconWithTextView) findViewById(R.id.id_indicator_four);

        mTabIndicator.add(one);
        mTabIndicator.add(two);
        mTabIndicator.add(three);
        mTabIndicator.add(four);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);

        resetOtherTabs();
        one.setIconAlpha(.0f);//设置了默认的第一个颜色的颜色
    }

    private void initDatas() {
//        for (int i = 0; i < mTitles.length; i++) {
//            //官方提示为fragmrnt传数据 使用bundle
//            ItemFragment tabFragment = new ItemFragment();
//            Bundle args = new Bundle();
//            args.putInt(ItemFragment.ARG_COLUMN_COUNT, i + 1);
//            tabFragment.setArguments(args);
//            mTabs.add(tabFragment);
//        }
        Fragment tabFragment = null;
        Bundle args = null;

        tabFragment = new ItemFragment();
        args = new Bundle();
        args.putInt(ItemFragment.ARG_COLUMN_COUNT, 2);
        tabFragment.setArguments(args);
        mTabs.add(tabFragment);

        tabFragment = new BlankFragment();
        args = new Bundle();
        args.putInt(ItemFragment.ARG_COLUMN_COUNT, 2);
        tabFragment.setArguments(args);
        mTabs.add(tabFragment);

        tabFragment = new ItemFragment();
        args = new Bundle();
        args.putInt(ItemFragment.ARG_COLUMN_COUNT, 1);
        tabFragment.setArguments(args);
        mTabs.add(tabFragment);

        tabFragment = new BlankFragment();
        args = new Bundle();
        args.putInt(ItemFragment.ARG_COLUMN_COUNT, 2);
        tabFragment.setArguments(args);
        mTabs.add(tabFragment);

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return mTabs.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles[position];
            }

            @Override
            public Fragment getItem(int position) {
                return mTabs.get(position);
            }
        };

        fab.hide();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
//        Log.v("Tag", id + "?" + android.R.id.home);
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_lxh) {
            if (fab.isShown()) {
                fab.hide();
            } else {
                fab.show();
            }
            return true;
        } else if (id == android.R.id.home) {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawers();
            } else {
                drawer.openDrawer(GravityCompat.START);
            }
        } else if (id == R.id.action_lxh) {
            if (fab.isShown()) {
                fab.hide();
            } else {
                fab.show();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            this.onClick(mTabIndicator.get(0));
        } else if (id == R.id.nav_gallery) {
            this.onClick(mTabIndicator.get(1));
        } else if (id == R.id.nav_slideshow) {
            this.onClick(mTabIndicator.get(2));
        } else if (id == R.id.nav_manage) {
            this.onClick(mTabIndicator.get(3));
        } else if (id == R.id.nav_share) {
            startActivity(new Intent(this, ArticalActivity.class));
        } else if (id == R.id.nav_send) {
            startActivity(new Intent(this, SplashScreenActivity.class));
            finish();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageView:
                startActivityForResult(new Intent(MainActivity.this, LoginActivity.class), 0);
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.fab:
                Snackbar.make(view, "功能暂未实现,尽请期待...", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
                break;
            case R.id.id_indicator_one:
                resetOtherTabs();
                mTabIndicator.get(0).setIconAlpha(.0f);
                mViewPager.setCurrentItem(0, false);
                break;
            case R.id.id_indicator_two:
                resetOtherTabs();
                mTabIndicator.get(1).setIconAlpha(.0f);
                mViewPager.setCurrentItem(1, false);
                break;
            case R.id.id_indicator_three:
                resetOtherTabs();
                mTabIndicator.get(2).setIconAlpha(.0f);
                mViewPager.setCurrentItem(2, false);
                break;
            case R.id.id_indicator_four:
                resetOtherTabs();
                mTabIndicator.get(3).setIconAlpha(.0f);
                mViewPager.setCurrentItem(3, false);
                break;
        }

    }

    private void resetOtherTabs() {
        for (int i = 0; i < mTabIndicator.size(); i++) {
            mTabIndicator.get(i).setIconAlpha(1);//不是绿色 之前的颜色咯
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        // Log.e("TAG", "position = " + position + " , positionOffset = "
        // + positionOffset);

        if (positionOffset > 0) {
            ChangeColorIconWithTextView left = mTabIndicator.get(position);
            ChangeColorIconWithTextView right = mTabIndicator.get(position + 1);

            left.setIconAlpha( positionOffset);//变小
            right.setIconAlpha(1-positionOffset);
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
