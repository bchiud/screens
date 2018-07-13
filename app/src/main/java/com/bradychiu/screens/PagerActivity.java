package com.bradychiu.screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.bradychiu.screens.model.Item;

import java.util.List;

public class PagerActivity extends AppCompatActivity {

    ViewPager mPager;
    List<Item> mItemList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

        // mItemList = DataGenerator.getInstance().getData();
        //
        // FragmentManager fragmentManager = getSupportFragmentManager();
        // mPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
        //     @Override
        //     public Fragment getItem(int position) {
        //         Item item = mItemList.get(position);
        //         return PagerFragment.newInstance(item.getUuid());
        //     }
        //
        //     @Override
        //     public int getCount() {
        //         mItemList.size();
        //     }
        //
        // });

        // this is required to set current page item so pager doesn't restart at index 0 every time
        // for(int i = 0; i < mSomeModelList.size(); i++) {
        //
        // }

    }
}
