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
import androidx.recyclerview.widget.RecyclerView;

import com.daud.gameleven.Activity.MainActivity;
import com.daud.gameleven.Fragment.FragDetails;
import com.daud.gameleven.Model.ProductsModel;
import com.daud.gameleven.R;

import java.util.List;

public class HotCateAd extends RecyclerView.Adapter<HotCateAd.HotCategoriesVh> {
    private Context context;
    private List<ProductsModel> hcList;

    public HotCateAd(Context context, List<ProductsModel> hcList) {
        this.context = context;
        this.hcList = hcList;
    }

    @NonNull
    @Override
    public HotCategoriesVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vh_hot_categories,parent,false);
        return new HotCategoriesVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotCategoriesVh holder, int position) {

        holder.hcIv.setImageResource(hcList.get(position).getImage());
        holder.hcTv.setText(hcList.get(position).getModel());
        holder.hcCard.setBackgroundColor(MainActivity.getRandomColor());

        holder.hcIv.setOnClickListener(view -> {
            gotoPdFragmentDemo();
        });

    }

    @Override
    public int getItemCount() {
        return hcList.size();
    }

    public class HotCategoriesVh extends RecyclerView.ViewHolder {
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

    // go to details frag Demo
    private void gotoPdFragmentDemo(){
        ((FragmentActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new FragDetails()).commit();
        MainActivity. fab.setVisibility(View.GONE);
        MainActivity.btmCard.setVisibility(View.GONE);
    }
}
