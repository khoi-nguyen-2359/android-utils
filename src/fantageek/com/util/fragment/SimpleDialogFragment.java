package fantageek.com.util.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class SimpleDialogFragment extends DialogFragment {
    private Dialog dialog;
    
    public static SimpleDialogFragment instantiate(Dialog dialog) {
        SimpleDialogFragment f = new SimpleDialogFragment();
        f.dialog = dialog;
        return f;
    }
    
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return dialog;
    }
}
