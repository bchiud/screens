package com.bradychiu.screens;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bradychiu.screens.model.DataGenerator;
import com.bradychiu.screens.model.Item;

import java.util.UUID;

public class PagerFragment extends Fragment {

    private static final String UUID_KEY = "item_uuid";
    private static final String POSITION_KEY = "item_position";

    private int mPosition;
    private Item mItem;
    private TextView mNumberTextView;
    private TextView mPositionTextView;
    private TextView mUuidTextView;
    private UUID mUuid;

    public static PagerFragment newInstance(UUID uuid, int position) {
        Bundle args = new Bundle();
        args.putInt(POSITION_KEY, position);
        args.putSerializable(UUID_KEY, uuid);

        PagerFragment pagerFragment = new PagerFragment();
        pagerFragment.setArguments(args);
        return pagerFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPosition = getArguments().getInt(POSITION_KEY);
        mUuid = (UUID) getArguments().getSerializable(UUID_KEY);
        mItem = DataGenerator.getInstance().getItem(mUuid);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pager, container, false);

        mPositionTextView = v.findViewById(R.id.pager_fragment_position_text_view);
        mPositionTextView.setText(String.valueOf(mPosition));

        mNumberTextView = v.findViewById(R.id.pager_fragment_number_text_view);
        mNumberTextView.setText(String.valueOf(mItem.getNumber()));

        mUuidTextView = v.findViewById(R.id.pager_fragment_uuid_text_view);
        mUuidTextView.setText(mItem.getUuid().toString());

        return v;
    }

}
