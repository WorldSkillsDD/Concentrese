package gt.wsdd.concentrese.controlador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import gt.wsdd.concentrese.modelo.Partida;

/**
 * Created by WorldSkills on 09/12/2015.
 */
public class PartidaManager {

    private static final String NOMBRE_TABLA = "Partida";
    private static final String CM_ID = "id";
    private static final String CM_NICKNAME = "nickname";
    private static final String CM_MODO_JUEGO = "modoJuego";
    private static final String CM_NIVEL = "nivel";
    private static final String CM_TIEMPO = "tiempo";
    private static final String CM_INTENTOS = "intentos";
    public static final String TABLA_PARTIDA = "CREATE TABLE " + NOMBRE_TABLA + "(" +
            CM_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , " +
            CM_NICKNAME + " TEXT NOT NULL, " +
            CM_MODO_JUEGO + " TEXT NOT NULL, " +
            CM_NIVEL + " INTEGER NOT NULL, " +
            CM_TIEMPO + " TEXT NOT NULL, " +
            CM_INTENTOS + " INTEGER NOT NULL" +
            ");";

    private DBHelper helper;
    private Context contexto;
    private SQLiteDatabase bd;

    public PartidaManager(Context contexto) {
        this.contexto = contexto;
    }

    public PartidaManager abrir() {
        helper = new DBHelper(this.contexto);
        bd = helper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        bd.close();
    }

    public ContentValues generarValores(Partida partida) {
        ContentValues valores = new ContentValues();
        valores.put(CM_NICKNAME, partida.getNickname());
        valores.put(CM_MODO_JUEGO, partida.getModoJuego());
        valores.put(CM_NIVEL, partida.getNivel());
        valores.put(CM_TIEMPO, partida.getTiempo());
        valores.put(CM_INTENTOS, partida.getIntentos());
        return valores;
    }

    public void insertar(Partida partida) {
        bd.insert(NOMBRE_TABLA, null, generarValores(partida));
    }

    public void insertarTemp() {
        bd.insert(NOMBRE_TABLA, null, generarValores(new Partida("Brim", "conTiempo", 1, "00:30", 8)));
        bd.insert(NOMBRE_TABLA, null, generarValores(new Partida("Brim2", "conTiempo", 2, "00:10", 4)));
        bd.insert(NOMBRE_TABLA, null, generarValores(new Partida("Brim3", "conTiempo", 3, "00:05", 5)));
        bd.insert(NOMBRE_TABLA, null, generarValores(new Partida("Brim4", "conTiempo", 2, "00:45", 2)));
        bd.insert(NOMBRE_TABLA, null, generarValores(new Partida("Brim5", "sinTiempo", 2, "00:45", 2)));
        bd.insert(NOMBRE_TABLA, null, generarValores(new Partida("Brim6", "sinTiempo", 2, "00:45", 2)));
        Log.i("BD", "agregando");
    }

    public ArrayList<Partida> obtenerPunteos(String modoJuego,int nivel) {
        Log.i("BD",modoJuego);
        ArrayList<Partida> partidas = new ArrayList<>();
        String[] columnas = {CM_NICKNAME, CM_MODO_JUEGO, CM_NIVEL, CM_TIEMPO, CM_INTENTOS};
         Cursor cursor = null;
        if (modoJuego.equals("conTiempo")) {
            cursor = bd.query(NOMBRE_TABLA, columnas, CM_NIVEL +" = "+ nivel, null, null, null, CM_TIEMPO + " ASC");
        } else if (modoJuego.equals("intentos")) {
            cursor = bd.query(NOMBRE_TABLA, columnas, CM_NIVEL +" = "+ nivel, null, null, null, CM_INTENTOS + " ASC");
        }

        Log.i("BD", String.valueOf(cursor));
        if (cursor != null) {
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                Partida partidaTemp = new Partida(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getString(3),
                        cursor.getInt(4)
                );
                partidas.add(partidaTemp);
                Log.i("BD", String.valueOf(partidas.size()));
            }
        }
        return partidas;
    }
}
