package com.daud.gameleven;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class AdapterTwo extends RecyclerView.Adapter {
    private Context context;
    private List<ProductsModel> tList;
    private  int STATE;

    public AdapterTwo(Context context, List<ProductsModel> tList, int STATE) {
        this.context = context;
        this.tList = tList;
        this.STATE = STATE;
    }

    @Override
    public int getItemViewType(int position) {
        return STATE;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType){
            case 1:
                View view1 = LayoutInflater.from(context).inflate(R.layout.vh_best_sale,parent,false);
                return new BestSaleProVH(view1);

            case 2:
                View view2 = LayoutInflater.from(context).inflate(R.layout.vh_wishlist_item,parent,false);
                return new WishlistVh(view2);

            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (STATE){
            case 1:
            ((BestSaleProVH) holder).bspIv.setImageResource(tList.get(position).getImage());
            ((BestSaleProVH) holder).bspName.setText(tList.get(position).getName());
            ((BestSaleProVH) holder).bspCat.setText(tList.get(position).getCategory());
            ((BestSaleProVH) holder).bspPrice.setText(tList.get(position).getNprice()+" SAR");
            break;

            case 2:
                holder=((WishlistVh)holder);
                ((WishlistVh) holder).wishIv.setImageResource(tList.get(position).getImage());
                ((WishlistVh) holder).wishName.setText(tList.get(position).getName());
                ((WishlistVh) holder).wishCat.setText(tList.get(position).getCategory());
                ((WishlistVh) holder).wishPrice.setText(tList.get(position).getNprice()+" SAR");
                break;
        }

    }

    @Override
    public int getItemCount() {
        return tList.size();
    }

    public class BestSaleProVH extends RecyclerView.ViewHolder{
        private ImageView bspIv;
        private TextView bspName,bspCat,bspPrice;
        private FloatingActionButton bspFab;

        public BestSaleProVH(@NonNull View itemView) {
            super(itemView);
            bspIv = itemView.findViewById(R.id.bspIv);
            bspName = itemView.findViewById(R.id.bspName);
            bspCat = itemView.findViewById(R.id.bspCat);
            bspPrice = itemView.findViewById(R.id.bspPrice);
            bspFab = itemView.findViewById(R.id.bspFab);
        }
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
