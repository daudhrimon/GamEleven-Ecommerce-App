package com.daud.gameleven;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterTextItems extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private String [] textList;
    private int STATE;

    public AdapterTextItems(Context context, String[] textList, int STATE) {
        this.context = context;
        this.textList = textList;
        this.STATE = STATE;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (STATE){
            case 1:
                View view1 = LayoutInflater.from(context).inflate(R.layout.vh_text_btn,parent,false);
                return new TextBtnVH(view1);

            case 2:
                View view2 = LayoutInflater.from(context).inflate(R.layout.vh_category_list_item,parent,false);
                return new CatItemsVH(view2);

            default: return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (STATE){
            case 1:
                holder = ((TextBtnVH)holder);
                ((TextBtnVH) holder).tv.setText(textList[position]);
                break;

            case 2:
                holder = ((CatItemsVH)holder);
                ((CatItemsVH) holder).itemTv.setText(textList[position]);

                RecyclerView.ViewHolder finalHolder = holder;
                ((CatItemsVH) holder).expandBtn.setOnClickListener(view -> {
                    catItemsExpandBtnClick(finalHolder);
                });

                holder.itemView.setOnClickListener(view -> {
                    //catItemsExpandBtnClick(finalHolder);
                });
                break;
        }
    }

    private void catItemsExpandBtnClick(RecyclerView.ViewHolder finalHolder) {
        if (((CatItemsVH)finalHolder).superLay.getVisibility()==View.GONE){
            ((CatItemsVH)finalHolder).superLay.setVisibility(View.VISIBLE);
            ((CatItemsVH)finalHolder).expandBtn.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
        }else{
            ((CatItemsVH)finalHolder).superLay.setVisibility(View.GONE);
            ((CatItemsVH)finalHolder).expandBtn.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
        }
    }

    @Override
    public int getItemCount() {
        return textList.length;
    }

    public class TextBtnVH extends RecyclerView.ViewHolder {
        private TextView tv;
        public TextBtnVH(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }

    public class CatItemsVH extends RecyclerView.ViewHolder{
        private TextView itemTv;
        private ImageButton expandBtn;
        private LinearLayout superLay;

        public CatItemsVH(@NonNull View itemView) {
            super(itemView);
            itemTv = itemView.findViewById(R.id.itemTv);
            expandBtn = itemView.findViewById(R.id.expandBtn);
            superLay = itemView.findViewById(R.id.superLay);
        }
    }
}
