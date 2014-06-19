package fantageek.com.util.activity;

import android.app.Activity;
import android.os.Bundle;

public class UtilBaseAcitivity extends Activity {

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        if (arg0 != null) {
            onRestoreState(arg0);
        }
        onCreateView();
    }

    protected void onRestoreState(Bundle arg0) {
    }

    protected void onCreateView() {
        initContentView();
        initChildViews();
        initActionBar();
    }

    protected void initContentView() {
    }

    protected void initActionBar() {
    }

    protected void initChildViews() {
    }
}
