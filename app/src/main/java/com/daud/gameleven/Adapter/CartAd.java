package com.daud.gameleven.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daud.gameleven.Model.ProductsModel;
import com.daud.gameleven.R;

import java.util.List;

public class CartAd extends RecyclerView.Adapter<CartAd.CartVH> {
    private Context context;
    private List<ProductsModel> cList;

    public CartAd(Context context, List<ProductsModel> cList) {
        this.context = context;
        this.cList = cList;
    }

    @NonNull
    @Override
    public CartVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vh_cart_item,parent,false);
        return new CartVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartVH holder, int position) {
        holder.cartIv.setImageResource(cList.get(position).getImage());
        holder.cartName.setText(cList.get(position).getName());
        holder.cartCat.setText(cList.get(position).getCategory());
        holder.cartId.setText(cList.get(position).getProductid());
        holder.cartPrice.setText(cList.get(position).getNprice()+" SAR");

    }

    @Override
    public int getItemCount() {
        return cList.size();
    }

    public class CartVH extends RecyclerView.ViewHolder {
        private ImageView cartIv;
        private TextView cartName,cartCat,cartId,cartPrice,cartCount;
        private ImageButton cartPlus,cartMinus;

        public CartVH(@NonNull View itemView) {
            super(itemView);
            cartIv = itemView.findViewById(R.id.cartIv);
            cartName = itemView.findViewById(R.id.cartName);
            cartCat = itemView.findViewById(R.id.cartCat);
            cartId = itemView.findViewById(R.id.cartId);
            cartPrice = itemView.findViewById(R.id.cartPrice);
            cartCount = itemView.findViewById(R.id.cartCount);
            cartPlus = itemView.findViewById(R.id.cartPlus);
            cartMinus = itemView.findViewById(R.id.cartMinus);
        }
    }
}
