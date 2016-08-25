package Snackbar;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Sbingo on 2016/8/19.
 */
public class CustomSnackbar {

    private static Snackbar snackbar;
    private static CustomSnackbar customSnackbar;
    private String msg;
    private View v;
    private String action;
    private int actionTextColor;
    private Snackbar.Callback callback;


    public static CustomSnackbar getInstance(@NonNull Snackbar snackbar) {
        if (customSnackbar == null) {
            customSnackbar = new CustomSnackbar();
        }
        CustomSnackbar.snackbar = snackbar;
        return customSnackbar;
    }

    public CustomSnackbar setBackgroundColor(@ColorInt int color) {
        getBackground().setBackgroundColor(color);
        return this;
    }

    public CustomSnackbar setBackgroundColor(Drawable background) {
        getBackground().setBackground(background);
        return this;
    }

    public CustomSnackbar addView(int layoutId, int index) {
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) getBackground();
        View add_view = LayoutInflater.from(getBackground().getContext()).inflate(layoutId, null);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        p.gravity = Gravity.CENTER_VERTICAL;
        snackbarLayout.addView(add_view, index, p);
        return this;
    }

    public void show() {
        snackbar.show();
    }

    private View getBackground() {
        return snackbar.getView();
    }
}
