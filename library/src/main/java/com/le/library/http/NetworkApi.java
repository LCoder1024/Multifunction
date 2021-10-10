package com.le.library.http;


import com.le.library.BuildConfig;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class NetworkApi {
    private final String baseUrl;
    private final HashMap<String, Retrofit> retrofitHashMap = new HashMap<>();

    protected NetworkApi(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    protected Retrofit getRetrofit(String serviceName) {
        if (retrofitHashMap.get(baseUrl + serviceName) != null) {
            return retrofitHashMap.get(baseUrl + serviceName);
        }
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            interceptor.level(HttpLoggingInterceptor.Level.BODY);
        } else {
            interceptor.level(HttpLoggingInterceptor.Level.NONE);
        }
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.followRedirects(false);
        clientBuilder.followSslRedirects(false);
        clientBuilder.cookieJar(new LocalCookieJar());
        clientBuilder.addInterceptor(interceptor);
        clientBuilder.addInterceptor(chain -> {
            Request original = chain.request();
            Request.Builder requestBuilder = original.newBuilder();
            Request request = requestBuilder.build();
            return chain.proceed(request);
        });
        clientBuilder.connectTimeout(20, TimeUnit.SECONDS);
        clientBuilder.readTimeout(20, TimeUnit.SECONDS);
        clientBuilder.writeTimeout(20, TimeUnit.SECONDS);
        OkHttpClient client = clientBuilder.build();
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(baseUrl);
        builder.client(client);
        builder.addConverterFactory(GsonConverterFactory.create());
        builder.addCallAdapterFactory(RxJava3CallAdapterFactory.create());
        Retrofit retrofit = builder.build();
        retrofitHashMap.put(baseUrl + serviceName, retrofit);
        return retrofit;
    }

}
