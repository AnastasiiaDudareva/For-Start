package com.start.app.di.components;

import com.start.app.di.modules.ApplicationModule;
import com.start.app.di.modules.NetworkModule;
import com.start.app.di.modules.StorageModule;
import com.start.app.repository.KeyValueStorage;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Nastya Dudareva at 12/6/18
 */
@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class, StorageModule.class})
public interface AppComponent {

//    void injectLoginActivity(LoginActivity loginActivity);

//    void injectSplashActivity(SplashActivity splashActivity);

//    void injectMainActivity(MainActivity mainActivity);

    KeyValueStorage keyValueStorage();
}