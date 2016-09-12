package sbingo.reminderbox;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;

import Toast.CustomToast;

/**
 * Created by Sbingo on 2016/9/10.
 */
public class ToastActivity extends BaseActivity {

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Toast");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toast_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.normal:
                new CustomToast(ToastActivity.this).makeText("I am normal").show();
                return true;
            case R.id.custom:
                new CustomToast(ToastActivity.this).setLayoutResource(R.layout.custom_toast).setToastId(R.id.custom_toast).makeText("custom i am").show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
