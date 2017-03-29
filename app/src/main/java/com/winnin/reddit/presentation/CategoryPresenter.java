package com.winnin.reddit.presentation;

import com.winnin.reddit.manager.CategoryApi;
import com.winnin.reddit.ui.CategoryViewContract;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by RenanKirk on 25/03/2017.
 */

public class CategoryPresenter implements CategoryPresenterContract {

    private CategoryViewContract view;
    private CategoryApi service;
    private CompositeSubscription subscription;

    public CategoryPresenter(CategoryViewContract view, CategoryApi service) {
        this.view = view;
        this.service = service;
        this.subscription = new CompositeSubscription();
    }

    @Override
    public void loadCategory(String category) {
        subscription.add(service.getCategoryItens(category)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        responseCategory -> {
                            view.showContentListCategory(responseCategory);
                        },
                        throwable -> {
                            view.showError(throwable.getMessage());
                        }
                )
        );
    }
}
