package com.le.library.utils;

import android.annotation.SuppressLint;
import android.widget.TextView;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import static java.util.concurrent.TimeUnit.SECONDS;

public class XCountDown {
    private static Disposable timer;

    @SuppressLint( "SetTextI18n" )
    public static void setVCode(TextView textView, int count) {
        timer = Observable.interval(0, 1, SECONDS)
                .take(count)
                .map(aLong -> count - 1 - aLong)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> {
                    if (timer == null) {
                        return;
                    }
                    if (aLong > 0 && !timer.isDisposed()) {
                        textView.setEnabled(false);
                        textView.setText(aLong + "s");
                    } else {
                        textView.setEnabled(true);
                        textView.setText("发送验证码");
                    }
                }, Throwable::printStackTrace);
    }

    public static void timerClose() {
        if (timer != null && !timer.isDisposed()) {
            timer.dispose();
            timer = null;
        }
    }
}
