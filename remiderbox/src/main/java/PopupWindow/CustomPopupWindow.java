package PopupWindow;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

import sbingo.remiderbox.R;

/**
 * Created by Sbingo on 2016/8/26.
 * todo
 */
public class CustomPopupWindow {

    public static PopupWindow popupWindow;
    private DismissCallBack dismissCallBack;
    private FrameLayout frameLayout;
    private int gravity;
    private int screenWidth;
    private int screenHight;

    public CustomPopupWindow(Context context) {
        popupWindow = new PopupWindow();
        frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.popupBackground));
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        screenWidth = context.getResources().getDisplayMetrics().widthPixels;
        screenHight = context.getResources().getDisplayMetrics().heightPixels;
        gravity = Gravity.CENTER;
    }

    private void createPopupWindow(View popupView, int width, int height, int animationStyle) {
        popupWindow = new PopupWindow(popupView, width, height, true);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                if (dismissCallBack != null)
                    dismissCallBack.dismissCallBack();
            }
        });
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setAnimationStyle(animationStyle);
    }

    public interface DismissCallBack {
        void dismissCallBack();
    }

    public void setListener(DismissCallBack listener) {
        this.dismissCallBack = listener;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public void showOnBottom(View parentView, View contentView, int style, int width, int height, int xOff, int yOff) {
        frameLayout.removeAllViews();
        frameLayout.addView(contentView,new ViewGroup.LayoutParams(width, height));
        ((FrameLayout.LayoutParams)contentView.getLayoutParams()).gravity = gravity;
        createPopupWindow(frameLayout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, style);
        popupWindow.showAsDropDown(parentView, xOff, yOff);
    }

    public void showOnTop(View parentView, View contentView, int style, int width, int height, int xOff, int yOff) {
        frameLayout.removeAllViews();
        frameLayout.addView(contentView,new ViewGroup.LayoutParams(width, height));
        ((FrameLayout.LayoutParams)contentView.getLayoutParams()).gravity = gravity;
        createPopupWindow(frameLayout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, style);
        int[] location = new int[2];
        parentView.getLocationOnScreen(location);
        popupWindow.showAtLocation(parentView, Gravity.NO_GRAVITY, location[0] + xOff, location[1] + yOff - contentView.getMeasuredHeight());
    }

    public void showOnLeft(View parentView, View contentView, int style, int width, int height, int xOff, int yOff) {
        frameLayout.removeAllViews();
        frameLayout.addView(contentView,new ViewGroup.LayoutParams(width, height));
        ((FrameLayout.LayoutParams)contentView.getLayoutParams()).gravity = gravity;
        createPopupWindow(frameLayout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, style);
        int[] location = new int[2];
        parentView.getLocationOnScreen(location);
        popupWindow.showAtLocation(parentView, Gravity.NO_GRAVITY, location[0] - contentView.getMeasuredWidth() + xOff, yOff);
    }

    public void showOnRight(View parentView, View contentView, int style, int width, int height, int xOff, int yOff) {
        frameLayout.removeAllViews();
        frameLayout.addView(contentView,new ViewGroup.LayoutParams(width, height));
        ((FrameLayout.LayoutParams)contentView.getLayoutParams()).gravity = Gravity.BOTTOM;
        createPopupWindow(frameLayout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, style);
        int[] location = new int[2];
        parentView.getLocationOnScreen(location);
        popupWindow.showAtLocation(parentView, Gravity.NO_GRAVITY, location[0] + parentView.getMeasuredWidth(), yOff);
    }

    public void showOnScreenBottom(View parentView, View contentView, int style, int width, int height, int xOff, int yOff) {
        frameLayout.removeAllViews();
        frameLayout.addView(contentView,new ViewGroup.LayoutParams(width, height));
        ((FrameLayout.LayoutParams)contentView.getLayoutParams()).gravity = Gravity.BOTTOM;
        createPopupWindow(frameLayout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, style);
        popupWindow.showAtLocation(parentView, Gravity.BOTTOM, xOff, yOff);
    }

    public void showFullScreen(View parentView, View contentView, int style, int width, int height, int xOff, int yOff) {
        frameLayout.removeAllViews();
        frameLayout.addView(contentView,new ViewGroup.LayoutParams(width, height));
        ((FrameLayout.LayoutParams)contentView.getLayoutParams()).gravity = Gravity.CENTER;
        createPopupWindow(frameLayout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, style);
        popupWindow.showAtLocation(parentView, Gravity.CENTER, xOff, yOff);
    }


}
