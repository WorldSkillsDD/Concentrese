package gt.wsdd.concentrese.vista;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import gt.wsdd.concentrese.R;
import gt.wsdd.concentrese.controlador.ExpandableList;
import gt.wsdd.concentrese.modelo.Partida;

public class Puntuacion extends Activity {

    private ExpandableListAdapter adapterIntentos, adapterTiempos;
    ExpandableListView expIntentos, expTiempos;
    private List<String> grupos;
    private HashMap<String, List<Partida>> itemsIntentos, itemsTiempo;


    TabHost tabHost;
    TabHost.TabSpec specIntentos, specTiempo;

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
        adapterTiempos = new ExpandableList(this, grupos, itemsIntentos, "tiempos");

        expIntentos.setAdapter(adapterIntentos);
        expTiempos.setAdapter(adapterTiempos);
    }

    private void dataIntentos() {

        List<Partida> dataFacil = new ArrayList<Partida>();
        Partida partida = new Partida("fulano", "con Tiempo", 1, "00:20", 5);
        Partida partida1 = new Partida("mengano", "con Tiempo", 1, "00:15", 3);
        Partida partida2 = new Partida("sutano", "sin Tiempo", 1, "00:10", 4);
        Partida partida3 = new Partida("perenzejo", "con Tiempo", 1, "00:08", 2);
        dataFacil.add(partida);
        dataFacil.add(partida1);
        dataFacil.add(partida2);
        dataFacil.add(partida3);

        List<String> dataNormal = new ArrayList<String>();
        dataNormal.add("normal");
        dataNormal.add("normal");
        dataNormal.add("normal");
        dataNormal.add("normal");

        List<String> dataDificil = new ArrayList<String>();
        dataDificil.add("dificil");
        dataDificil.add("dificil");
        dataDificil.add("dificil");
        dataDificil.add("dificil");


        itemsIntentos.put(grupos.get(0), dataFacil);
        itemsIntentos.put(grupos.get(1), dataFacil);
        itemsIntentos.put(grupos.get(2), dataFacil);
    }
}