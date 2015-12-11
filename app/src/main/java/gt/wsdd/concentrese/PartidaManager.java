package gt.wsdd.concentrese;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by WorldSkills on 09/12/2015.
 */
public class PartidaManager {

    private static final String NOMBRE_TABLA = "Partida";
    private static final String CM_ID = "ID";
    private static final String CM_NICKNAME = "Nickname";
    private static final String CM_MODO_JUEGO = "ModoJuego";
    private static final String CM_NIVEL = "Nivel";
    private static final String CM_TIEMPO = "Tiempo";
    private static final String CM_INTENTOS = "Puntos";
    public static final String TABLA_PARTIDA = "CREATE TABLE " + NOMBRE_TABLA + "(" +
            CM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" +
            CM_NICKNAME + " TEXT NOT NULL" +
            CM_MODO_JUEGO + " TEXT NOT NULL" +
            CM_NIVEL + " INTEGER NOT NULL" +
            CM_TIEMPO + "TEXT" +
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
        bd.insert(NOMBRE_TABLA, null, generarValores(new Partida("Brim2", "conTiempo", 1, "00:10", 4)));
        bd.insert(NOMBRE_TABLA, null, generarValores(new Partida("Brim3", "conTiempo", 1, "00:05", 5)));
        bd.insert(NOMBRE_TABLA, null, generarValores(new Partida("Brim4", "conTiempo", 1, "00:45", 2)));
    }
    public void obtenerPunteos(String modoJuego){

    }
}
