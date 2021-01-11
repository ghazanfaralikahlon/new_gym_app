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
                new MyListData("ABS BEGINNER", R.drawable.abs_beginner),
                new MyListData("CHEST BEGINNER", R.drawable.chest_beginner),
                new MyListData("ARM BEGINNER", R.drawable.arm_beginner),
                new MyListData("LEG BEGINNER", R.drawable.leg_beginer),
                new MyListData("SHOULDER BEGINNER", R.drawable.shoulder_beginner),
                new MyListData("ABS INTERMEDIATE", R.drawable.abs_intermediate),
                new MyListData("CHEST INTERMEDIATE", R.drawable.chest_intermediate),
                new MyListData("ARM INTERMEDIATE", R.drawable.arm_intermediate),
                new MyListData("LEG INTERMEDIATE", R.drawable.leg_intermediate),
                new MyListData("SHOULDER INTERMEDIATE", R.drawable.shoulder_intermediate),
                new MyListData("ABS ADVANCED", R.drawable.abs_advancd),
                new MyListData("CHEST ADVANCED", R.drawable.chest_advanced),
                new MyListData("ARM ADVANCED", R.drawable.arm_advaned),
                new MyListData("LEG ADVANCED", R.drawable.leg_advanced),
                new MyListData("SHOULDER ADVANCED", R.drawable.shoulder_advanced),
        };

        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(myListData, getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);







        return root;
    }
}