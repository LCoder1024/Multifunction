package com.le.library.utils;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;

import androidx.core.widget.NestedScrollView;

import com.blankj.utilcode.util.ToastUtils;

import java.io.File;
import java.io.OutputStream;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class XImageUtils {
    public static void saveBitmapToPhoto(Context context, Bitmap bitmap) {
        String fileName = "Picture_" + System.currentTimeMillis() + ".jpg";
        Observable.create((ObservableOnSubscribe<Boolean>) emitter -> {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
                try {
                    String insertImage = MediaStore.Images.Media.insertImage(context.getContentResolver(),
                            bitmap, fileName, null);
                    String realPath = getRealPathFromURI(Uri.parse(insertImage), context);
                    if (realPath != null) {
                        File file = new File(realPath);
                        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(file)));
                    } else {
                        emitter.onNext(false);
                        emitter.onComplete();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    emitter.onNext(true);
                    emitter.onComplete();
                }
            } else {
                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.DESCRIPTION, "This is se tu");
                values.put(MediaStore.Images.Media.DISPLAY_NAME, fileName);
                values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
                values.put(MediaStore.Images.Media.TITLE, "Image.jpg");
                values.put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/");
                Uri uri = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                OutputStream outputStream;
                try {
                    outputStream = context.getContentResolver().openOutputStream(uri);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    emitter.onError(e);
                    emitter.onComplete();
                } finally {
                    emitter.onNext(true);
                    emitter.onComplete();
                }
            }
        }).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Boolean aBoolean) {
                        ToastUtils.showShort("保存成功");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private static String getRealPathFromURI(Uri contentUri, Context context) {
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = context.getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            String cursorString = cursor.getString(columnIndex);
            cursor.close();
            return cursorString;
        }
        return "";
    }

    public static Bitmap createViewBitmap(NestedScrollView nestedScrollView, int resId) {
        Bitmap bitmap;
        int h = 0;
        int width = nestedScrollView.getWidth();
        for (int i = 0; i < nestedScrollView.getChildCount(); i++) {
            h += nestedScrollView.getChildAt(i).getHeight();
            nestedScrollView.getChildAt(i).setBackgroundResource(resId);
        }
        bitmap = Bitmap.createBitmap(width, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        nestedScrollView.draw(canvas);
        return bitmap;
    }

    public static Bitmap createViewBitmap(NestedScrollView nestedScrollView) {
        Bitmap bitmap;
        int h = 0;
        int width = nestedScrollView.getWidth();
        for (int i = 0; i < nestedScrollView.getChildCount(); i++) {
            h += nestedScrollView.getChildAt(i).getHeight();
            nestedScrollView.getChildAt(i).setBackgroundColor(Color.WHITE);
        }
        bitmap = Bitmap.createBitmap(width, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        nestedScrollView.draw(canvas);
        return bitmap;
    }
}
