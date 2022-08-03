package com.example.projekuasputra.adapter;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.projekuasputra.R;
import com.example.projekuasputra.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    private Context context;
    private List<User> list;
    private Dialog dialog;

    public interface Dialog{
        void onClick(int pos);
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public UserAdapter(Context context, List<User> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.produk.setText(list.get(position).getProduk());
        holder.merk.setText(list.get(position).getMerk());
        holder.tahun.setText(list.get(position).getTahun());
        holder.harga.setText(list.get(position).getHarga());
        Glide.with(context).load(list.get(position).getGambar()).into(holder.gambar);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView produk, merk, tahun, harga;
        ImageView gambar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            produk = itemView.findViewById(R.id.produk);
            merk = itemView.findViewById(R.id.merk);
            tahun = itemView.findViewById(R.id.tahun);
            harga = itemView.findViewById(R.id.harga);
            gambar = itemView.findViewById(R.id.gambar);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (dialog!=null){
                        dialog.onClick(getLayoutPosition());
                    }
                }
            });
        }
    }
}