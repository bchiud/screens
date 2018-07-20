package com.bradychiu.screens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.bradychiu.screens.model.DataGenerator;
import com.bradychiu.screens.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ButtonActivity extends AppCompatActivity {

    private Button mDataAddBeginButton;
    private Button mDataAddEndButton;
    private Button mDataRemoveBeginButton;
    private Button mDataRemoveEndButton;
    private Button mPagerButton;
    private Button mRecyclerButton;
    private TextView mDataCountTextView;

    DataGenerator mDataGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        mDataGenerator = DataGenerator.getInstance();

        mDataAddBeginButton = findViewById(R.id.button_activity_add_data_begin_button);
        mDataAddBeginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDataGenerator.addItemToBeginning();
                updateDataCountTextView();
            }
        });

        mDataAddEndButton = findViewById(R.id.button_activity_add_data_end_button);
        mDataAddEndButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDataGenerator.addItemToEnd();
                updateDataCountTextView();
            }
        });

        mDataRemoveBeginButton = findViewById(R.id.button_activity_remove_data_begin_button);
        mDataRemoveBeginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(canRemove()) {
                    mDataGenerator.removeItemFromBeginning();
                    updateDataCountTextView();
                }
            }
        });

        mDataRemoveEndButton = findViewById(R.id.button_activity_remove_data_end_button);
        mDataRemoveEndButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(canRemove()) {
                    mDataGenerator.removeItemFromEnd();
                    updateDataCountTextView();
                }
            }
        });

        mDataCountTextView = findViewById(R.id.button_activity_data_count_textview);
        updateDataCountTextView();

        mPagerButton = findViewById(R.id.button_activity_pager_button);
        mPagerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = PagerActivity.newIntent(getApplicationContext());
                startActivity(intent);
            }
        });

        mRecyclerButton = findViewById(R.id.button_activity_recycler_button);
        mRecyclerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = RecyclerActivity.newIntent(getApplicationContext());
                startActivity(intent);
            }
        });
    }

    private void updateDataCountTextView() {
        mDataCountTextView.setText(mDataGenerator.getSize() + " items");
    }

    private boolean canRemove() {
        if(mDataGenerator.getItems().size() != 0) {
            return true;
        } else {
            Toast.makeText(this,
                    R.string.button_activity_no_more_items_toast,
                    Toast.LENGTH_SHORT)
                    .show();
            return false;
        }
    }
}
