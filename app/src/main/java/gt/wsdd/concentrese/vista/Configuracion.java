package gt.wsdd.concentrese.vista;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import gt.wsdd.concentrese.R;
import gt.wsdd.concentrese.utils.Parametros;

public class Configuracion extends AppCompatActivity implements View.OnClickListener {


    private SharedPreferences sp;
    private SharedPreferences.Editor editorSP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarVars();

    }

    private void iniciarVars() {

        findViewById(R.id.fabModoJuego).setOnClickListener(this);
        findViewById(R.id.fabSinTiempo).setOnClickListener(this);
        findViewById(R.id.fabConTiempo).setOnClickListener(this);

        sp = getSharedPreferences(Parametros.NOMBRE_SP, Context.MODE_PRIVATE);
        editorSP = sp.edit();

    }

    private void cambiarEstadoFMJ(boolean estadoFMJ) {
        if (!estadoFMJ) {
            findViewById(R.id.fabConTiempo).setVisibility(View.VISIBLE);
            findViewById(R.id.fabSinTiempo).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.fabConTiempo).setVisibility(View.INVISIBLE);
            findViewById(R.id.fabSinTiempo).setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.fabModoJuego:
                cambiarEstadoFMJ(false);
                break;
            case R.id.fabSinTiempo:
                editorSP.putString(Parametros.MODO_JUEGO_KEY, "ConTiempo");
                cambiarEstadoFMJ(true);
                break;
            case R.id.fabConTiempo:
                editorSP.putString(Parametros.MODO_JUEGO_KEY, "SinTiempo");
                cambiarEstadoFMJ(true);
                break;

        }
        editorSP.commit();
    }
}
