package com.winnin.reddit;

import android.app.Application;

import com.winnin.reddit.di.component.AppComponent;
import com.winnin.reddit.di.component.DaggerAppComponent;
import com.winnin.reddit.di.module.ApplicationModule;
import com.winnin.reddit.di.module.HttpModule;

/**
 * Created by RenanKirk on 28/03/2017.
 */

public class RedditApplication extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .httpModule(new HttpModule())
                .build();
    }

    public AppComponent getComponent() {
        return component;
    }
}
