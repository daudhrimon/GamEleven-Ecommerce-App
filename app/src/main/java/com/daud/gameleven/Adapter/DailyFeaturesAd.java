package com.daud.gameleven.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.daud.gameleven.MainActivity;
import com.daud.gameleven.Fragment.FragProDetails;
import com.daud.gameleven.Model.ProductModel;
import com.daud.gameleven.R;

import java.util.List;

public class DailyFeaturesAd extends RecyclerView.Adapter<DailyFeaturesAd.DailyFeaturesVH> {
    private Context context;
    private List<ProductModel> dfList;

    public DailyFeaturesAd(Context context, List<ProductModel> dfList) {
        this.context = context;
        this.dfList = dfList;
    }

    @NonNull
    @Override
    public DailyFeaturesVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vh_daily_features,parent,false);
        return new DailyFeaturesVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyFeaturesVH holder, int position) {

        holder.dfIv.setImageResource(dfList.get(position).getImage());
        holder.dfTv.setText(dfList.get(position).getNprice()+" SAR");

        holder.dfIv.setOnClickListener(view -> {
            gotoPdFragmentDemo();
        });
    }

    @Override
    public int getItemCount() {
        return dfList.size();
    }

    public class DailyFeaturesVH extends RecyclerView.ViewHolder {
        private ImageView dfIv;
        private TextView dfTv;

        public DailyFeaturesVH(@NonNull View itemView) {
            super(itemView);
            dfIv = itemView.findViewById(R.id.dfIv);
            dfTv = itemView.findViewById(R.id.dfTv);
        }
    }

    // go to details frag Demo
    private void gotoPdFragmentDemo(){
        ((FragmentActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new FragProDetails())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack(null).commit();
    }
}
