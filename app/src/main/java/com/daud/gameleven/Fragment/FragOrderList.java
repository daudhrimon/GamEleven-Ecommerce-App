package com.daud.gameleven.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.daud.gameleven.MainActivity;
import com.daud.gameleven.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class FragOrderList extends Fragment {
    private ImageButton backBtn;
    private ViewPager view_pager;
    private TabLayout tab_layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_orderlist, container, false);

        initial(view);

        backBtn.setOnClickListener(view1 -> {
            backPressedHandler();
        });

        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        FragOrderList.SectionsPagerAdapter adapter = new SectionsPagerAdapter(getFragmentManager());
        adapter.addFragment(OrderAllFragment.newInstance(), "ALL");
        adapter.addFragment(OrderAllFragment.newInstance(), "PENDING");
        adapter.addFragment(OrderAllFragment.newInstance(), "DELIVERED");
        adapter.addFragment(OrderAllFragment.newInstance(), "CANCEL");
        viewPager.setAdapter(adapter);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public SectionsPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    private void backPressedHandler() {
        getParentFragmentManager().popBackStack();
    }

    private void initial(View view) {
        MainActivity. fab.setVisibility(View.GONE);
        MainActivity.btmCard.setVisibility(View.GONE);
        ///////////////////////////////////////////////////////////
        view_pager = (ViewPager) view.findViewById(R.id.view_pager);
        setupViewPager(view_pager);
        tab_layout = (TabLayout) view.findViewById(R.id.tab_layout);
        tab_layout.setupWithViewPager(view_pager);
        backBtn = view.findViewById(R.id.backOrder);
    }
}