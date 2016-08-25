package sbingo.reminderbox;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import Snackbar.CustomSnackbar;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Sbingo on 2016/8/21 0021.
 */
public class SnackbarActivity extends BaseActivity {

    @BindView(R.id.tv_content)
    TextView tvContent;

    private ActionBar actionBar;
    Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: 2016/8/23 设置布局
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        actionBar = getSupportActionBar();
        actionBar.setTitle("Snackbar");
        actionBar.setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);
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
                CustomSnackbar.getInstance(createSnackbar(tvContent, "不小心点错了？", "取消"))
                        .setBackgroundColor(Color.BLUE)
                        .addView(R.layout.activity_main,0)
                        .show();
                return true;
            case R.id.custom:
                Toast.makeText(this, "custom Snackbar", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    Snackbar createSnackbar(View v, String msg, String action) {
       return snackbar = Snackbar
                .make(v, msg, Snackbar.LENGTH_LONG)
                .setAction(action, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snackbar.dismiss();
                    }
                });
    }
}
