package com.example.instagram.ui.fragments.otherFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.instagram.R;
import com.example.instagram.ui.fragments.profileFragment.AdapterForLike;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

    private ArrayList<Integer> list = new ArrayList<>();
    private AdapterForLike adapter;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createList();
        initRecycler(view);
    }
    private void initRecycler(View view) {
        adapter = new AdapterForLike();
        recyclerView = view.findViewById(R.id.rv_profile);
        adapter.setList(createList());
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Integer> createList() {
        list.add(R.drawable.photo);
        list.add(R.drawable.photo);
        list.add(R.drawable.photo);
        list.add(R.drawable.photo);
        list.add(R.drawable.photo);
        list.add(R.drawable.photo);
        list.add(R.drawable.photo);
        list.add(R.drawable.photo);
        list.add(R.drawable.photo);
        list.add(R.drawable.photo);
        list.add(R.drawable.photo);
        list.add(R.drawable.photo);
        list.add(R.drawable.photo);
        list.add(R.drawable.photo);
        return list;
    }
}