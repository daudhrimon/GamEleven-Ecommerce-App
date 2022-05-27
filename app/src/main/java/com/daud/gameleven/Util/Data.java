package com.daud.gameleven.Util;

import com.daud.gameleven.Model.OrderModel;
import com.daud.gameleven.Model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public List<OrderModel> getAllOrderList() {
        List<OrderModel> list = new ArrayList<>();
        list.add(new OrderModel(1,"LML56373833", "XAF 50000.00", "DELIVERED","24 FEB,4:30 PM"));
        list.add(new OrderModel(1,"LML56373833", "XAF 50000.00", "DELIVERED","24 FEB,4:30 PM"));
        list.add(new OrderModel(1,"LML56373833", "XAF 50000.00", "DELIVERED","24 FEB,4:30 PM"));
        list.add(new OrderModel(1,"LML56373833", "XAF 50000.00", "DELIVERED","24 FEB,4:30 PM"));
        list.add(new OrderModel(1,"LML56373833", "XAF 50000.00", "DELIVERED","24 FEB,4:30 PM"));
        list.add(new OrderModel(1,"LML56373833", "XAF 50000.00", "DELIVERED","24 FEB,4:30 PM"));

        return list;
    }

}
