package com.start.app.rest;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.start.app.App;
import com.start.app.repository.KeyValueStorage;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Nastya Dudareva at 12/6/18
 */
public class ApiKeyInterceptor implements Interceptor {

    private final KeyValueStorage mKeyValueStorage;

    private ApiKeyInterceptor() {
        mKeyValueStorage = App.getAppComponent().keyValueStorage();
    }

    @NonNull
    public static Interceptor create() {
        return new ApiKeyInterceptor();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        String token = mKeyValueStorage.getToken();
        if (TextUtils.isEmpty(token)) {
            return chain.proceed(chain.request());
        }
        Request request = chain.request().newBuilder()
                .addHeader(Keys.AUTH_KEY, String.format("%s %s", "token", token))
                .build();
        return chain.proceed(request);
    }
}
