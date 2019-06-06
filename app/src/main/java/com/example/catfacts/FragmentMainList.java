package com.example.catfacts;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentMainList extends Fragment {

    View v;
    Model model;
    private RecyclerView recyclerView;
    private List<Fact> factList;

    public FragmentMainList() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_main_list, container, false);

        //тут можно попробовать использовать один адаптер на два ресайкла, но не факт
        recyclerView = (RecyclerView) v.findViewById(R.id.facts_recyclerview);
        //тут можно подключать разные списки
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(factList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new Model();
        factList = new ArrayList<>();
        factList = model.getList();

    }
}
