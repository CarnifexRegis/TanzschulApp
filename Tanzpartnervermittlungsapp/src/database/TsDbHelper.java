package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
/**
 * Used to interact with the android database manger
 * Source:http://www.programmierenlernenhq.de/sqlite-datenbank-in-android-app-integrieren/
 * @author Simon Stolz
 * 
 */
public class TsDbHelper extends SQLiteOpenHelper{

    private static final String LOG_TAG = TsDbHelper.class.getSimpleName();


    public TsDbHelper(Context context) {
        super(context, "TS_DATABASE", null, 1);
        Log.d(LOG_TAG, "DbHelper hat die Datenbank: " + getDatabaseName() + " erzeugt.");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}