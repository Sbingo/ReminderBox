package Snackbar;

import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;

/**
 * Created by Sbingo on 2016/8/19.
 */
public class CustomSnackbar {

    private Snackbar snackbar;
    private String msg;
    private View v;
    private String action;
    private int actionTextColor;
    private Snackbar.Callback callback;

    public static CustomSnackbar Build(@NonNull View v, @NonNull String msg) {
        return new CustomSnackbar();
    }

    public void show() {
        snackbar = Snackbar
                .make(v, msg, Snackbar.LENGTH_LONG)
                .setAction(action, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snackbar.dismiss();
                    }
                })
                .setActionTextColor(actionTextColor)
                .setCallback(callback);
        snackbar.show();
    }

}
