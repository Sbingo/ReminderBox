package sbingo.reminderbox;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Sbingo on 2016/8/22.
 */
public class DialogActivity extends BaseActivity {


    @BindView(R.id.standard)
    TextView standard;
    @BindView(R.id.custom)
    TextView custom;

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(getLayoutInflater().inflate(R.layout.activity_dialog_toolbar, null),
                new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        actionBar.setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.standard, R.id.custom})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.standard:
                Toast.makeText(this, "standard dialog", Toast.LENGTH_SHORT).show();
                break;
            case R.id.custom:
                Toast.makeText(this, "custom dialog", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
