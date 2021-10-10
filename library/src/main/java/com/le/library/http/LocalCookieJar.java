package com.le.library.http;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

public class LocalCookieJar implements CookieJar {
    List<Cookie> cookies;

    @NotNull
    @Override
    public List<Cookie> loadForRequest(@NotNull HttpUrl httpUrl) {
        if (cookies != null) {

            return cookies;
        }
        return new ArrayList<>();
    }

    @Override
    public void saveFromResponse(@NotNull HttpUrl httpUrl, @NotNull List<Cookie> cookies) {
        this.cookies = cookies;
    }
}
