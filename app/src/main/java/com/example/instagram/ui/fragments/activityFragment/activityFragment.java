package com.example.instagram.ui.fragments.activityFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.instagram.R;
import com.example.instagram.ui.models.Model_activity;

import java.util.ArrayList;

public class activityFragment extends Fragment {

    private ArrayList<Model_activity> list = new ArrayList<>();
    private ActivityAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_activity, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createList();
        initRecycler(view);
    }

    private void createList() {
        list = new ArrayList<>();
        list.add(new Model_activity(R.drawable.girl, R.drawable.photo, "@karanee liked your post"));
        list.add(new Model_activity(R.drawable.girl, R.drawable.photo, "@karanee liked your post"));
        list.add(new Model_activity(R.drawable.girl, R.drawable.photo, "@karanee liked your post"));
        list.add(new Model_activity(R.drawable.girl, R.drawable.photo, "@karanee liked your post"));

    }

    private void initRecycler(View view) {
        adapter = new ActivityAdapter();
        recyclerView = view.findViewById(R.id.activity_rv);
        adapter.setList(list);
        recyclerView.setAdapter(adapter);

    }
}