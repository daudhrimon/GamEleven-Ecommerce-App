package com.daud.gameleven;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DealsAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<ProductsModel> dList;
    private int SATE;

    public DealsAdapter(Context context, List<ProductsModel> dList, int SATE) {
        this.context = context;
        this.dList = dList;
        this.SATE = SATE;
    }

    @Override
    public int getItemViewType(int position) {
        return SATE;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     if (viewType==1){
         View view = LayoutInflater.from(context).inflate(R.layout.deals_carded_vh,parent,false);
         return new DealsCardedVh(view);
     }else if (viewType==2){
         View view = LayoutInflater.from(context).inflate(R.layout.deals_brands_vh,parent,false);
         return new DealsBrandVh(view);
     } else {
         View view = LayoutInflater.from(context).inflate(R.layout.deals_simple_vh,parent,false);
         return new DealsSimpleVh(view);
     }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (SATE==1){
            holder=((DealsCardedVh)holder);
            ((DealsCardedVh) holder).cIv.setImageResource(dList.get(position).getImage());
            ((DealsCardedVh) holder).cTv.setText(dList.get(position).getNprice());
            ((DealsCardedVh) holder).tvCard.setBackgroundColor(getRandomColor());
        }else if (SATE==2){
            holder=((DealsBrandVh)holder);
            ((DealsBrandVh) holder).bIv.setImageResource(dList.get(position).getImage());
            ((DealsBrandVh) holder).brand.setImageResource(dList.get(position).getBrandimage());
        }else {
            holder = ((DealsSimpleVh)holder);
            ((DealsSimpleVh) holder).sIv.setImageResource(dList.get(position).getImage());
            ((DealsSimpleVh) holder).sTv.setText(dList.get(position).getNprice());
        }
    }

    @Override
    public int getItemCount() {
        return dList.size();
    }

    public class DealsSimpleVh extends RecyclerView.ViewHolder{
        private ImageView sIv;
        private TextView sTv;

        public DealsSimpleVh(@NonNull View itemView) {
            super(itemView);
            sIv = itemView.findViewById(R.id.sIv);
            sTv = itemView.findViewById(R.id.sTv);
        }
    }

    public class DealsCardedVh extends RecyclerView.ViewHolder{
        private ImageView cIv;
        private TextView cTv;
        private LinearLayout tvCard;

        public DealsCardedVh(@NonNull View itemView) {
            super(itemView);
            cIv = itemView.findViewById(R.id.cIv);
            cTv = itemView.findViewById(R.id.cTv);
            tvCard =itemView.findViewById(R.id.tvCard);
        }
    }

    public class DealsBrandVh extends RecyclerView.ViewHolder{
        private ImageView bIv,brand;
        public DealsBrandVh(@NonNull View itemView) {
            super(itemView);
            bIv = itemView.findViewById(R.id.bIv);
            brand = itemView.findViewById(R.id.brand);
        }
    }

    private int getRandomColor() {
        List<Integer> colorcode=new ArrayList<>();
        colorcode.add(Color.parseColor("#D81D4C"));
        colorcode.add(Color.parseColor("#68C037"));
        colorcode.add(Color.parseColor("#094D82"));
        colorcode.add(Color.parseColor("#2B2B2B"));

        Random random=new Random();
        int number=random.nextInt(colorcode.size());
        return colorcode.get(number);
    }

}
