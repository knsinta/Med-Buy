package com.example.med_buyfinish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.med_buyfinish.Database.OrderContract;

public class KursiRodaActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{

    ImageView ivInfoAlatt;
    ImageButton ibTambahJumlahh, ibKurangJumlahh;
    TextView tvAngkaJumlah, tvNamaAlatt, tvHargaAlatt;
    Button addtoCart;
    int jumlah;
    public Uri mCurrentCartUri;
    boolean hasAllRequiredValues = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ivInfoAlatt = findViewById(R.id.ivInfo);
        ibTambahJumlahh = findViewById(R.id.ibTambahJumlah);
        ibKurangJumlahh  = findViewById(R.id.ibKurangJumlah);
        tvAngkaJumlah = findViewById(R.id.tvJumlah);
        tvNamaAlatt = findViewById(R.id.tvNamaAlatdiInfo);
        tvHargaAlatt = findViewById(R.id.tvHargaAlat);
        addtoCart = findViewById(R.id.bTambahKeKeranjang);

        // setting the name of drink

        tvNamaAlatt.setText("Kursi Roda");
        ivInfoAlatt.setImageResource(R.drawable.kursiroda);

        addtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KursiRodaActivity.this, KeranjangActivity.class);
                startActivity(intent);

                SaveCart();
            }
        });

        ibTambahJumlahh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // coffee price
                int basePrice = 1500000;
                jumlah++;
                displayQuantity();
                int hargaAlat = basePrice * jumlah;
                String setHargaBaru = String.valueOf(hargaAlat);
                tvHargaAlatt.setText(setHargaBaru);
            }
        });

        ibKurangJumlahh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int basePrice = 1500000;
                // because we dont want the quantity go less than 0
                if (jumlah == 0) {
                    Toast.makeText(KursiRodaActivity.this, "Cant decrease quantity < 0", Toast.LENGTH_SHORT).show();
                } else {
                    jumlah--;
                    displayQuantity();
                    int hargaAlat = basePrice * jumlah;
                    String setHargaBaru = String.valueOf(hargaAlat);
                    tvHargaAlatt.setText(setHargaBaru);
                }
            }
        });
    }

    private boolean SaveCart() {
        String name = tvNamaAlatt.getText().toString();
        String price = tvHargaAlatt.getText().toString();
        String quantity = tvAngkaJumlah.getText().toString();

        ContentValues values = new ContentValues();
        values.put(OrderContract.OrderEntry.COLUMN_NAMA, name);
        values.put(OrderContract.OrderEntry.COLUMN_HARGA, price);
        values.put(OrderContract.OrderEntry.COLUMN_JUMLAH, quantity);

        if (mCurrentCartUri == null) {
            Uri newUri = getContentResolver().insert(OrderContract.OrderEntry.CONTENT_URI, values);
            if (newUri==null) {
                Toast.makeText(this, "Failed to add to Cart", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Success  adding to Cart", Toast.LENGTH_SHORT).show();

            }
        }

        hasAllRequiredValues = true;
        return hasAllRequiredValues;
    }

    private void displayQuantity() {
        tvAngkaJumlah.setText(String.valueOf(jumlah));
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {OrderContract.OrderEntry._ID,
                OrderContract.OrderEntry.COLUMN_NAMA,
                OrderContract.OrderEntry.COLUMN_HARGA,
                OrderContract.OrderEntry.COLUMN_JUMLAH
        };

        return new CursorLoader(this, mCurrentCartUri,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished( Loader<Cursor> loader, Cursor cursor) {
        if (cursor == null || cursor.getCount() < 1) {
            return;
        }

        if (cursor.moveToFirst()) {

            int nama = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAMA);
            int harga = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_HARGA);
            int jumlah = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_JUMLAH);

            String namaalatnya = cursor.getString(nama);
            String hargaalatnya = cursor.getString(harga);
            String jumlahalatnya = cursor.getString(jumlah);

            tvNamaAlatt.setText(namaalatnya);
            tvHargaAlatt.setText(hargaalatnya);
            tvAngkaJumlah.setText(jumlahalatnya);
        }
    }

    @Override
    public void onLoaderReset( Loader<Cursor> loader) {
        tvNamaAlatt.setText("");
        tvHargaAlatt.setText("");
        tvAngkaJumlah.setText("");
    }
}