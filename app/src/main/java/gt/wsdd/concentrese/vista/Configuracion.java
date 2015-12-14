package gt.wsdd.concentrese.vista;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.print.PageRange;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import gt.wsdd.concentrese.R;
import gt.wsdd.concentrese.utils.Parametros;

public class Configuracion extends AppCompatActivity implements View.OnClickListener {


    private SharedPreferences sp;
    private SharedPreferences.Editor editorSP;
    private FloatingActionButton fabModoJuego;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarVars();

    }

    private void iniciarVars() {


        fabModoJuego = (FloatingActionButton) findViewById(R.id.fabModoJuego);
        fabModoJuego.setOnClickListener(this);


        findViewById(R.id.fabSinTiempo).setOnClickListener(this);
        findViewById(R.id.fabConTiempo).setOnClickListener(this);

        sp = getSharedPreferences(Parametros.NOMBRE_SP, Context.MODE_PRIVATE);
        editorSP = sp.edit();
        cambiarImagenFab();


    }

    private void estadooModoJuego(boolean estado) {
        if (!estado) {
            findViewById(R.id.fabConTiempo).setVisibility(View.VISIBLE);
            findViewById(R.id.fabSinTiempo).setVisibility(View.VISIBLE);

        } else {
            findViewById(R.id.fabConTiempo).setVisibility(View.INVISIBLE);
            findViewById(R.id.fabSinTiempo).setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void onClick(View v) {
        ImageView ivFab = new ImageView(this);
        switch (v.getId()) {
            case R.id.fabModoJuego:
                estadooModoJuego(false);
                break;
            case R.id.fabSinTiempo:
                editorSP.putString(Parametros.MODO_JUEGO_KEY, Parametros.MODO_JUEGO_DEFAULT).commit();
                estadooModoJuego(true);
                cambiarImagenFab();
                break;
            case R.id.fabConTiempo:
                editorSP.putString(Parametros.MODO_JUEGO_KEY, "conTiempo").commit();
                estadooModoJuego(true);
                cambiarImagenFab();
                break;

        }


    }

    private void cambiarImagenFab() {
        String modoJuego = sp.getString(Parametros.MODO_JUEGO_KEY, Parametros.MODO_JUEGO_DEFAULT);
        if (modoJuego.equals(Parametros.MODO_JUEGO_DEFAULT)) {
            fabModoJuego.setImageResource(R.drawable.cronometro_inactivo);
        } else {
            fabModoJuego.setImageResource(R.drawable.cronometro_activo);
        }
    }
}
