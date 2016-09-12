package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


public class TsDataSource {

    private static final String LOG_TAG = TsDataSource.class.getSimpleName();

    private SQLiteDatabase database;
    /**
     * An instance of our deb helper used to interact with the db
     */
    private TsDbHelper dbHelper;


    public TsDataSource(Context context) {
        Log.d(LOG_TAG, "Unsere DataSource erzeugt jetzt den dbHelper.");
        dbHelper = new TsDbHelper(context);
    }
}
