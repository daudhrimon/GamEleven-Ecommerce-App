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
        switch (viewType){
            case 1:
                View view1 = LayoutInflater.from(context).inflate(R.layout.flash_deals_vh,parent,false);
                return new FlashDealsVh(view1);

            case 2:
                View view2 = LayoutInflater.from(context).inflate(R.layout.daily_features_vh,parent,false);
                return new DailyFeaturesVh(view2);

            case 3:
                View view3 = LayoutInflater.from(context).inflate(R.layout.hot_categories_vh,parent,false);
                return new HotCategoriesVh(view3);

                default:
                    View view = LayoutInflater.from(context).inflate(R.layout.brands_vh,parent,false);
                    return new BrandsVh(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (SATE){
            case 1:
                ((FlashDealsVh) holder).fdIv.setImageResource(dList.get(position).getImage());
                ((FlashDealsVh) holder).fdTv.setText(dList.get(position).getNprice());
                ((FlashDealsVh) holder).fdCard.setBackgroundColor(getRandomColor());
                break;
            case 2:
                ((DailyFeaturesVh) holder).dfIv.setImageResource(dList.get(position).getImage());
                ((DailyFeaturesVh) holder).dfTv.setText(dList.get(position).getNprice());
                break;
            case 3:
                ((HotCategoriesVh) holder).hcIv.setImageResource(dList.get(position).getImage());
                ((HotCategoriesVh) holder).hcTv.setText(dList.get(position).getModel());
                ((HotCategoriesVh) holder).hcCard.setBackgroundColor(getRandomColor());
                break;
            default:
                ((BrandsVh) holder).bIv.setImageResource(dList.get(position).getImage());
                ((BrandsVh) holder).brand.setImageResource(dList.get(position).getBrandimage());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return dList.size();
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
