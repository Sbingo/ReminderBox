package Toast;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import sbingo.remiderbox.R;

/**
 * Created by Sbingo on 2016/9/10.
 */
public class CustomToast extends Toast {

    private static CustomToast customToast;
    private int duration = Toast.LENGTH_SHORT;

    /**
     * Construct an empty Toast object.  You must call {@link #setView} before you
     * can call {@link #show}.
     *
     * @param context The context to use.  Usually your {@link Application}
     *                or {@link Activity} object.
     */
    public CustomToast(Context context) {
        super(context);
    }


    public CustomToast makeText(Context context, @StringRes int resId) {
        return makeText(context, context.getResources().getText(resId));
    }

    public CustomToast makeText(Context context, CharSequence text) {
        if (customToast != null) {
            customToast.cancel();
        } else {
            customToast = new CustomToast(context);
        }
        View layout = LayoutInflater.from(context).inflate(R.layout.default_custom_toast, null);
        TextView content = (TextView) layout.findViewById(R.id.toast);
        content.setText(text);
        customToast.setView(layout);
        customToast.setDuration(duration);
        customToast.show();
        return customToast;
    }


    public void setLayout(int layout) {

    }

}
