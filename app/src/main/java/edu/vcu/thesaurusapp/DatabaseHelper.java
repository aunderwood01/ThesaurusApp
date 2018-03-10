package edu.vcu.thesaurusapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "wordpairs.db";
    private static final String TABLE_NAME = "wordpairs";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_WORD = "word";
    private static final String COLUMN_SYNONYM = "synonym";
    private static final String TABLE_CREATE = "create table " + TABLE_NAME + " (id integer primary key not null , " +
            "word text not null, synonym text not null)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_CREATE);
    }

    public void insertWordPair(WordPairs wp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

//        String query = "select * from " + TABLE_NAME;
//        Cursor cursor = db.rawQuery(query, null);
//        int count = cursor.getCount();
//
//        values.put(COLUMN_ID, count);
        values.put(COLUMN_WORD, wp.getWord());
        values.put(COLUMN_SYNONYM, wp.getSynonym());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchWord(String word) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b; //a is word, b is synonym
        b = "Word not found";

        if(cursor.moveToFirst()) {
            /*do {
                a = cursor.getString(0);
                if(a.equals(word)) {
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());*/
            while(cursor.moveToNext()) {
                a = cursor.getString(1);

                if(a.equals(word)) {
                    b = cursor.getString(2);
                    break;
                }
            }
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        sqLiteDatabase.execSQL(query);
        this.onCreate(sqLiteDatabase);
    }
}
