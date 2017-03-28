package com.winnin.reddit.presentation;

import com.winnin.reddit.domain.model.Response;

/**
 * Created by RenanKirk on 25/03/2017.
 */

public interface CategoryContentContract {
    interface View{
        void showContentListCategory(Response posts);

        void showError(String message);

        void showComplete();
    }

    interface Presenter{
        void loadCategory(String category);
    }
}
