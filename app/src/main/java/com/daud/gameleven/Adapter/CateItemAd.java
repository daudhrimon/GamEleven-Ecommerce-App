package com.daud.gameleven.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.daud.gameleven.Fragment.FragProduct;
import com.daud.gameleven.MainActivity;
import com.daud.gameleven.R;

public class CateItemAd extends RecyclerView.Adapter<CateItemAd.CategoryListVH> {
    private Context context;
    private String [] clList;

    public CateItemAd(Context context, String[] clList) {
        this.context = context;
        this.clList = clList;
    }

    @NonNull
    @Override
    public CategoryListVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vh_category_list,parent,false);
        return new CategoryListVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryListVH holder, int position) {

        holder.itemTv.setText(clList[position]);


        holder.expandBtn.setOnClickListener(view -> {
            catItemsExpandBtnClick(holder);
        });

        holder.itemBtn.setOnClickListener(view -> {
            itemClickHandler(holder);
        });
    }

    private void itemClickHandler(CategoryListVH holder) {
        ((FragmentActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, new FragProduct())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).addToBackStack(null).commit();
        MainActivity.btmCard.setVisibility(View.GONE);
        MainActivity.fab.setVisibility(View.GONE);
    }

    private void catItemsExpandBtnClick(CategoryListVH holder) {
        if (holder.superLay.getVisibility()==View.GONE){
            holder.superLay.setVisibility(View.VISIBLE);
            holder.expandBtn.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
        }else{
            holder.superLay.setVisibility(View.GONE);
            holder.expandBtn.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
        }
    }

    @Override
    public int getItemCount() {
        return clList.length;
    }

    public class CategoryListVH extends RecyclerView.ViewHolder {
        private TextView itemTv;
        private ImageButton expandBtn;
        private LinearLayout itemBtn,superLay;

        public CategoryListVH(@NonNull View itemView) {
            super(itemView);
            itemTv = itemView.findViewById(R.id.itemTv);
            itemBtn = itemView.findViewById(R.id.itemBtn);
            expandBtn = itemView.findViewById(R.id.expandBtn);
            superLay = itemView.findViewById(R.id.superLay);
        }
    }


}
