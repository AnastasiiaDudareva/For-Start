package com.start.app.di.modules;

import com.start.app.repository.HawkKeyValueStorage;
import com.start.app.repository.KeyValueStorage;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * Created by Nastya Dudareva at 12/6/18
 */
@Module
public class StorageModule {

    @Provides
    @Singleton
    Realm provideRealm() {
        return Realm.getDefaultInstance();
    }

    @Provides
    @Singleton
    KeyValueStorage provideKeyValueStorage() {
        return new HawkKeyValueStorage();
    }
}
