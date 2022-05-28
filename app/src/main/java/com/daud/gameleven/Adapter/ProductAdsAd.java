package com.daud.gameleven.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.daud.gameleven.MainActivity;
import com.daud.gameleven.Fragment.FragProDetails;
import com.daud.gameleven.Model.ProductModel;
import com.daud.gameleven.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ProductAdsAd extends RecyclerView.Adapter<ProductAdsAd.ProductAdsVH> {
    private Context context;
    private List<ProductModel> pList;

    public ProductAdsAd(Context context, List<ProductModel> pList) {
        this.context = context;
        this.pList = pList;
    }

    @NonNull
    @Override
    public ProductAdsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vh_productads,parent,false);
        return new ProductAdsVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdsVH holder, int position) {
        holder.bspIv.setImageResource(pList.get(position).getImage());
        holder.bspName.setText(pList.get(position).getName());
        holder.bspCat.setText(pList.get(position).getCategory());
        holder.bspPrice.setText(pList.get(position).getNprice() + " SAR");

        holder.bspItem.setOnClickListener(view -> {
            gotoPdFragmentDemo();
        });
    }

    @Override
    public int getItemCount() {
        return pList.size();
    }

    public class ProductAdsVH extends RecyclerView.ViewHolder{
        private ImageView bspIv;
        private TextView bspName,bspCat,bspPrice;
        private FloatingActionButton bspFab;
        private LinearLayout bspItem;

        public ProductAdsVH(@NonNull View itemView) {
            super(itemView);
            bspIv = itemView.findViewById(R.id.bspIv);
            bspName = itemView.findViewById(R.id.bspName);
            bspCat = itemView.findViewById(R.id.bspCat);
            bspPrice = itemView.findViewById(R.id.bspPrice);
            bspFab = itemView.findViewById(R.id.bspFab);
            bspItem = itemView.findViewById(R.id.bspItem);
        }
    }

    // go to details frag Demo
    private void gotoPdFragmentDemo(){
        ((FragmentActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new FragProDetails())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack(null).commit();
        MainActivity. fab.setVisibility(View.GONE);
        MainActivity.btmCard.setVisibility(View.GONE);
    }
}
