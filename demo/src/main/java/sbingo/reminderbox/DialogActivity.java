package sbingo.reminderbox;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Sbingo on 2016/8/22.
 */
public class DialogActivity extends BaseActivity implements View.OnClickListener {

    private ActionBar actionBar;
    private TextView standard;
    private TextView custom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(getLayoutInflater().inflate(R.layout.activity_dialog_toolbar, null),
                new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        actionBar.setDisplayHomeAsUpEnabled(true);
        initView();
    }

    private void initView() {
        standard =$(R.id.standard);
        custom = $(R.id.custom);

        standard.setOnClickListener(this);
        custom.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.standard:
                Toast.makeText(this,"standard", Toast.LENGTH_SHORT).show();
                break;
            case R.id.custom:
                Toast.makeText(this,"custom", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
    }
}
