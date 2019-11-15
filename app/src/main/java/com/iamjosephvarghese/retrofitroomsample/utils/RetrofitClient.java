package com.iamjosephvarghese.retrofitroomsample.utils;



import android.content.Context;


import com.iamjosephvarghese.retrofitroomsample.api.Api;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClient {
    private static final String BASE_URL = "https://reqres.in/";
    private static final String HEADER_CACHE_CONTROL = "Cache-Control"; // removes Cache-Control header from the server, and apply our own cache control
    private static final String HEADER_PRAGMA = "Pragma"; // overrides "Not to use caching scenario"
    private static final long cacheSize = 5 * 1024 * 1024; // 5 MB
    private static RetrofitClient mInstance;
    private final Retrofit retrofit;

    public static synchronized RetrofitClient getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new RetrofitClient(context);
        }
        return mInstance;
    }

    private RetrofitClient(Context context) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();



        retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }



    public Api getDataFromServer() {
        return retrofit.create(Api.class);
    }
}
