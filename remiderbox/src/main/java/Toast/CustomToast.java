package Toast;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by Sbingo on 2016/9/10.
 */
public class CustomToast extends Toast {

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

    private static CustomToast customToast;

    @Override
    public void show() {
        if (customToast != null) {
            customToast.cancel();
        }
        super.show();
    }

    
}
