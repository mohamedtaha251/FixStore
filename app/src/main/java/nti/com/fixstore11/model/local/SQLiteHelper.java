package nti.com.fixstore11.model.local;

import android.app.Fragment;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "MyDB";
    public static final String TABLE_NAME = "ProfileImage";

    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    //public static final String COL_MAIL = "mail";

    public static final String CREATE_TABLE = "create table " + TABLE_NAME
            + "(id integer primary key autoincrement,name text not null,address text not null)";

    public static int DB_VERSION = 1;

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public long insert(String path) {
        SQLiteDatabase db = super.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, path);
        return db.insert(TABLE_NAME, null, values);
    }

    public boolean delete(int id) {
        SQLiteDatabase db = super.getWritableDatabase();
        return db.delete(TABLE_NAME, COL_ID + " = " + id, null) > 0;
    }

    public boolean update(int id, String newPath) {
        SQLiteDatabase db = super.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, newPath);
        return db.update(TABLE_NAME, values, COL_ID + " = " + id, null) > 0;
    }

    public Cursor getAll() {
        SQLiteDatabase db = super.getReadableDatabase();
        return db.query(TABLE_NAME, new String[]{COL_ID, COL_NAME}, null, null, null, null, null);

    }

    public Cursor getByID(int id) {
        SQLiteDatabase db = super.getReadableDatabase();
        return db.query(TABLE_NAME, new String[]{COL_ID, COL_NAME}, COL_ID + " = " + id, null, null, null, null);

    }
}
