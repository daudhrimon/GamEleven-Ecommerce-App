package com.daud.gameleven.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daud.gameleven.Model.ProductsModel;
import com.daud.gameleven.R;

import java.util.List;

public class AdapterOthers extends RecyclerView.Adapter {
    private Context context;
    private List<ProductsModel> tList;
    private  int STATE;

    public AdapterOthers(Context context, List<ProductsModel> tList, int STATE) {
        this.context = context;
        this.tList = tList;
        this.STATE = STATE;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (STATE){

            case 1: // Wishlist //
                View view1 = LayoutInflater.from(context).inflate(R.layout.vh_wishlist_item,parent,false);
                return new WishlistVh(view1);

                default: return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (STATE) {

            case 1: // Wishlist //
                holder = ((WishlistVh) holder);
                ((WishlistVh) holder).wishIv.setImageResource(tList.get(position).getImage());
                ((WishlistVh) holder).wishName.setText(tList.get(position).getName());
                ((WishlistVh) holder).wishCat.setText(tList.get(position).getCategory());
                ((WishlistVh) holder).wishPrice.setText(tList.get(position).getNprice() + " SAR");
                break;
        }

    }

    @Override
    public int getItemCount() {
        return tList.size();
    }

    public class WishlistVh extends RecyclerView.ViewHolder{
        private ImageView wishIv;
        private TextView wishName,wishCat,wishPrice;

        public WishlistVh(@NonNull View itemView) {
            super(itemView);
            wishIv = itemView.findViewById(R.id.wishIv);
            wishName = itemView.findViewById(R.id.wishName);
            wishCat = itemView.findViewById(R.id.wishCat);
            wishPrice = itemView.findViewById(R.id.wishPrice);
        }
    }
}
