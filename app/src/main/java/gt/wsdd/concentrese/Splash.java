package gt.wsdd.concentrese;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class Splash extends AppCompatActivity {

    private static final long timer = 5000L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread contador = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(timer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    Intent miIntento = new Intent (Splash.this,Inicio.class);
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
