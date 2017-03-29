package com.winnin.reddit.di.component;

import com.winnin.reddit.di.PerActivity;
import com.winnin.reddit.di.module.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

}
