package gt.wsdd.concentrese;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

private Boolean estadoFMJ = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                if(!estadoFMJ){
                    findViewById(R.id.fab3).setVisibility(View.VISIBLE);
                    findViewById(R.id.fab4).setVisibility(View.VISIBLE);
                    estadoFMJ = true;
                }else{
                    findViewById(R.id.fab3).setVisibility(View.INVISIBLE);
                    findViewById(R.id.fab4).setVisibility(View.INVISIBLE);
                    estadoFMJ = false;
                }

            }
        });
    }

}
