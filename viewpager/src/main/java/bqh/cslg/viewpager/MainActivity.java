package bqh.cslg.viewpager;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    List<View> viewList;
    List<String> titleList;
    MyPagerAdapter adapter;

    List<Fragment> fragmentList;

    ViewPager viewPager;
    PagerTabStrip tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tab = (PagerTabStrip) findViewById(R.id.tab);

//        viewList = new ArrayList<>();
//        View view1 = View.inflate(this,R.layout.view1,null);
//        View view2 = View.inflate(this,R.layout.view2,null);
//        View view3 = View.inflate(this,R.layout.view3,null);
//        View view4 = View.inflate(this,R.layout.view4,null);
//
//        viewList.add(view1);
//        viewList.add(view2);
//        viewList.add(view3);
//        viewList.add(view4);
//
        titleList = new ArrayList<>();
        titleList.add("第一页");
        titleList.add("第二页");
        titleList.add("第三页");
        titleList.add("第四页");
//
        tab.setBackgroundColor(Color.YELLOW);
        tab.setTextColor(Color.RED);
        tab.setDrawFullUnderline(false);
        tab.setTabIndicatorColor(Color.GREEN);
//
//        adapter = new MyPagerAdapter(viewList,titleList);
//        viewPager.setAdapter(adapter);

        fragmentList = new ArrayList<>();
        fragmentList.add(new Fragment1());
        fragmentList.add(new Fragment2());
        fragmentList.add(new Fragment3());
        fragmentList.add(new Fragment4());

        MyFragmentAdapter2 adapter = new MyFragmentAdapter2(getSupportFragmentManager(),fragmentList,titleList);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Toast.makeText(this,position+"",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
