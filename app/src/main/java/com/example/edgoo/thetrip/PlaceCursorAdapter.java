package com.example.edgoo.thetrip;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.edgoo.thetrip.data.PlaceContract;

public class PlaceCursorAdapter extends CursorAdapter {


    private final MainActivity activity;

    public PlaceCursorAdapter(MainActivity context, Cursor c) {
        super(context, c, 0);
        this.activity = context;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
    }

    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {
        TextView nameTextView = (TextView) view.findViewById(R.id.place_name);
        TextView quantityTextView = (TextView) view.findViewById(R.id.start_time);
        TextView priceTextView = (TextView) view.findViewById(R.id.end_time);
        ImageView image = (ImageView) view.findViewById(R.id.image_view);

        String name = cursor.getString(cursor.getColumnIndex(PlaceContract.PlaceEntry.COLUMN_PLACENAME));
        final int startT = cursor.getInt(cursor.getColumnIndex(PlaceContract.PlaceEntry.COLUMN_START));
        final int endT = cursor.getInt(cursor.getColumnIndex(PlaceContract.PlaceEntry.COLUMN_END));

        image.setImageURI(Uri.parse(cursor.getString(cursor.getColumnIndex(PlaceContract.PlaceEntry.COLUMN_IMAGE))));

        nameTextView.setText(name);
        quantityTextView.setText(String.valueOf(startT));
        priceTextView.setText(String.valueOf(endT));

        final long id = cursor.getLong(cursor.getColumnIndex(PlaceContract.PlaceEntry._ID));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.clickOnViewItem(id);
            }
        });

    }
}
