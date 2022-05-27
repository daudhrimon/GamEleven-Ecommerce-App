package com.daud.gameleven.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daud.gameleven.Model.OrderModel;
import com.daud.gameleven.R;

import java.util.List;

public class OrderAd extends RecyclerView.Adapter<OrderAd.OrderVH> {
    List<OrderModel> orderModels;
    Context context;

    public OrderAd(List<OrderModel> orderModels, Context context) {
        this.orderModels = orderModels;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_order, parent, false);
        return new OrderVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderVH holder, int position) {
        holder.orderId.setText(orderModels.get(position).getOrderId());
        holder.modelId.setText(orderModels.get(position).getModelId());
        holder.deliv.setText(orderModels.get(position).getStatus());
        holder.date.setText(orderModels.get(position).getDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "OK", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return orderModels.size();
    }

    public class OrderVH extends RecyclerView.ViewHolder {
        TextView orderId,modelId,deliv,date;

        public OrderVH(@NonNull View itemView) {
            super(itemView);
            orderId = itemView.findViewById(R.id.orderId);
            modelId = itemView.findViewById(R.id.modelId);
            deliv = itemView.findViewById(R.id.deliv);
            date = itemView.findViewById(R.id.date);
        }
    }
}

