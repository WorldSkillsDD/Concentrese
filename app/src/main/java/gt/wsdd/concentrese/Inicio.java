package gt.wsdd.concentrese;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Inicio extends Activity implements View.OnClickListener {

    private Dialog dNickname;
    private EditText etNickname;
    private Button bAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        iniciarVars();

    }

    private void iniciarVars() {
        dNickname = new Dialog(this);
        dNickname.setTitle(getResources().getString(R.string.ingresa_nickname));
        dNickname.setCancelable(false);
        etNickname = (EditText) findViewById(R.id.etNickname);
        dNickname.setContentView(R.layout.ingreso_nickname);
        dNickname.show();

        dNickname.findViewById(R.id.bAceptar).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bAceptar:
                dNickname.dismiss();
                break;
        }
    }
}
