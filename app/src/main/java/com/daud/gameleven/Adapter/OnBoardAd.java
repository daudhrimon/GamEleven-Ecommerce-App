package com.daud.gameleven.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.daud.gameleven.R;

public class OnBoardAd extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;

    public OnBoardAd(Context context) {
        this.context = context;
    }

    int images[] = {R.drawable.onb_img_first, R.drawable.onb_img_sec, R.drawable.onb_img_third};

    int headers[] = {R.string.onb_header1, R.string.onb_header2, R.string.onb_header3};

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.lay_onboarding, container, false);

        ImageView onImage = view.findViewById(R.id.onImage);
        TextView onHeader = view.findViewById(R.id.onHeader);

        onImage.setImageResource(images[position]);
        onHeader.setText(headers[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
