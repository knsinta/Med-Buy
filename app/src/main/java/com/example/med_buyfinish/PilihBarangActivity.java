package com.example.med_buyfinish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class PilihBarangActivity extends AppCompatActivity {

    List<Model> modelList;
    RecyclerView recyclerView;
    OrderAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_barang);

        modelList = new ArrayList<>();
        modelList.add(new Model("Stetoskop", getString(R.string.Stetoskop), R.drawable.stetoskop ));
        modelList.add(new Model("Kursi Roda", getString(R.string.KursiRoda), R.drawable.kursiroda));
        modelList.add(new Model("Kotak P3K + isinya", getString(R.string.P3K), R.drawable.p3k));

        // recyclerview
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));
        // adapter
        mAdapter = new OrderAdapter(this, modelList);
        recyclerView.setAdapter(mAdapter);
    }
}