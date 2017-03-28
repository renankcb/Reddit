package com.winnin.reddit.presentation;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * Created by RenanKirk on 25/03/2017.
 */

public class CategoryContentPresenter implements CategoryContentContract.Presenter {

    Retrofit retrofit;

    CategoryContentContract.View view;

    @Inject
    public CategoryContentPresenter(Retrofit retrofit, CategoryContentContract.View view) {
        this.retrofit = retrofit;
        this.view = view;
    }


    @Override
    public void loadCategory(String category) {

    }
}
