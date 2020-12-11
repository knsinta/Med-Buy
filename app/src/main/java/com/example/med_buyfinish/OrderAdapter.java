package com.example.med_buyfinish;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    List<Model> modelList;
    Context context;

    public OrderAdapter(Context context, List<Model> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        String namaAlat = modelList.get(position).getmNamaAlat();
        String deskAlat = modelList.get(position).getmDeskAlat();
        int images = modelList.get(position).getmFotoAlat();

        holder.mNamaAlat.setText(namaAlat);
        holder.mDeskAlat.setText(deskAlat);
        holder.fotoAlat.setImageResource(images);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView mNamaAlat, mDeskAlat;
        ImageView fotoAlat;

        public ViewHolder(View itemView) {
            super(itemView);

            mNamaAlat = itemView.findViewById(R.id.tvNamaAlat);
            mDeskAlat = itemView.findViewById(R.id.tvDeskAlat);
            fotoAlat = itemView.findViewById(R.id.FotoAlat);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int posisi = getAdapterPosition();

            if(posisi==0){
                Intent intent = new Intent(context, InfoActivity.class);
                context.startActivity(intent);
            }
            if (posisi==1){
                Intent intent2 = new Intent(context, KursiRodaActivity.class);
                context.startActivity(intent2);
            }
        }
    }
}
