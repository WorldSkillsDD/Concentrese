package gt.wsdd.concentrese.vista;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import gt.wsdd.concentrese.R;

public class Splash extends Activity {

    private static final long timer = 2000L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread contador = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(timer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent miIntento = new Intent(Splash.this, Inicio.class);
                    startActivity(miIntento);
                }
            }
        };
        contador.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
