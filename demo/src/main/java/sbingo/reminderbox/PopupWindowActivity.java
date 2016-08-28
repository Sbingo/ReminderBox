package sbingo.reminderbox;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import PopupWindow.CustomPopupWindow;
import sbingo.reminderbox.View.PopupTestView;

/**
 * Created by Sbingo on 2016/8/26.
 */
public class PopupWindowActivity extends BaseActivity {

    private ActionBar actionBar;
    private CustomPopupWindow customPopupWindow;
    private PopupTestView popupTestView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupwindow_layout);

        actionBar = getSupportActionBar();
        actionBar.setTitle("PopupWindow");
        actionBar.setDisplayHomeAsUpEnabled(true);

        customPopupWindow = new CustomPopupWindow(PopupWindowActivity.this);
        /** This is optional */
        customPopupWindow.setListener(new CustomPopupWindow.DismissCallBack() {
            @Override
            public void dismissCallBack() {
                Toast.makeText(PopupWindowActivity.this, "popup dismiss", Toast.LENGTH_SHORT).show();
            }
        });

        /** create the view to popup yourself */
        popupTestView = new PopupTestView(PopupWindowActivity.this);
        popupTestView.setListener(new PopupTestView.PopListener() {
            @Override
            public void close() {
                if (CustomPopupWindow.popupWindow != null) {
                    CustomPopupWindow.popupWindow.dismiss();
                }
            }
        });
    }

    public void showRight(View v) {
        customPopupWindow.showOnRight(v, popupTestView, -1, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT, 0, 0);
    }

    public void showLeft(View v) {
        customPopupWindow.showOnLeft(v, popupTestView, -1, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT, 0, 0);
    }

    public void showTop(View v) {
        customPopupWindow.showOnTop(v, popupTestView, 0, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0, 0);
    }

    public void showBottom(View v) {
        /** {@link CustomPopupWindow#setGravity(int)} is optional */
        customPopupWindow.setGravity(Gravity.BOTTOM | Gravity.RIGHT);
        customPopupWindow.showOnBottom(v, popupTestView, 0, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0, 0);
    }

    public void showFullScreen(View v) {
        customPopupWindow.showFullScreen(v, popupTestView, R.style.pop_fullscreen_style, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 0, 0);
    }

    public void showScreenBottom(View v) {
        customPopupWindow.showOnScreenBottom(v, popupTestView, R.style.pop_bottom_style, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0, 0);
    }

}
