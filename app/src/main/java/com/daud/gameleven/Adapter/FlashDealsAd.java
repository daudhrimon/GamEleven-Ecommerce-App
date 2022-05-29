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

import java.util.List;

public class FlashDealsAd extends RecyclerView.Adapter<FlashDealsAd.FlashDealsVH> {
    private Context context;
    private List<ProductModel> fdList;

    public FlashDealsAd(Context context, List<ProductModel> fdList) {
        this.context = context;
        this.fdList = fdList;
    }

    @NonNull
    @Override
    public FlashDealsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vh_flash_deals,parent,false);
        return new FlashDealsVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlashDealsVH holder, int position) {
        holder.fdIv.setImageResource(fdList.get(position).getImage());
        holder.fdTv.setText(fdList.get(position).getNprice()+" SAR");
        holder.fdCard.setBackgroundColor(MainActivity.getRandomColor());

        holder.fdIv.setOnClickListener(view -> {
            gotoPdFragmentDemo();
        });

    }

    @Override
    public int getItemCount() {
        return fdList.size();
    }

    public class FlashDealsVH extends RecyclerView.ViewHolder {
        private ImageView fdIv;
        private TextView fdTv;
        private LinearLayout fdCard;

        public FlashDealsVH(@NonNull View itemView) {
            super(itemView);
            fdIv = itemView.findViewById(R.id.fdIv);
            fdTv = itemView.findViewById(R.id.fdTv);
            fdCard =itemView.findViewById(R.id.fdCard);
        }
    }

    // go to details frag Demo
    private void gotoPdFragmentDemo(){
        ((FragmentActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new FragProDetails())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack(null).commit();
    }
}
