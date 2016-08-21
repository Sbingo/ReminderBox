package sbingo.reminderbox;

import android.content.Intent;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("首页");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search_show);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setQueryHint("请输入想搜索的代码");

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
        switch (item.getItemId()) {
            case R.id.Snackbar:
//                Toast.makeText(MainActivity.this, getResources().getString(R.string.Snackbar), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, SnackbarActivity.class);
                startActivity(intent);
                return true;
            case R.id.Dialog:
                Toast.makeText(MainActivity.this, getResources().getString(R.string.Dialog), Toast.LENGTH_LONG).show();
                return true;
            case R.id.Notification:
                Toast.makeText(MainActivity.this, getResources().getString(R.string.Notification), Toast.LENGTH_LONG).show();
                return true;
            case R.id.Toast:
                Toast.makeText(MainActivity.this, getResources().getString(R.string.Toast), Toast.LENGTH_LONG).show();
                return true;
            case R.id.Pop:
                Toast.makeText(MainActivity.this, getResources().getString(R.string.PopupWindow), Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
