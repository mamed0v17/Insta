package com.example.instagram.ui.fragments.profileFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.instagram.R;
import com.example.instagram.ui.fragments.otherFragment.FirstFragment;
import com.example.instagram.ui.fragments.otherFragment.SecondFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class profileFragment extends Fragment {

    private TabLayout tabLayout;
    private ArrayList<Fragment> list = new ArrayList<>();
    private int[] icon = {R.drawable.grid,R.drawable.tags};
    private ViewPager2 viewPager;
    private AdapterViewPager adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initViewPager();
        initTab();
    }
    private void initTab() {
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setIcon(icon[position]);
            }
        }).attach();
    }

    private void initViewPager() {
        adapter = new AdapterViewPager(this);
        list.add(new FirstFragment());
        list.add(new SecondFragment());
        adapter.setList(list);
        viewPager.setAdapter(adapter);
    }

    private void initView(View view) {
        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPager);
    }
}