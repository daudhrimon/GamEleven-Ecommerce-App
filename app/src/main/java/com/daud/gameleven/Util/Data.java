package com.daud.gameleven.Util;

import android.graphics.Color;

import com.daud.gameleven.Model.OrderModel;
import com.daud.gameleven.Model.ProductModel;
import com.daud.gameleven.R;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Data {
    public static int getRandomColor() {
        List<Integer> colorcode = new ArrayList<>();
        colorcode.add(Color.parseColor("#D81D4C"));
        colorcode.add(Color.parseColor("#68C037"));
        colorcode.add(Color.parseColor("#094D82"));
        colorcode.add(Color.parseColor("#2B2B2B"));

        Random random = new Random();
        int number = random.nextInt(colorcode.size());
        return colorcode.get(number);
    }

    public List<OrderModel> getAllOrderList() {
        List<OrderModel> list = new ArrayList<>();
        list.add(new OrderModel(1, "LML56373833", "XAF 50000.00", "DELIVERED", "24 FEB,4:30 PM"));
        list.add(new OrderModel(1, "LML56373833", "XAF 50000.00", "DELIVERED", "24 FEB,4:30 PM"));
        list.add(new OrderModel(1, "LML56373833", "XAF 50000.00", "DELIVERED", "24 FEB,4:30 PM"));
        list.add(new OrderModel(1, "LML56373833", "XAF 50000.00", "DELIVERED", "24 FEB,4:30 PM"));
        list.add(new OrderModel(1, "LML56373833", "XAF 50000.00", "DELIVERED", "24 FEB,4:30 PM"));
        list.add(new OrderModel(1, "LML56373833", "XAF 50000.00", "DELIVERED", "24 FEB,4:30 PM"));

        return list;
    }

    public List<ProductModel> getAllProduct() {
        List<ProductModel> list = new ArrayList<>();
        list.add(new ProductModel("Power Bank Water Gold", "G11 Chair", "4500.00XAF X 1", "Sound Box", "750.00", "550.00", R.drawable.one, "Discription", "200.00", 10, R.drawable.diesel));
        list.add(new ProductModel("Power Bank Water Gold", "G11 Mouse", "4500.00XAF X 1", "Sound Box", "430.00", "230.00", R.drawable.two, "Discription", "200.00", 10, R.drawable.gionee));
        list.add(new ProductModel("Power Bank Water Gold", "Gaming Pc", "4500.00XAF X 1", "Sound Box", "1430.00", "1230.00", R.drawable.three, "Discription", "200.00", 10, R.drawable.fedex));
        list.add(new ProductModel("Power Bank Water Gold", "G11 Headphone", "4500.00XAF X 1", "Sound Box", "1430.00", "1230.00", R.drawable.four, "Discription", "200.00", 10, R.drawable.micromax));
        list.add(new ProductModel("Power Bank Water Gold", "G11 Chair", "4500.00XAF X 1", "Sound Box", "750.00", "550.00", R.drawable.one, "Discription", "200.00", 10, R.drawable.diesel));
        list.add(new ProductModel("Power Bank Water Gold", "G11 Mouse", "4500.00XAF X 1", "Sound Box", "430.00", "230.00", R.drawable.two, "Discription", "200.00", 10, R.drawable.gionee));
        list.add(new ProductModel("Power Bank Water Gold", "Gaming Pc", "4500.00XAF X 1", "Sound Box", "1430.00", "1230.00", R.drawable.three, "Discription", "200.00", 10, R.drawable.fedex));
        list.add(new ProductModel("Power Bank Water Gold", "G11 Headphone", "4500.00XAF X 1", "Sound Box", "1430.00", "1230.00", R.drawable.four, "Discription", "200.00", 10, R.drawable.micromax));

        return list;
    }

    public List<ProductModel> getCarts() {
        List<ProductModel> list = new ArrayList<>();
        list.add(new ProductModel("Power Bank Water Gold", "G11 Chair", "4500.00XAF X 1", "Sound Box", "750.00", "550.00", R.drawable.one, "Discription", "200.00", 10, R.drawable.diesel));
        list.add(new ProductModel("Power Bank Water Gold", "G11 Mouse", "4500.00XAF X 1", "Sound Box", "430.00", "230.00", R.drawable.two, "Discription", "200.00", 10, R.drawable.gionee));
        list.add(new ProductModel("Power Bank Water Gold", "Gaming Pc", "4500.00XAF X 1", "Sound Box", "1430.00", "1230.00", R.drawable.three, "Discription", "200.00", 10, R.drawable.fedex));
        list.add(new ProductModel("Power Bank Water Gold", "G11 Headphone", "4500.00XAF X 1", "Sound Box", "1430.00", "1230.00", R.drawable.four, "Discription", "200.00", 10, R.drawable.micromax));
        list.add(new ProductModel("Power Bank Water Gold", "G11 Chair", "4500.00XAF X 1", "Sound Box", "750.00", "550.00", R.drawable.one, "Discription", "200.00", 10, R.drawable.diesel));
        list.add(new ProductModel("Power Bank Water Gold", "G11 Mouse", "4500.00XAF X 1", "Sound Box", "430.00", "230.00", R.drawable.two, "Discription", "200.00", 10, R.drawable.gionee));
        list.add(new ProductModel("Power Bank Water Gold", "Gaming Pc", "4500.00XAF X 1", "Sound Box", "1430.00", "1230.00", R.drawable.three, "Discription", "200.00", 10, R.drawable.fedex));
        list.add(new ProductModel("Power Bank Water Gold", "G11 Headphone", "4500.00XAF X 1", "Sound Box", "1430.00", "1230.00", R.drawable.four, "Discription", "200.00", 10, R.drawable.micromax));

        return list;
    }

    public List<ProductModel> getWishlist() {
        List<ProductModel> list = new ArrayList<>();
        list.add(new ProductModel("Power Bank Water Gold", "G11 Chair", "4500.00XAF X 1", "Sound Box", "750.00", "550.00", R.drawable.one, "Discription", "200.00", 10, R.drawable.diesel));
        list.add(new ProductModel("Power Bank Water Gold", "G11 Mouse", "4500.00XAF X 1", "Sound Box", "430.00", "230.00", R.drawable.two, "Discription", "200.00", 10, R.drawable.gionee));
        list.add(new ProductModel("Power Bank Water Gold", "Gaming Pc", "4500.00XAF X 1", "Sound Box", "1430.00", "1230.00", R.drawable.three, "Discription", "200.00", 10, R.drawable.fedex));
        list.add(new ProductModel("Power Bank Water Gold", "G11 Headphone", "4500.00XAF X 1", "Sound Box", "1430.00", "1230.00", R.drawable.four, "Discription", "200.00", 10, R.drawable.micromax));
        list.add(new ProductModel("Power Bank Water Gold", "G11 Chair", "4500.00XAF X 1", "Sound Box", "750.00", "550.00", R.drawable.one, "Discription", "200.00", 10, R.drawable.diesel));
        list.add(new ProductModel("Power Bank Water Gold", "G11 Mouse", "4500.00XAF X 1", "Sound Box", "430.00", "230.00", R.drawable.two, "Discription", "200.00", 10, R.drawable.gionee));
        list.add(new ProductModel("Power Bank Water Gold", "Gaming Pc", "4500.00XAF X 1", "Sound Box", "1430.00", "1230.00", R.drawable.three, "Discription", "200.00", 10, R.drawable.fedex));
        list.add(new ProductModel("Power Bank Water Gold", "G11 Headphone", "4500.00XAF X 1", "Sound Box", "1430.00", "1230.00", R.drawable.four, "Discription", "200.00", 10, R.drawable.micromax));

        return list;
    }

    public List<SlideModel> homeSlider(){
        List<SlideModel> imgList = new ArrayList<>();
        imgList.add(new SlideModel(R.drawable.slider_xd, ScaleTypes.FIT));
        imgList.add(new SlideModel(R.drawable.slider_one, ScaleTypes.FIT));
        imgList.add(new SlideModel(R.drawable.slider_two, ScaleTypes.FIT));
        imgList.add(new SlideModel(R.drawable.slider_three, ScaleTypes.FIT));

        return imgList;
    }

    public List<SlideModel> proDetSlider(){
        List<SlideModel> imgList = new ArrayList<>();
        imgList.add(new SlideModel(R.drawable.four, ScaleTypes.CENTER_INSIDE));
        imgList.add(new SlideModel(R.drawable.two, ScaleTypes.CENTER_INSIDE));
        imgList.add(new SlideModel(R.drawable.one, ScaleTypes.CENTER_INSIDE));

        return imgList;
    }
}
