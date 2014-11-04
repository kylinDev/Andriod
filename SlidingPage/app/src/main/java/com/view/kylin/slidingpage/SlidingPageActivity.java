package com.view.kylin.slidingpage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.ViewConfiguration;

import com.astuetz.PagerSlidingTabStrip;

import java.lang.reflect.Field;


public class SlidingPageActivity extends FragmentActivity {
    PagerSlidingTabStrip tabs;
    ViewPager pager;
    String[] titles = { "新闻","纯图","男人帮","女人帮" };
    Man man;
    Women women;
    Picture picture;
    News news;
    Item item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_page);
        setOverflowShowingAways();
        pager = (ViewPager) findViewById(R.id.pager);
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setShouldExpand(true);
        tabs.setTabBackground(0);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),titles));
        tabs.setViewPager(pager);

    }
    private void setOverflowShowingAways(){
        try{
            ViewConfiguration viewConfiguration=ViewConfiguration.get(this);
            Field field=ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            field.setAccessible(true);
            field.setBoolean(viewConfiguration,false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sliding_page, menu);
        return true;
    }
    public class MyPagerAdapter extends FragmentPagerAdapter {
        String[] _titles;

        public MyPagerAdapter(FragmentManager fm, String[] titles) {
            super(fm);
            _titles = titles;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    if (news == null) {
                        news = new News();
                        return news;
                    }
                    return news;
                case 1:
                    if (picture == null) {
                        picture = new Picture();
                        return picture;
                    }
                    return picture;
                case 2:
                    if (man == null) {
                        man = new Man();
                        return man;
                    }
                    return man;
                case 3:
                    if (women==null){
                        women=new Women();
                        return women;
                    }
                    return women;
                default:
                    return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return _titles[position];
        }

        @Override
        public int getCount() {
            return _titles.length;
        }
    }
}
