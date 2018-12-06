package com.start.app.repository;

import android.support.annotation.NonNull;

import com.orhanobut.hawk.Hawk;

import rx.Observable;

/**
 * Created by Nastya Dudareva at 12/6/18
 */
public class HawkKeyValueStorage implements KeyValueStorage {

    public void saveToken(@NonNull String token) {
        Hawk.put(TOKEN_KEY, token);
    }

    @NonNull
    public String getToken() {
        return Hawk.get(TOKEN_KEY, "");
    }

    public void saveUserName(@NonNull String userName) {
        Hawk.put(USER_NAME_KEY, userName);
    }

    @NonNull
    public Observable<String> getUserName() {
        return Hawk.getObservable(USER_NAME_KEY, "");
    }

    @Override
    public void clear() {
        Hawk.clear();
    }
}
