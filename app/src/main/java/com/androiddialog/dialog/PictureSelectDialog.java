package com.androiddialog.dialog;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.androiddialog.R;

public class PictureSelectDialog {
    public static Dialog creatDialog(final Context context) {
        final Dialog dialog = new Dialog(context, R.style.dialog);
        dialog.setContentView(R.layout.dialog_picture_select);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        lp.gravity = Gravity.BOTTOM;
        lp.width = width;
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }

}
