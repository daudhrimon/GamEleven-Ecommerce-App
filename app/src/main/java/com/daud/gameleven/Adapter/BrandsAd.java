package com.daud.gameleven.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.daud.gameleven.MainActivity;
import com.daud.gameleven.Fragment.FragProDetails;
import com.daud.gameleven.Model.ProductModel;
import com.daud.gameleven.R;

import java.util.List;

public class BrandsAd extends RecyclerView.Adapter<BrandsAd.BrandsVH> {
    private Context context;
    private List<ProductModel> bList;

    public BrandsAd(Context context, List<ProductModel> bList) {
        this.context = context;
        this.bList = bList;
    }

    @NonNull
    @Override
    public BrandsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vh_brands,parent,false);
        return new BrandsVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrandsVH holder, int position) {
        holder.bIv.setImageResource(bList.get(position).getImage());
        holder.brand.setImageResource(bList.get(position).getBrandimage());

        holder.bIv.setOnClickListener(view -> {
            gotoPdFragmentDemo();
        });
    }

    @Override
    public int getItemCount() {
        return bList.size();
    }

    public class BrandsVH extends RecyclerView.ViewHolder {
        private ImageView bIv,brand;

        public BrandsVH(@NonNull View itemView) {
            super(itemView);
            bIv = itemView.findViewById(R.id.bIv);
            brand = itemView.findViewById(R.id.brand);
        }
    }

    // go to details frag Demo
    private void gotoPdFragmentDemo(){
        ((FragmentActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new FragProDetails())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack(null).commit();
    }
}
