package com.winnin.reddit.di.module;

import android.app.Activity;
import android.content.Context;

import com.winnin.reddit.di.ActivityContext;
import com.winnin.reddit.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by RenanKirk on 28/03/2017.
 */

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @PerActivity
    @Provides
    @ActivityContext
    public Context provideContext() {
        return activity;
    }
}
