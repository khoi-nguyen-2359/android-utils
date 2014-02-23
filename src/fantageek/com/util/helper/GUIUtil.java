package fantageek.com.util.helper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Point;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public final class GUIUtil {
    
    public static Point getScreenSize(Context context) {
        Point size = new Point();
        
        WindowManager winMan = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = winMan.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        
        size.x = display.getWidth();
        size.y = display.getHeight();
        
        return size;
    }

    public static float dpToPx(Context context, float dpNum) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float px = dpNum * displayMetrics.density;
        return px;
    }

    public static int replaceFragment(FragmentActivity fa, int id, Fragment f, int animEnter, int animExit) {
        FragmentManager fm = fa.getSupportFragmentManager();
        return fm.beginTransaction().replace(id, f).setCustomAnimations(animEnter, animExit).commit();
    }

    public static AlertDialog buildAlert(Context context, int titleId, int messageId, int btnPositiveResId,
            OnClickListener positiveClick, int btnNegativeResId, OnClickListener negativeClick, boolean isCancelable) {
        String title = context.getString(titleId);
        String message = context.getString(messageId);
        String buttonPositive = context.getString(btnPositiveResId);
        String buttonNegative = context.getString(btnNegativeResId);

        AlertDialog alert = new AlertDialog.Builder(context).create();
        alert.setCancelable(isCancelable);

        if (title != null) {
            alert.setTitle(title);
        }
        if (message != null) {
            alert.setMessage(message);
        }
        if (buttonPositive == null) {
            buttonPositive = "OK";
        }

        OnClickListener defaultOnclick = new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };

        if (positiveClick == null) {
            positiveClick = defaultOnclick;
        }

        alert.setButton(DialogInterface.BUTTON_POSITIVE, buttonPositive, positiveClick);

        if (buttonNegative != null) {
            if (negativeClick == null) {
                negativeClick = defaultOnclick;
            }

            alert.setButton(DialogInterface.BUTTON_NEGATIVE, buttonNegative, negativeClick);
        }

        return alert;
    }
}
