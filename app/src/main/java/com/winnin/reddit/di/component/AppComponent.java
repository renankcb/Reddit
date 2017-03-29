package com.winnin.reddit.di.component;

import com.winnin.reddit.di.module.ApplicationModule;
import com.winnin.reddit.di.module.HttpModule;
import com.winnin.reddit.manager.CategoryApi;
import com.winnin.reddit.ui.MainActivity;
import com.winnin.reddit.ui.fragment.AbstractCategoryFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {HttpModule.class, ApplicationModule.class})
public interface AppComponent {
    void inject(AbstractCategoryFragment fragment);

    void inject(MainActivity fragment);

//    void inject(RepoFragment fragment);

    CategoryApi api();
}
