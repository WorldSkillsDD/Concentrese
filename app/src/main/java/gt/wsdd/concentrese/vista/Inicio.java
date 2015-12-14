package gt.wsdd.concentrese.vista;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import gt.wsdd.concentrese.utils.Parametros;
import gt.wsdd.concentrese.R;
import gt.wsdd.concentrese.controlador.PartidaManager;

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
        sp = getSharedPreferences(Parametros.NOMBRE_SP, Context.MODE_PRIVATE);
        editorSP = sp.edit();

        findViewById(R.id.bConfiguraciones).setOnClickListener(this);
        findViewById(R.id.bPunteos).setOnClickListener(this);
        findViewById(R.id.bJugar).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bAceptar:
                editorSP.putString(Parametros.NICKNAME_KEY, etNickname.getText().toString().trim());
                editorSP.commit();
                dNickname.dismiss();
                break;
            case R.id.bJugar:
                PartidaManager pm = new PartidaManager(this);
                pm.abrir();
                pm.insertarTemp();
                pm.cerrar();
                break;
            case R.id.bConfiguraciones:
                Intent miIntento = new Intent(Inicio.this, Configuracion.class);
                startActivity(miIntento);
                break;
            case R.id.bPunteos:
                Intent intentoPunteos = new Intent(Inicio.this, Puntuacion.class);
                startActivity(intentoPunteos);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(Inicio.this, sp.getString(Parametros.MODO_JUEGO_KEY, ""), Toast.LENGTH_SHORT).show();
    }
}
