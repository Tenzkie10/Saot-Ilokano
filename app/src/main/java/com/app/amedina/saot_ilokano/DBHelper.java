package com.app.amedina.saot_ilokano;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="db_words";
    private static final String TABLE_NAME="tbl_words";
    private static final String COL1="english_words";
    private static final String COL2="ilokano_words";
    private static final String COL3="audio_file_name";
    private static final String COL4="favourites";
    private static final String COL5="category";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE "+TABLE_NAME+"("+ COL1+" TEXT,"+COL2+" TEXT, "+COL3+" TEXT, "+COL4+" INTEGER, "+COL5+" TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }
    //INSERT
    public boolean addWord(String eword, String iword, String audio, int fav,String category ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1,eword);
        contentValues.put(COL2,iword);
        contentValues.put(COL3,audio);
        contentValues.put(COL4,fav);
        contentValues.put(COL5,category);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    //GET ALL WORDS
    public Cursor getAllWordsByCategory(String category){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+TABLE_NAME+ " WHERE " +COL5+"= ?",new String[]{category});
        return data;
    }


    //GET ALL WORDS
    public Cursor getAllWords(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return data;
    }


    //GET WORD
    public Cursor getWord(String word){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+TABLE_NAME+ " WHERE " +COL1+" LIKE ? ",new String[]{"%"+word+"%"});
        return data;
    }

    public Cursor getWordFavorite(String word){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+TABLE_NAME+ " WHERE " +COL1+" = ? ",new String[]{word});
        return data;
    }
    //GET FAVORITES
    public Cursor getFavorites(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+TABLE_NAME+ " WHERE " +COL4+"= ?",new String[]{"1"});
        return data;
    }
    //DELETE
    public void deleteWord(String word){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + COL1+ "='"+word+"'";
        db.execSQL(query);
    }

    //UPDATE FAVORITES
    public void updateFavorite(String word, int favorite){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL4+ "="+favorite+" WHERE " + COL1+"='"+word+"'";
        db.execSQL(query);
    }






}
