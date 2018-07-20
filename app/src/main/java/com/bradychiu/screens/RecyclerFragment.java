package com.bradychiu.screens;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bradychiu.screens.model.DataGenerator;
import com.bradychiu.screens.model.Item;

import java.util.List;

public class RecyclerFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ItemAdapter mItemAdapter;
    private List<Item> itemsList;

    public static RecyclerFragment newInstance() {
        Bundle args = new Bundle();

        RecyclerFragment recyclerFragment = new RecyclerFragment();
        recyclerFragment.setArguments(args);
        return recyclerFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }
    
    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    public void updateUI() {
        itemsList = DataGenerator.getInstance().getItems();

        if(mItemAdapter == null) {
            mItemAdapter = new ItemAdapter(itemsList);
            mRecyclerView.setAdapter(mItemAdapter);
        } else {
            mItemAdapter.notifyDataSetChanged();
        }
    }

    private class ItemHolder extends RecyclerView.ViewHolder {

        private TextView mUuidTextView;
        private TextView mCountTextView;
        private TextView mNumberTextView;

        public ItemHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.fragment_recycler_item, parent, false));

            mUuidTextView = itemView.findViewById(R.id.fragment_recycler_item_uuid_text_view);
            mCountTextView = itemView.findViewById(R.id.fragment_recycler_item_position_text_view);
            mNumberTextView = itemView.findViewById(R.id.fragment_recycler_item_number_text_view);
        }

        public void bind(Item item) {
            mUuidTextView.setText("UUID: " + item.getUuid());
            mCountTextView.setText("Count: " + String.valueOf(0));
            mNumberTextView.setText("Number: " + item.getNumber());
        }
    }

    private class ItemAdapter extends RecyclerView.Adapter<ItemHolder> {

        private List<Item> itemsList;

        public ItemAdapter(List<Item> itemsList) {
            this.itemsList = itemsList;
        }

        @NonNull
        @Override
        public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new ItemHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
            Item item = itemsList.get(position);
            holder.bind(item);
        }

        @Override
        public int getItemCount() {
            return itemsList.size();
        }
    }

}
