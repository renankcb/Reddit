package com.winnin.reddit.ui;

import com.winnin.reddit.model.*;

/**
 * Created by RenanKirk on 28/03/2017.
 */

public interface CategoryViewContract {
    void showContentListCategory(ResponseCategory posts);

    void showError(String message);
}
