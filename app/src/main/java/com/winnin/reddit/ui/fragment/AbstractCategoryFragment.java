package com.winnin.reddit.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.winnin.reddit.R;
import com.winnin.reddit.RedditApplication;
import com.winnin.reddit.manager.CategoryApi;
import com.winnin.reddit.model.Children;
import com.winnin.reddit.model.ResponseCategory;
import com.winnin.reddit.presentation.CategoryPresenter;
import com.winnin.reddit.ui.CategoryViewContract;
import com.winnin.reddit.ui.adapter.CategoryAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by RenanKirk on 25/03/2017.
 */

public abstract class AbstractCategoryFragment extends Fragment implements CategoryViewContract {

    @BindView(R.id.rv_items)
    RecyclerView categoryItems;

    @BindView(R.id.progress)
    ProgressBar progressBar;

    @BindView(R.id.txv_error_msg)
    TextView errorMsg;

    @Inject
    CategoryApi service;

    private CategoryAdapter adapter;

    CategoryPresenter presenter;

    public AbstractCategoryFragment(){}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        ((RedditApplication) getActivity().getApplication()).getComponent()
                .inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter = new CategoryPresenter(this, service);
        View view = inflater.inflate(getResourceLayout(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.loadCategory(getCategory());
        setupRecycleViewAndAdapter();
    }

    private void setupRecycleViewAndAdapter() {
        categoryItems.setHasFixedSize(true);
        categoryItems.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new CategoryAdapter(getContext());
        categoryItems.setAdapter(adapter);
    }

    protected abstract String getCategory();

    protected abstract int getResourceLayout();

    @Override
    public void showContentListCategory(ResponseCategory posts) {
        hideLoadShowContent();
        adapter.setData(posts.getData().getChildren());
        adapter.notifyDataSetChanged();
    }

    private void hideLoadShowContent() {
        categoryItems.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        errorMsg.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        showErrorHideProgress();
    }

    private void showErrorHideProgress() {
        categoryItems.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        errorMsg.setVisibility(View.VISIBLE);
    }


}
