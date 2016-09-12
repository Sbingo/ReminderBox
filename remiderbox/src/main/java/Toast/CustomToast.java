package Toast;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import sbingo.remiderbox.R;

/**
 * Created by Sbingo on 2016/9/10.
 */
public class CustomToast {

    private static Toast customToast;
    private int duration = Toast.LENGTH_SHORT;
    private Context context;
    @LayoutRes
    private int layoutResource = R.layout.default_custom_toast;
    @IdRes
    private int toastId = R.id.toast;

    public CustomToast(Context context) {
        if (null != customToast) {
            customToast.cancel();
        }
        customToast = new Toast(context);
        this.context = context;
    }

    public CustomToast makeText(@StringRes int resId) {
        return makeText(context.getResources().getText(resId));
    }

    public CustomToast makeText(CharSequence text) {
        View layout = LayoutInflater.from(context).inflate(layoutResource, null);
        TextView content = null;
        if (toastId != 0) {
            content = (TextView) layout.findViewById(toastId);
        } else {
            throw new RuntimeException("toastId must have been set");
        }
        content.setText(text);
        customToast.setView(layout);
        customToast.setDuration(duration);
        return this;
    }

    public void show() {
        customToast.show();
    }

    /**
     * use your own layout
     * Notice:{@code setToastId(toastId)} must be called after call this.
     * @param layoutResource the layout resource id
     * @return
     */
    public CustomToast setLayoutResource(int layoutResource) {
        this.layoutResource = layoutResource;
        toastId = 0;
        return this;
    }

    /**
     * set the toast id
     * should only be called after call the {@code setLayoutResource(layoutResource}.
     * @param toastId usually the TextView's id of toast
     * @return
     */
    public CustomToast setToastId(int toastId) {
        this.toastId = toastId;
        return this;
    }

    /**
     * set the duration of the toast
     * @param duration {@link Toast#LENGTH_LONG}.{@link Toast#LENGTH_SHORT}
     * @return
     */
    public CustomToast setDuration(int duration) {
        this.duration = duration;
        return this;
    }

}
