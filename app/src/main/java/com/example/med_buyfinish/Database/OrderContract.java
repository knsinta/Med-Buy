package com.example.med_buyfinish.Database;

import android.net.Uri;
import android.provider.BaseColumns;

public class OrderContract {

    public OrderContract() {

    }

    public static final String CONTENT_AUTHORITY = "com.example.med_buyfinish";
    public static final Uri BASE_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    // this should be similar to your table name
    public static final String PATH = "orderig";


    public static abstract class OrderEntry implements BaseColumns {

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_URI, PATH);

        public static final String TABLE_NAME = "orderig";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAMA = "nama";
        public static final String COLUMN_JUMLAH = "jumlah";
        public static final String COLUMN_HARGA = "harga";

    }
}
