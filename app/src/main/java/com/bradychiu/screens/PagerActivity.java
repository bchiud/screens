package com.bradychiu.screens;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.bradychiu.screens.model.DataGenerator;
import com.bradychiu.screens.model.Item;

import java.util.List;
import java.util.UUID;

public class PagerActivity extends AppCompatActivity {

    private static final String TAG = "PagerActivity";
    private static final String CURRENT_ITEM_UUID_KEY = "com.bradychiu.screens.current_item_uuid_key";

    List<Item> mItemList;
    ViewPager mViewPager;
    UUID mCurrentItemUuid;
    int mCurrentItem;

    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, PagerActivity.class);
        // intent.putExtra(UUID_KEY, itemUuid);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

        if(savedInstanceState != null) {
            mCurrentItem = savedInstanceState.getInt(CURRENT_ITEM_UUID_KEY);
        }

        mViewPager = (ViewPager) findViewById(R.id.pager_activity);
        mItemList = DataGenerator.getInstance().getItems();

        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Item item = mItemList.get(position);
                return PagerFragment.newInstance(item.getUuid() , position);
            }

            @Override
            public int getCount() {
                return mItemList.size();
            }
        });

        mViewPager.setCurrentItem(mCurrentItem, true);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState called");
        mCurrentItem = mViewPager.getCurrentItem();
        outState.putInt(CURRENT_ITEM_UUID_KEY, mCurrentItem);
    }
}
