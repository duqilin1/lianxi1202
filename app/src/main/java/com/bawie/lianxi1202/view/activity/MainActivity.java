package com.bawie.lianxi1202.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.bawie.lianxi1202.R;
import com.bawie.lianxi1202.base.BaseActivity;
import com.bawie.lianxi1202.view.fragment.HomeFragment;
import com.bawie.lianxi1202.view.fragment.MyFragment;
import com.bawie.lianxi1202.view.fragment.NewFragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private ArrayList<Fragment> list;

    @Override
    protected void initData() {
        list = new ArrayList<>();
        HomeFragment homeFragment = new HomeFragment();
        NewFragment newFragment = new NewFragment();
        MyFragment myFragment = new MyFragment();
        list.add(homeFragment);
        list.add(newFragment);
        list.add(myFragment);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                radioGroup.check(radioGroup.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.bt01:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.bt02:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.bt03:
                        viewPager.setCurrentItem(2);
                        break;
                }
            }
        });
    }

    @Override
    protected void initView() {
        viewPager = findViewById(R.id.vp);
        radioGroup = findViewById(R.id.rg);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    public void tiao(){
        viewPager.setCurrentItem(2);
    }
}
