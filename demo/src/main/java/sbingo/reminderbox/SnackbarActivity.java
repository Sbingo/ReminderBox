package sbingo.reminderbox;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import Snackbar.CustomSnackbar;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Sbingo on 2016/8/21 0021.
 */
public class SnackbarActivity extends BaseActivity {


    @BindView(R.id.coordinator_layout)
    CoordinatorLayout coordinatorLayout;

    private ActionBar actionBar;
    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snackbar_layout);
        ButterKnife.bind(this);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Snackbar");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.snackbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.standard:
                createSnackbar(coordinatorLayout, "standard", "cancel").show();
                return true;
            case R.id.custom:
                /** use the {@link CustomSnackbar} here */
                CustomSnackbar.getInstance(createSnackbar(coordinatorLayout, "custom", "cancel"))
                        .setBackgroundColor(Color.GRAY)
                        .setMessageColor(Color.GREEN)
                        .addView(R.layout.snackbar_add_view, 0)
                        .show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * create a {@link Snackbar}.
     * Notice: to use the {@link CustomSnackbar}, pls create a {@link Snackbar} first.
     */
    private Snackbar createSnackbar(View v, final String msg, String action) {
        return snackbar = Snackbar
                .make(v, msg, Snackbar.LENGTH_LONG)
                .setAction(action, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snackbar.dismiss();
                        Toast.makeText(SnackbarActivity.this, msg + "_cancel", Toast.LENGTH_SHORT).show();
                    }
                })
                .setActionTextColor(Color.RED)
                .setCallback(new Snackbar.Callback() {
                    @Override
                    public void onDismissed(Snackbar snackbar, int event) {
                        /** do sth when the Snackbar is dismissed*/
                        switch (event) {
                            case DISMISS_EVENT_SWIPE:
                                /** while using the {@link CoordinatorLayout} in layout, the Snackbar can be swiped */
                                Toast.makeText(SnackbarActivity.this, msg + "_swipe", Toast.LENGTH_SHORT).show();
                                break;
                            case DISMISS_EVENT_ACTION:
                                Toast.makeText(SnackbarActivity.this, msg + "_action", Toast.LENGTH_SHORT).show();
                                break;
                            case DISMISS_EVENT_TIMEOUT:
                                Toast.makeText(SnackbarActivity.this, msg + "_timeout", Toast.LENGTH_SHORT).show();
                                /** you may want to do sth here */
                                break;
                            case DISMISS_EVENT_MANUAL:
                                Toast.makeText(SnackbarActivity.this, msg + "_manual", Toast.LENGTH_SHORT).show();
                                break;
                            case DISMISS_EVENT_CONSECUTIVE:
                                Toast.makeText(SnackbarActivity.this, msg + "_consecutive", Toast.LENGTH_SHORT).show();
                                break;
                            default:
                        }
                    }

                    @Override
                    public void onShown(Snackbar snackbar) {
                        /** do sth when the Snackbar is shown*/
                        Toast.makeText(SnackbarActivity.this, String.format("%s_show", msg), Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
