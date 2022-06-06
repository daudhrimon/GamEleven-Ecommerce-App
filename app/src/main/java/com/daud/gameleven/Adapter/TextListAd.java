package com.daud.gameleven.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.daud.gameleven.Fragment.FragProduct;
import com.daud.gameleven.R;

public class TextListAd extends RecyclerView.Adapter<TextListAd.TextListVH> {
    private Context context;
    private String[] textList;

    public TextListAd(Context context, String[] textList) {
        this.context = context;
        this.textList = textList;
    }

    @NonNull
    @Override
    public TextListVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vh_text_btn, parent, false);
        return new TextListVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TextListVH holder, int position) {

        holder.tv.setText(textList[position]);

        holder.textBtn.setOnClickListener(view -> {
            textBtnClickHandler();
        });
    }

    private void textBtnClickHandler() {
        ((FragmentActivity) context).getSupportFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.mainFrame, new FragProduct()).addToBackStack(null).commit();
    }

    @Override
    public int getItemCount() {
        return textList.length;
    }

    public class TextListVH extends RecyclerView.ViewHolder {
        private TextView tv;
        private LinearLayout textBtn;

        public TextListVH(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            textBtn = itemView.findViewById(R.id.textBtn);
        }
    }
}
