package com.khoinguyen.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PointF;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

/**
 * Created by khoi2359 on 3/30/16.
 */
public final class UiUtils {
    /**
     * TODO: Result will be incorrect if only 1 in 2 views has fitSystemWindow=true
     * @param anchorView
     * @param elementView
     * @return
     */
    public static PointF getViewLocationInAnotherView(View anchorView, View elementView) {
        PointF loc = new PointF(0, 0);
        if (anchorView == null || elementView == null) {
            return loc;
        }

        int[] anchorViewLoc = new int[2];
        anchorView.getLocationInWindow(anchorViewLoc);
        int[] elementViewLoc = new int[2];
        elementView.getLocationInWindow(elementViewLoc);

        loc.x = elementViewLoc[0] - anchorViewLoc[0];
        loc.y = elementViewLoc[1] - anchorViewLoc[1];

        return loc;
    }

    public static void dismissDlg(Dialog dlg) {
        if (dlg != null && dlg.isShowing()) {
            dlg.dismiss();
        }
    }

    public static Dialog showSimpleProgressDlg(Context context, DialogInterface.OnCancelListener cancelListener) {
        Dialog dlg = new Dialog(context);
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dlg.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dlg.setContentView(new ProgressBar(context));
        dlg.setCancelable(true);
        dlg.setOnCancelListener(cancelListener);
        dlg.show();

        return dlg;
    }

    public static void makeStableLayout(View decorView) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN)
            return;

        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        );
    }

    public static void hideStatusBar(Window window, View decorView) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
            );
        } else {
            if (window != null) {
                window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
                decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
            }
        }
    }

    public static void showStatusBar(Window window, View decorView) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            );
        } else {
            if (window != null) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                decorView.setSystemUiVisibility(0);
            }
        }
    }

    public static boolean isStatusBarVisible(int visibility) {
        return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN
                && (visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0)
                || (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN
                && (visibility & View.SYSTEM_UI_FLAG_LOW_PROFILE) == 0);
    }

    public static boolean isStatusBarVisible(Window window, View decorView) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            return (decorView.getSystemUiVisibility() & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0;
        } else {
            return window != null && (decorView.getSystemUiVisibility() & View.SYSTEM_UI_FLAG_LOW_PROFILE) == 0;
        }
    }
}
