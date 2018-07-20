package com.bradychiu.screens;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

public class RecyclerActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new RecyclerFragment();
    }

    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, RecyclerActivity.class);
        return intent;
    }
}
