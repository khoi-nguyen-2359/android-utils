package fantageek.com.util.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class UtilBaseAcitivity extends ActionBarActivity {
    public static final String KEY_CONTENT_VIEW_RES_ID = "KEY_CONTENT_VIEW_RES_ID";

    protected int resIdContentView;
    protected View contentView;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setupContentView();
        
        if (resIdContentView != -1)
            setContentView(resIdContentView);
        else
            setContentView(contentView);
        
        initViews();
        initActionBar();
    }
    
    protected void initActionBar() {
    }

    protected void initViews() {
    }

    protected void setupContentView() {
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        
        outState.putInt(KEY_CONTENT_VIEW_RES_ID, resIdContentView);
    }
}
