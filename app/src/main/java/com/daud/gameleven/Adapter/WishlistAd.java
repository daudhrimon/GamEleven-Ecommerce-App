package com.daud.gameleven.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.daud.gameleven.Fragment.FragProDetails;
import com.daud.gameleven.Model.ProductModel;
import com.daud.gameleven.R;

import java.util.List;

public class WishlistAd extends RecyclerView.Adapter<WishlistAd.WishlistVh>{
    private Context context;
    private List<ProductModel> wList;

    public WishlistAd(Context context, List<ProductModel> wList){
        this.context = context;
        this.wList = wList;
    }

    @NonNull
    @Override
    public WishlistVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vh_wishlist, parent, false);
        return new WishlistVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WishlistVh holder, int position) {
        holder.wishIv.setImageResource(wList.get(position).getImage());
        holder.wishName.setText(wList.get(position).getName());
        holder.wishCat.setText(wList.get(position).getCategory());
        holder.wishPrice.setText(wList.get(position).getNprice() + " SAR");

        holder.wishDlt.setOnClickListener(view -> {
            wishDeleteClickHandler(holder);
        });

        holder.wishItem.setOnClickListener(view1 -> {
            wishItemClickHandler();
        });
    }

    private void wishItemClickHandler() {
        ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.mainFrame, new FragProDetails()).addToBackStack(null).commit();
    }

    private void wishDeleteClickHandler(WishlistVh holder) {
        holder.wishDlt.setBackgroundResource(R.drawable.wd_select);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(R.layout.aleartdialog_delete,null);
        TextView alertTv = view.findViewById(R.id.alertTv);
        Button cancelBtn = view.findViewById(R.id.cancelBtn);
        Button okBtn = view.findViewById(R.id.okBtn);
        alertTv.setText(R.string.alertDlt_wishlist);
        builder.setView(view);
        final Dialog dialog = builder.create();
        dialog.show();

        cancelBtn.setOnClickListener(view1 -> {
            holder.wishDlt.setBackgroundResource(R.drawable.wd_unselect);
            dialog.dismiss();
        });

        okBtn.setOnClickListener(view1 -> {
            holder.wishDlt.setBackgroundResource(R.drawable.wd_unselect);
            dialog.dismiss();
        });
    }

    @Override
    public int getItemCount() {
        return wList.size();
    }

    public class WishlistVh extends RecyclerView.ViewHolder{
        private ImageView wishIv;
        private TextView wishName,wishCat,wishPrice;
        private LinearLayout wishItem,wishDlt;

        public WishlistVh(@NonNull View itemView) {
            super(itemView);
            wishIv = itemView.findViewById(R.id.wishIv);
            wishName = itemView.findViewById(R.id.wishName);
            wishCat = itemView.findViewById(R.id.wishCat);
            wishPrice = itemView.findViewById(R.id.wishPrice);
            wishItem = itemView.findViewById(R.id.wishItem);
            wishDlt = itemView.findViewById(R.id.wishDlt);
        }
    }
}
