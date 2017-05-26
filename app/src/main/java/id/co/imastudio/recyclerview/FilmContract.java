package id.co.imastudio.recyclerview;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by idn on 5/26/2017.
 */

public class FilmContract {

    public static final String AUTHORITY = "id.co.imastudio.recyclerview";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);
    public static final String PATH_TASKS = "listfilm";

    public static final class FilmEntry implements BaseColumns {

        //Untuk Uri
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_TASKS).build();


        //untuk SQLite
        public static final String TABLE_NAME = "film";

        public static final String COLUMN_JUDUL = "title";
        public static final String COLUMN_POSTER = "poster_path";

    }
}
