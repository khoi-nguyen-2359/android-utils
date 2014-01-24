package fantageek.com.util.helper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class GUIUtil {
    public static AlertDialog buildAlert(Context context, int titleId, int messageId, String buttonPositive,
            OnClickListener positiveClick, String buttonNegative, OnClickListener negativeClick, boolean isCancelable) {
        String title = context.getString(titleId);
        String message = context.getString(messageId);
        return buildAlert(context, title, message, buttonPositive, positiveClick, buttonNegative, negativeClick,
                isCancelable);
    }

    public static AlertDialog buildAlert(Context context, String title, String message, String buttonPositive,
            OnClickListener positiveClick, String buttonNegative, OnClickListener negativeClick, boolean isCancelable) {
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
        if (positiveClick == null) {
            positiveClick = new OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            };
        }

        alert.setButton(DialogInterface.BUTTON_POSITIVE, buttonPositive, positiveClick);

        if (buttonNegative != null) {
            if (negativeClick == null) {
                negativeClick = new OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                };
            }

            alert.setButton(DialogInterface.BUTTON_NEGATIVE, buttonNegative, negativeClick);
        }

        return alert;
    }
}
