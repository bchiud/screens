package com.bradychiu.screens;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bradychiu.screens.model.Item;

import java.util.UUID;

public class PagerFragment extends Fragment {

    private static final String UUID_KEY = "item_uuid";

    private Item mItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pager, container, false);

        return v;
    }

    public PagerFragment newInstance(UUID uuid) {
        Bundle args = new Bundle();
        args.putSerializable(UUID_KEY, uuid);

        PagerFragment pagerFragment = new PagerFragment();
        pagerFragment.setArguments(args);
        return pagerFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID uuid = (UUID) getArguments().getSerializable(UUID_KEY);
        mItem = DataGenerator.getInstance().getItem(uuid);
    }


}
