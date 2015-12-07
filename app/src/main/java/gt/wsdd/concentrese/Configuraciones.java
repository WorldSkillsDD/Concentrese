package gt.wsdd.concentrese;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.Window;

/**
 * Created by WorldSkills on 07/12/2015.
 */
public class Configuraciones extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.configuraciones);
    }
}
