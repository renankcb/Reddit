package com.winnin.reddit.ui.fragment;

import com.winnin.reddit.R;
import com.winnin.reddit.domain.model.Response;

/**
 * Created by RenanKirk on 25/03/2017.
 */

public class HotCategoryFragment extends AbstractRedditCategoryFragment {
    @Override
    protected int getResourceLayout() {
        return R.layout.pager_content_fragment;
    }

    @Override
    public void showContentListCategory(Response posts) {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void showComplete() {

    }
}
