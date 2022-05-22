package com.daud.gameleven.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daud.gameleven.Model.ProductsModel;
import com.daud.gameleven.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdapterHome extends RecyclerView.Adapter {
    private Context context;
    private List<ProductsModel> oList;
    private int SATE;

    public AdapterHome(Context context, List<ProductsModel> oList, int SATE) {
        this.context = context;
        this.oList = oList;
        this.SATE = SATE;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (SATE){
            case 1:
                View view1 = LayoutInflater.from(context).inflate(R.layout.vh_flash_deals,parent,false);
                return new FlashDealsVh(view1);

            case 2:
                View view2 = LayoutInflater.from(context).inflate(R.layout.vh_daily_features,parent,false);
                return new DailyFeaturesVh(view2);

            case 3:
                View view3 = LayoutInflater.from(context).inflate(R.layout.vh_hot_categories,parent,false);
                return new HotCategoriesVh(view3);

            case 4:
                    View view4 = LayoutInflater.from(context).inflate(R.layout.vh_brands,parent,false);
                    return new BrandsVh(view4);

            case 5:
                View view5 = LayoutInflater.from(context).inflate(R.layout.vh_best_sale,parent,false);
                return new BestSaleProVH(view5);

            default: return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (SATE){
            case 1:
                ((FlashDealsVh) holder).fdIv.setImageResource(oList.get(position).getImage());
                ((FlashDealsVh) holder).fdTv.setText(oList.get(position).getNprice()+" SAR");
                ((FlashDealsVh) holder).fdCard.setBackgroundColor(getRandomColor());
                break;
            case 2:
                ((DailyFeaturesVh) holder).dfIv.setImageResource(oList.get(position).getImage());
                ((DailyFeaturesVh) holder).dfTv.setText(oList.get(position).getNprice()+" SAR");
                break;
            case 3:
                ((HotCategoriesVh) holder).hcIv.setImageResource(oList.get(position).getImage());
                ((HotCategoriesVh) holder).hcTv.setText(oList.get(position).getModel());
                ((HotCategoriesVh) holder).hcCard.setBackgroundColor(getRandomColor());
                break;
            case 4:
                ((BrandsVh) holder).bIv.setImageResource(oList.get(position).getImage());
                ((BrandsVh) holder).brand.setImageResource(oList.get(position).getBrandimage());
                break;
            case 5:
                holder = ((BestSaleProVH)holder);
                ((BestSaleProVH) holder).bspIv.setImageResource(oList.get(position).getImage());
                ((BestSaleProVH) holder).bspName.setText(oList.get(position).getName());
                ((BestSaleProVH) holder).bspCat.setText(oList.get(position).getCategory());
                ((BestSaleProVH) holder).bspPrice.setText(oList.get(position).getNprice() + " SAR");
                break;
        }
    }

    @Override
    public int getItemCount() {
        return oList.size();
    }

    public class FlashDealsVh extends RecyclerView.ViewHolder{
        private ImageView fdIv;
        private TextView fdTv;
        private LinearLayout fdCard;

        public FlashDealsVh(@NonNull View itemView) {
            super(itemView);
            fdIv = itemView.findViewById(R.id.fdIv);
            fdTv = itemView.findViewById(R.id.fdTv);
            fdCard =itemView.findViewById(R.id.fdCard);
        }
    }

    public class DailyFeaturesVh extends RecyclerView.ViewHolder{
        private ImageView dfIv;
        private TextView dfTv;

        public DailyFeaturesVh(@NonNull View itemView) {
            super(itemView);
            dfIv = itemView.findViewById(R.id.dfIv);
            dfTv = itemView.findViewById(R.id.dfTv);
        }
    }

    public class HotCategoriesVh extends RecyclerView.ViewHolder{
        private ImageView hcIv;
        private TextView hcTv;
        private LinearLayout hcCard;

        public HotCategoriesVh(@NonNull View itemView) {
            super(itemView);
            hcIv = itemView.findViewById(R.id.hcIv);
            hcTv = itemView.findViewById(R.id.hcTv);
            hcCard =itemView.findViewById(R.id.hcCard);
        }
    }

    public class BrandsVh extends RecyclerView.ViewHolder{
        private ImageView bIv,brand;

        public BrandsVh(@NonNull View itemView) {
            super(itemView);
            bIv = itemView.findViewById(R.id.bIv);
            brand = itemView.findViewById(R.id.brand);
        }
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
