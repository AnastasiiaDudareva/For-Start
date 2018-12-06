package com.start.app.di.modules;

import android.support.annotation.NonNull;

import com.start.app.BuildConfig;
import com.start.app.repository.HawkKeyValueStorage;
import com.start.app.repository.KeyValueStorage;
import com.start.app.rest.ApiKeyInterceptor;
import com.start.app.rest.LoggingInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nastya Dudareva at 12/6/18
 */
@Module
public class NetworkModule {

//    @Provides
//    @Singleton
//    GithubService provideGithubService(@NonNull Retrofit retrofit) {
//        return retrofit.create(GithubService.class);
//    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(@NonNull OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.SCHEME + BuildConfig.DEV_DOMAIN)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(LoggingInterceptor.create())
                .addInterceptor(ApiKeyInterceptor.create())
                .build();
    }
}
