package gt.wsdd.concentrese;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Inicio extends AppCompatActivity {

    private Dialog dNickname;
    private EditText etNickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        iniciarVars();

    }

    private void iniciarVars() {
        dNickname = new Dialog(this);
        dNickname.setTitle("Ingresa tu nickname");
        dNickname.setCancelable(false);
        etNickname = new EditText(this);
        dNickname.setContentView(etNickname);
        
    }
}
