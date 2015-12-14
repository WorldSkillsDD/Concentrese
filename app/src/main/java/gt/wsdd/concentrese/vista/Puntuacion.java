package gt.wsdd.concentrese.vista;

import android.app.Activity;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.Window;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import gt.wsdd.concentrese.R;
import gt.wsdd.concentrese.controlador.ExpandableList;
import gt.wsdd.concentrese.controlador.PartidaManager;
import gt.wsdd.concentrese.modelo.Partida;

public class Puntuacion extends Activity implements TabHost.OnTabChangeListener {

    private ExpandableListAdapter adapterIntentos, adapterTiempos;
    private ExpandableListView expIntentos, expTiempos;
    private List<String> grupos;
    private HashMap<String, List<Partida>> itemsIntentos, itemsTiempo;


    private TabHost tabHost;
   private TabHost.TabSpec specIntentos, specTiempo;
    String modoJuego = "intentos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.punteos);
        iniciarVars();
    }

    private void iniciarVars() {
        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();


        specIntentos = tabHost.newTabSpec("INTENTOS");
        specIntentos.setContent(R.id.specIntentos);
        specIntentos.setIndicator("INTENTOS");

        specTiempo = tabHost.newTabSpec("TIEMPO");
        specTiempo.setContent(R.id.specTiempo);
        specTiempo.setIndicator("TIEMPO");

        tabHost.addTab(specIntentos);
        tabHost.addTab(specTiempo);

        grupos = new ArrayList<String>();
        grupos.add("Facíl");
        grupos.add("Normal");
        grupos.add("Difícil");
        itemsIntentos = new HashMap<String, List<Partida>>();
        itemsTiempo = new HashMap<String, List<Partida>>();

        expIntentos = (ExpandableListView) findViewById(R.id.expIntentos);
        expTiempos = (ExpandableListView) findViewById(R.id.expTiempos);

        dataIntentos();

        adapterIntentos = new ExpandableList(this, grupos, itemsIntentos, "intentos");
        expIntentos.setAdapter(adapterIntentos);

        adapterTiempos = new ExpandableList(this, grupos, itemsIntentos, "tiempos");
        expTiempos.setAdapter(adapterTiempos);
        tabHost.setOnTabChangedListener(this);
    }

    private void dataIntentos() {
        PartidaManager pm = new PartidaManager(this);
        pm.abrir();
        itemsIntentos.put(grupos.get(0), pm.obtenerPunteos(modoJuego, 1));
        itemsIntentos.put(grupos.get(1), pm.obtenerPunteos(modoJuego, 2));
        itemsIntentos.put(grupos.get(2), pm.obtenerPunteos(modoJuego, 3));
        pm.cerrar();
    }

    @Override
    public void onTabChanged(String tabId) {
        if (tabId.equals("INTENTOS")) {
            modoJuego = "intentos";
        } else {
            modoJuego = "conTiempo";
        }
        dataIntentos();
    }

}
