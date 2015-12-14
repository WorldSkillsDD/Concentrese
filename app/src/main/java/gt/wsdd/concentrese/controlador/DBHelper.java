package gt.wsdd.concentrese.controlador;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import gt.wsdd.concentrese.utils.Parametros;

/**
 * Created by WorldSkills on 09/12/2015.
 */
public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context) {
        super(context, Parametros.NOMBRE_BD, null, Parametros.VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PartidaManager.TABLA_PARTIDA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
