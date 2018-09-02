
package com.example.edgoo.thetrip.data;

import android.provider.BaseColumns;

public class PlaceContract {

    public PlaceContract() {
    }

    public static final class PlaceEntry implements BaseColumns {

        public static final String TABLE_NAME = "places";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_PLACENAME = "placeName";
        public static final String COLUMN_ADDRESS = "address";
        public static final String COLUMN_START = "start";
        public static final String COLUMN_END = "end";
        public static final String COLUMN_CHECKLIST = "checkList";
        public static final String COLUMN_IMAGE = "image";

        public static final String CREATE_TABLE_STOCK = "CREATE TABLE " +
                PlaceContract.PlaceEntry.TABLE_NAME + "(" +
                PlaceContract.PlaceEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                PlaceContract.PlaceEntry.COLUMN_PLACENAME + " TEXT NOT NULL," +
                PlaceContract.PlaceEntry.COLUMN_ADDRESS + " TEXT NOT NULL," +
                PlaceContract.PlaceEntry.COLUMN_START + " TEXT NOT NULL," +
                PlaceContract.PlaceEntry.COLUMN_END + " TEXT NOT NULL," +
                PlaceContract.PlaceEntry.COLUMN_CHECKLIST + " TEXT NOT NULL," +
                PlaceEntry.COLUMN_IMAGE + " TEXT NOT NULL" + ");";
    }
}
