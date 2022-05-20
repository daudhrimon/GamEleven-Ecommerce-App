package com.daud.gameleven;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterList extends RecyclerView.Adapter<AdapterList.TextBtnVH> {
    private Context context;
    private String[] textList = {"Hot","Computer & Office","Phone Accessories","Gaming PC","Toys"};

    public AdapterList(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public TextBtnVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vh_text_btn,parent,false);
        return new TextBtnVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TextBtnVH holder, int position) {
        holder.tv.setText(textList[position]);
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
}
