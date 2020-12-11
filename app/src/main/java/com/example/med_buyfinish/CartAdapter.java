package com.example.med_buyfinish;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.med_buyfinish.Database.OrderContract;

public class CartAdapter extends CursorAdapter {

    public CartAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.cartlist, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView namaAlatt, hargaa, jumlahh;

        namaAlatt = view.findViewById(R.id.namaAlatdiKeranjang);
        hargaa = view.findViewById(R.id.hargadiKeranjang);
        jumlahh = view.findViewById(R.id.jumlahdiKeranjang);

        int namaAlat = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAMA);
        int harga = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_HARGA);
        int jumlah = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_JUMLAH);

        String namaalatnya = cursor.getString(namaAlat);
        String hargaalatnya = cursor.getString(harga);
        String jumlahalatnya = cursor.getString(jumlah);

        namaAlatt.setText(namaalatnya);
        hargaa.setText(hargaalatnya);
        jumlahh.setText(jumlahalatnya);
    }
}
