package PopupWindow;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.PopupWindow;

/**
 * Created by Sbingo on 2016/8/26.
 * todo
 */
public class CustomPopupWindow extends PopupWindow {

    private static CustomPopupWindow customPopupWindow;
    private boolean hasCreated;

    public static CustomPopupWindow getInstance() {
        if (customPopupWindow == null) {
            customPopupWindow = new CustomPopupWindow();
        }
        return customPopupWindow;
    }

    private void createPopupWindow(View popupView, int width, int height, int animationStyle) {
        if (hasCreated) {
            return;
        }
        customPopupWindow = (CustomPopupWindow) new PopupWindow(popupView, width, height, true);
        // 使其聚集
        customPopupWindow.setTouchable(true);
        // 设置允许在外点击消失
        customPopupWindow.setOutsideTouchable(true);
        customPopupWindow.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
//                if (dimissCallBack != null)
//                    dimissCallBack.dimissCallBack();
            }
        });
        // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        customPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        customPopupWindow.setAnimationStyle(animationStyle);
        hasCreated = true;
    }

    public void showOnBottom(View parentView, View contentView, int width, int height, int xoff, int yoff) {
        createPopupWindow(contentView, width, height, -1);
        customPopupWindow.showAsDropDown(parentView, xoff, yoff);
    }

    public void showOnTop() {

    }

    public void showOnLeft() {

    }

    public void showOnRight() {

    }

    public void show() {

    }
}
