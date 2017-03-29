package com.winnin.reddit.ui.fragment;

import com.winnin.reddit.R;
import com.winnin.reddit.model.*;

/**
 * Created by RenanKirk on 25/03/2017.
 */

public class RisingCategoryFragment extends AbstractCategoryFragment {

    @Override
    protected String getCategory() {
        return "rising";
    }

    @Override
    protected int getResourceLayout() {
        return R.layout.pager_content_fragment;
    }
}
