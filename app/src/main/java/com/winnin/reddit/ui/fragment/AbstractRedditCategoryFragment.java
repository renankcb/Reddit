package com.winnin.reddit.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.winnin.reddit.presentation.CategoryContentContract;
import com.winnin.reddit.presentation.CategoryContentPresenter;

import javax.inject.Inject;

/**
 * Created by RenanKirk on 25/03/2017.
 */

public abstract class AbstractRedditCategoryFragment extends Fragment implements CategoryContentContract.View{

    @Inject
    CategoryContentPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getResourceLayout(), container, false);
    }

    protected abstract int getResourceLayout();
}
