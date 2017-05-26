package id.co.imastudio.recyclerview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by idn on 5/26/2017.
 */

public class FilmDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "film.db";

    private static final int DATABASE_VERSION = 3;

    public FilmDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String SQL_CREATE_WEATHER_TABLE =

                "CREATE TABLE " + FilmContract.FilmEntry.TABLE_NAME + " (" +

                        FilmContract.FilmEntry._ID               + " INTEGER PRIMARY KEY AUTOINCREMENT, " +

                        FilmContract.FilmEntry.COLUMN_JUDUL       + " INTEGER NOT NULL, "                 +

                        FilmContract.FilmEntry.COLUMN_POSTER        + " INTEGER NOT NULL," +

                        " UNIQUE (" + FilmContract.FilmEntry.COLUMN_JUDUL + ") ON CONFLICT REPLACE);";

        sqLiteDatabase.execSQL(SQL_CREATE_WEATHER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + FilmContract.FilmEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
