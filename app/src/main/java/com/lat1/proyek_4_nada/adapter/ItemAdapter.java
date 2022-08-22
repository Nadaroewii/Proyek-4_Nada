package com.lat1.proyek_4_nada.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.lat1.proyek_4_nada.AddAndUpdate;
import com.lat1.proyek_4_nada.R;
import com.lat1.proyek_4_nada.models.Item;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    final ArrayList<Item> listItems = new ArrayList<Item>();

    private Context context;

    public ItemAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ItemAdapter.ItemViewHolder onCreateViewHolder
            (@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_item,parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, @SuppressLint("RecyclerView") int i) {
        holder.tvName.setText(listItems.get(i).getName());
        holder.tvBrand.setText(listItems.get(i).getBrand());
        holder.tvPrice.setText("" + listItems.get(i).getPrice());

        holder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AddAndUpdate.class);

                intent.putExtra("position", i);
                intent.putExtra("item", listItems.get(i));
                context.startActivity(intent);


            }
        });
    }

    public void setListItems(ArrayList<Item> items) {

        if (items.size() > 0) {
            this.listItems.clear();
        }

        this.listItems.addAll(items);

        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvBrand, tvPrice;

        CardView cvItem;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvBrand = itemView.findViewById(R.id.tv_brand);
            tvPrice = itemView.findViewById(R.id.tv_price);

            cvItem = itemView.findViewById(R.id.cv_item);
        }
    }
}