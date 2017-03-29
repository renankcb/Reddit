package com.winnin.reddit.model;

import java.util.List;

/**
 * Created by RenanKirk on 25/03/2017.
 */

public class Data {

    private List<Children> children;

    private String after;

    private String before;

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }
}
