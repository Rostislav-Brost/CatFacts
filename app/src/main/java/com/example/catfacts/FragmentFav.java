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

public class FragmentFav extends Fragment {
    View v;
    Model model;
    private RecyclerView recyclerView;
    private List<Fact> favoritelist;
    public FragmentFav() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       //favoritelist= model.getList();
        v=inflater.inflate(R.layout.fragment_fav,container,false);
        recyclerView=(RecyclerView)v.findViewById(R.id.fav_facts_recyclerview);//тут можно попробовать использовать один адаптер на два ресайкла, но не факт
        RecyclerViewAdapter recyclerViewAdapter= new RecyclerViewAdapter(favoritelist);//тут можно подключать разные списки
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       model=new Model( );
        favoritelist=new ArrayList<>();
        favoritelist= model.getFavoriteList();
//        for(int i=0; i<2;i++){
//            favoritelist.add(new Fact((100+i)+"","Wow Text!","++++",false));
//
//        }

    }






}
