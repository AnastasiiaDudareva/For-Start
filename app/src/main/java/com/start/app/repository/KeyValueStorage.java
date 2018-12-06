package com.start.app.repository;

import android.support.annotation.NonNull;

import rx.Observable;

/**
 * Created by Nastya Dudareva at 12/6/18
 */
public interface KeyValueStorage {

    String TOKEN_KEY = "token";
    String USER_NAME_KEY = "user_name";

    void saveToken(@NonNull String token);

    @NonNull
    String getToken();

    void saveUserName(@NonNull String userName);

    @NonNull
    Observable<String> getUserName();

    void clear();
}

