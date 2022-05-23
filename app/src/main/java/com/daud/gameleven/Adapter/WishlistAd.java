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

public class WishlistAd extends RecyclerView.Adapter<WishlistAd.WishlistVh>{
    private Context context;
    private List<ProductsModel> wList;

    public WishlistAd(Context context, List<ProductsModel> wList){
        this.context = context;
        this.wList = wList;
    }

    @NonNull
    @Override
    public WishlistVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vh_wishlist_item, parent, false);
        return new WishlistVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WishlistVh holder, int position) {
        holder.wishIv.setImageResource(wList.get(position).getImage());
        holder.wishName.setText(wList.get(position).getName());
        holder.wishCat.setText(wList.get(position).getCategory());
        holder.wishPrice.setText(wList.get(position).getNprice() + " SAR");
    }

    @Override
    public int getItemCount() {
        return wList.size();
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
