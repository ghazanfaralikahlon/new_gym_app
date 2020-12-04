package com.example.gym_application.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gym_application.Adapters.MyListAdapter;
import com.example.gym_application.Models.MyListData;
import com.example.gym_application.R;


public class HomeFragment extends Fragment {

    Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_home, container, false);


        MyListData[] myListData = new MyListData[] {
                new MyListData("ABS BEGINNER", R.drawable.gym_header_image3),
                new MyListData("CHEST BEGINNER", R.drawable.gym_header_image2),
                new MyListData("ARM BEGINNER", R.drawable.gym_header_image3),
                new MyListData("LEG BEGINNER", R.drawable.gym_header_image2),
                new MyListData("SHOULDER BEGINNER", R.drawable.gym_header_image3),
                new MyListData("ABS INTERMEDIATE", R.drawable.gym_header_image2),
                new MyListData("CHEST INTERMEDIATE", R.drawable.gym_header_image2),
                new MyListData("ARM INTERMEDIATE", R.drawable.gym_header_image2),
                new MyListData("LEG INTERMEDIATE", R.drawable.gym_header_image2),
                new MyListData("SHOULDER INTERMEDIATE", R.drawable.gym_header_image2),
                new MyListData("ABS ADVANCED", R.drawable.gym_header_image2),
                new MyListData("CHEST ADVANCED", R.drawable.gym_header_image2),
                new MyListData("ARM ADVANCED", R.drawable.gym_header_image2),
                new MyListData("LEG ADVANCED", R.drawable.gym_header_image2),
                new MyListData("SHOULDER ADVANCED", R.drawable.gym_header_image2),
        };

        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(myListData, getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);







        return root;
    }
}