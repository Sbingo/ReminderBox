package sbingo.reminderbox;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import PopupWindow.CustomPopupWindow;

/**
 * Created by Sbingo on 2016/8/26.
 */
public class PopupWindowActivity extends BaseActivity {

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupwindow_layout);

        actionBar = getSupportActionBar();
        actionBar.setTitle("PopupWindow");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public void showRight(View v) {
        Toast.makeText(PopupWindowActivity.this, "1", Toast.LENGTH_SHORT).show();
        TextView tv = new TextView(PopupWindowActivity.this);
        tv.setText("just test ");
        CustomPopupWindow.getInstance().showOnBottom(getWindow().getDecorView(), tv, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0, 0);
    }

    public void showLeft(View v) {
        Toast.makeText(PopupWindowActivity.this, "2", Toast.LENGTH_SHORT).show();

    }

    public void showTop(View v) {
        Toast.makeText(PopupWindowActivity.this, "3", Toast.LENGTH_SHORT).show();

    }

    public void showBottom(View v) {
        Toast.makeText(PopupWindowActivity.this, "4", Toast.LENGTH_SHORT).show();

    }


}
