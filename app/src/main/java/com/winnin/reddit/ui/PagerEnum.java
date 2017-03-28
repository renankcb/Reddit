package com.winnin.reddit.ui;

import com.winnin.reddit.R;
import com.winnin.reddit.ui.fragment.HotCategoryFragment;
import com.winnin.reddit.ui.fragment.NewsCategoryFragment;
import com.winnin.reddit.ui.fragment.RisingCategoryFragment;

/**
 * Created by RenanKirk on 25/03/2017.
 */

public enum PagerEnum {

    NEWS(R.string.title_news, NewsCategoryFragment.class),
    HOT(R.string.title_hot, HotCategoryFragment.class),
    RISING(R.string.title_rising, RisingCategoryFragment.class);

    private final int title;

    private final Class fragmentClass;

    PagerEnum(final int title, Class fragmentClass){
        this.title = title;
        this.fragmentClass = fragmentClass;
    }

    public int getTitle() {
        return title;
    }

    public Class getFragmentClass(){
        return fragmentClass;
    }
}
