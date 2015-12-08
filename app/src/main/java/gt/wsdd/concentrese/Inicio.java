package gt.wsdd.concentrese;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Inicio extends Activity implements View.OnClickListener {

    private Dialog dNickname;
    private EditText etNickname;

    private SharedPreferences sp;
    private SharedPreferences.Editor editorSP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        mostrarDialogo();
        iniciarVars();

    }

    private void mostrarDialogo() {
        dNickname = new Dialog(this);
        dNickname.setTitle(getResources().getString(R.string.ingresa_nickname));
        dNickname.setCancelable(false);
        dNickname.setContentView(R.layout.ingreso_nickname);
        dNickname.show();
    }

    private void iniciarVars() {
        etNickname = (EditText) dNickname.findViewById(R.id.etNickname);
        dNickname.findViewById(R.id.bAceptar).setOnClickListener(this);
        sp = getSharedPreferences("PreferenciasDD", Context.MODE_PRIVATE);
        editorSP = sp.edit();

        findViewById(R.id.bConfiguraciones).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bAceptar:
                editorSP.putString(Parametros.NICKNAME_KEY, etNickname.getText().toString().trim());
                editorSP.commit();
                dNickname.dismiss();
                break;
            case R.id.bConfiguraciones:
                Intent miIntento = new Intent(Inicio.this,MainActivity.class);
                startActivity(miIntento);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(Inicio.this, PreferenceManager.getDefaultSharedPreferences(this).getString("modojuego",""), Toast.LENGTH_SHORT).show();
    }
}
