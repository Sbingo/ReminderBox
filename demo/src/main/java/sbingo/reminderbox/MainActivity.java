package sbingo.reminderbox;

import android.content.Intent;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.mipmap.ic_launcher);
        actionBar.setTitle("homepage");
        actionBar.setSubtitle("choose from menu");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search_show);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setQueryHint("type whatever you want");

        MenuItemCompat.OnActionExpandListener expandListener = new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                Toast.makeText(MainActivity.this, "over", Toast.LENGTH_LONG).show();
                return true;  // Return true to collapse action view
            }

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                Toast.makeText(MainActivity.this, "start", Toast.LENGTH_LONG).show();
                return true;  // Return true to expand action view
            }
        };

        MenuItemCompat.setOnActionExpandListener(searchItem, expandListener);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.Snackbar:
                intent = new Intent(MainActivity.this, SnackbarActivity.class);
                startActivity(intent);
                return true;
            case R.id.Dialog:
                intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
                return true;
            case R.id.Notification:
                Toast.makeText(MainActivity.this, getResources().getString(R.string.Notification), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Toast:
                Toast.makeText(MainActivity.this, getResources().getString(R.string.Toast), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Pop:
                Toast.makeText(MainActivity.this, getResources().getString(R.string.PopupWindow), Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
