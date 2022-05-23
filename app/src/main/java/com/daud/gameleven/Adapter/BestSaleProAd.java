package com.daud.gameleven.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.daud.gameleven.Activity.MainActivity;
import com.daud.gameleven.Fragment.FragDetails;
import com.daud.gameleven.Model.ProductsModel;
import com.daud.gameleven.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class BestSaleProAd extends RecyclerView.Adapter<BestSaleProAd.BestSaleProVH> {
    private Context context;
    private List<ProductsModel> bspList;

    public BestSaleProAd(Context context, List<ProductsModel> bspList) {
        this.context = context;
        this.bspList = bspList;
    }

    @NonNull
    @Override
    public BestSaleProVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vh_best_sale,parent,false);
        return new BestSaleProVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BestSaleProVH holder, int position) {
        holder.bspIv.setImageResource(bspList.get(position).getImage());
        holder.bspName.setText(bspList.get(position).getName());
        holder.bspCat.setText(bspList.get(position).getCategory());
        holder.bspPrice.setText(bspList.get(position).getNprice() + " SAR");

        holder.bspItem.setOnClickListener(view -> {
            gotoPdFragmentDemo();
        });
    }

    @Override
    public int getItemCount() {
        return bspList.size();
    }

    public class BestSaleProVH extends RecyclerView.ViewHolder{
        private ImageView bspIv;
        private TextView bspName,bspCat,bspPrice;
        private FloatingActionButton bspFab;
        private LinearLayout bspItem;

        public BestSaleProVH(@NonNull View itemView) {
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
        ((FragmentActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new FragDetails()).commit();
        MainActivity. fab.setVisibility(View.GONE);
        MainActivity.btmCard.setVisibility(View.GONE);
    }
}
