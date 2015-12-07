package gt.wsdd.concentrese;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.view.Window;
import android.widget.Button;

import java.util.List;

/**
 * Created by WorldSkills on 07/12/2015.
 */
public class Configuraciones extends PreferenceActivity {

    @Override
    protected boolean isValidFragment(String fragmentName) {
        return ModoJuegoFragment.class.getName().equals(fragmentName);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onBuildHeaders(List<Header> target) {
        super.onBuildHeaders(target);
        loadHeadersFromResource(R.xml.headers_configuraciones,target);
    }
    public static class ModoJuegoFragment extends PreferenceFragment{
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.configuraciones);        }
    }
}
