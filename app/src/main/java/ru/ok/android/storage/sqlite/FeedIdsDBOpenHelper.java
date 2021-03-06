package ru.ok.android.storage.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;
import ru.ok.android.utils.Logger;
import ru.ok.android.utils.db.CustomDirDBOpenHelper;

class FeedIdsDBOpenHelper extends CustomDirDBOpenHelper {
    private static volatile FeedIdsDBOpenHelper instance;

    public static FeedIdsDBOpenHelper getInstance(Context context) {
        if (instance == null) {
            synchronized (FeedIdsDBOpenHelper.class) {
                if (instance == null) {
                    instance = new FeedIdsDBOpenHelper(context.getApplicationContext());
                }
            }
        }
        return instance;
    }

    private FeedIdsDBOpenHelper(Context context) {
        super(context, new File(context.getFilesDir(), "storages"), "feed_ids.sqlite3", 1);
    }

    public void onCreate(SQLiteDatabase db) {
        long startTime = System.currentTimeMillis();
        Logger.m172d("onCreate >>>");
        Logger.m173d("onCreate: %s", "CREATE TABLE feed_ids (_id INTEGER PRIMARY KEY AUTOINCREMENT, digest TEXT NOT NULL UNIQUE ON CONFLICT IGNORE)");
        db.execSQL("CREATE TABLE feed_ids (_id INTEGER PRIMARY KEY AUTOINCREMENT, digest TEXT NOT NULL UNIQUE ON CONFLICT IGNORE)");
        Logger.m173d("onCreate <<< %d ms", Long.valueOf(System.currentTimeMillis() - startTime));
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Logger.m173d("onUpgrade: oldVersion=%d newVersion=%d", Integer.valueOf(oldVersion), Integer.valueOf(newVersion));
        Logger.m173d("onUpgrade: %s", "DROP TABLE IF EXISTS feed_ids");
        db.execSQL("DROP TABLE IF EXISTS feed_ids");
        onCreate(db);
    }
}
