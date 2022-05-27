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

import com.daud.gameleven.Model.ProductModel;
import com.daud.gameleven.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class CartAd extends RecyclerView.Adapter<CartAd.CartVH> {
    private Context context;
    private List<ProductModel> cList;

    public CartAd(Context context, List<ProductModel> cList) {
        this.context = context;
        this.cList = cList;
    }

    @NonNull
    @Override
    public CartVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vh_cart,parent,false);
        return new CartVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartVH holder, int position) {
        holder.cartIv.setImageResource(cList.get(position).getImage());
        holder.cartName.setText(cList.get(position).getName());
        holder.cartCat.setText(cList.get(position).getCategory());
        holder.cartId.setText(cList.get(position).getProductid());
        holder.cartPrice.setText(cList.get(position).getNprice()+" SAR");

        holder.fabSelect.setOnClickListener(view -> {
            fabSelectClickHandle(holder);
        });

        holder.fabUnselect.setOnClickListener(view -> {
            fabUnselectClickHandle(holder);
        });
    }

    private void fabSelectClickHandle(CartVH holder) {
        holder.fabSelect.setVisibility(View.GONE);
        holder.fabUnselect.setVisibility(View.VISIBLE);
    }

    private void fabUnselectClickHandle(CartVH holder) {
        holder.fabUnselect.setVisibility(View.GONE);
        holder.fabSelect.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return cList.size();
    }

    public class CartVH extends RecyclerView.ViewHolder {
        private ImageView cartIv;
        private TextView cartName,cartCat,cartId,cartPrice,cartCount;
        private ImageButton cartPlus,cartMinus;
        private FloatingActionButton fabSelect, fabUnselect;

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
            fabSelect = itemView.findViewById(R.id.fabSelect);
            fabUnselect = itemView.findViewById(R.id.fabUnselect);
        }
    }
}
