package com.le.library.loading;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;

import com.le.library.R;


public class LoadingDialog {

    private static ProgressWheel mProgressWheel = null;
    private static Dialog loadingDialog = null;

    public static Dialog initDialog(Context context) {

        return initDialog(context, null);
    }

    public static Dialog initDialog(Context context, String message) {
        dismissDialog();
        loadingDialog = new Dialog(context, R.style.Dialog) {
            @Override
            public void onWindowFocusChanged(boolean hasFocus) {
                super.onWindowFocusChanged(hasFocus);
                if (hasFocus && loadingDialog != null) {
                    mProgressWheel = loadingDialog.findViewById(R.id.progressWheel);
                    TextView tv_loading = loadingDialog.findViewById(R.id.tv_loading);
                    if (!TextUtils.isEmpty(message)) {
                        tv_loading.setText(message);
                    } else {
                        tv_loading.setText(context.getResources().getString(R.string.loading));
                    }
                    mProgressWheel.startSpinning();
                }
            }
        };
        loadingDialog.setContentView(R.layout.progress_wheel);
//        loadingDialog.setCancelable(false);
//        loadingDialog.setCanceledOnTouchOutside(false);
        return loadingDialog;
    }


    public static void dismissDialog() {
        if (mProgressWheel != null) {
            mProgressWheel.stopSpinning();
            mProgressWheel = null;
        }
        if (loadingDialog != null) {
            loadingDialog.dismiss();
            loadingDialog = null;
        }
    }

}
