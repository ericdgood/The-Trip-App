package com.example.edgoo.thetrip.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PlaceDbHelper extends SQLiteOpenHelper {

    public final static String DB_NAME = "trip.db";
    public final static int DB_VERSION = 1;
    public final static String LOG_TAG = PlaceDbHelper.class.getCanonicalName();

    public PlaceDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PlaceContract.PlaceEntry.CREATE_TABLE_STOCK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertItem(PlaceItem item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PlaceContract.PlaceEntry.COLUMN_PLACENAME, item.getPlaceName());
        values.put(PlaceContract.PlaceEntry.COLUMN_ADDRESS, item.getAddress());
        values.put(PlaceContract.PlaceEntry.COLUMN_START, item.getStartTime());
        values.put(PlaceContract.PlaceEntry.COLUMN_END, item.getEndTime());
        values.put(PlaceContract.PlaceEntry.COLUMN_CHECKLIST, item.getCheckList());
        values.put(PlaceContract.PlaceEntry.COLUMN_IMAGE, item.getImage());
        long id = db.insert(PlaceContract.PlaceEntry.TABLE_NAME, null, values);
    }

    public Cursor readStock() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                PlaceContract.PlaceEntry._ID,
                PlaceContract.PlaceEntry.COLUMN_PLACENAME,
                PlaceContract.PlaceEntry.COLUMN_ADDRESS,
                PlaceContract.PlaceEntry.COLUMN_START,
                PlaceContract.PlaceEntry.COLUMN_END,
                PlaceContract.PlaceEntry.COLUMN_CHECKLIST,
                PlaceContract.PlaceEntry.COLUMN_IMAGE
        };
        Cursor cursor = db.query(
                PlaceContract.PlaceEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }

    public Cursor readItem(long itemId) {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                PlaceContract.PlaceEntry._ID,
                PlaceContract.PlaceEntry.COLUMN_PLACENAME,
                PlaceContract.PlaceEntry.COLUMN_ADDRESS,
                PlaceContract.PlaceEntry.COLUMN_START,
                PlaceContract.PlaceEntry.COLUMN_END,
                PlaceContract.PlaceEntry.COLUMN_CHECKLIST,
                PlaceContract.PlaceEntry.COLUMN_IMAGE
        };
        String selection = PlaceContract.PlaceEntry._ID + "=?";
        String[] selectionArgs = new String[] { String.valueOf(itemId) };

        Cursor cursor = db.query(
                PlaceContract.PlaceEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        return cursor;
    }
    public void updateItem(long currentItemId, String name, String address, String start, String end, String check, String image) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PlaceContract.PlaceEntry.COLUMN_PLACENAME, name);
        values.put(PlaceContract.PlaceEntry.COLUMN_START, start);
        values.put(PlaceContract.PlaceEntry.COLUMN_END, end);
        values.put(PlaceContract.PlaceEntry.COLUMN_ADDRESS, address);
        values.put(PlaceContract.PlaceEntry.COLUMN_CHECKLIST, check);
        values.put(PlaceContract.PlaceEntry.COLUMN_IMAGE, image);
        String selection = PlaceContract.PlaceEntry._ID + "=?";
        String[] selectionArgs = new String[] { String.valueOf(currentItemId) };
        db.update(PlaceContract.PlaceEntry.TABLE_NAME,
                values, selection, selectionArgs);
    }

}
