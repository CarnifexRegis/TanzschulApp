package database;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
/**
 * Used to interact with the android database manger
 * Source:http://www.programmierenlernenhq.de/sqlite-datenbank-in-android-app-integrieren/
 * http://www.programmierenlernenhq.de/tabelle-in-sqlite-datenbank-erstellen-in-android/
 * @author Simon Stolz
 * 
 */
public class TsDbHelper extends SQLiteOpenHelper{

    private static final String LOG_TAG = TsDbHelper.class.getSimpleName();
    public static final String DB_NAME = "ts_database.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_PICTURE = "picture";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_CSOURCE = "cs";
    public static final String COLUMN_SSOURCE = "ss";
    public static final String COLUMN_IDP = "idp";

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_PICTURE +
            "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_CSOURCE + " TEXT NOT NULL, " +
            COLUMN_SSOURCE + " TEXT ," +
             COLUMN_IDP + " INTEGER NOT NULL);";
    

    public TsDbHelper(Context context) {
        super(context, "DB_NAME", null, DB_VERSION);
        Log.d(LOG_TAG, "DbHelper hat die Datenbank: " + getDatabaseName() + " erzeugt.");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    	try {
            Log.d(LOG_TAG, "Die Tabelle wird mit SQL-Befehl: " + SQL_CREATE + " angelegt.");
            db.execSQL(SQL_CREATE);
        }
        catch (Exception ex) {
            Log.e(LOG_TAG, "Fehler beim Anlegen der Tabelle: " + ex.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}