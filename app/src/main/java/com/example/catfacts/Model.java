package com.example.catfacts;

import java.util.ArrayList;
import java.util.List;

public class Model {
    public List<Fact> listfact;
    public List<Fact> favoriteFactList;
    //загрузить mDataList из бд
    //обновить его с сервера с учетом избранного
    //сгенерировать два списка
    //переопределить онклик для избранного на удаление из второго списка
    //переопределить онклик для обычного на добавление во второй список

    public Model() {
        listfact = new ArrayList<>();
        favoriteFactList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            listfact.add(new Fact((100 + i) + "", "Wow Text from model !", "++++", true));

        }
    }


    public List<Fact> getList() {

        return listfact;
    }


    public List<Fact> getFavoriteList() {
        List<Fact> list;
        list = getList();

        favoriteFactList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            boolean isFavorite = list.get(i).getFavorite();
            if (isFavorite = true) {
                favoriteFactList.add(list.get(i));
            }
        }
        return favoriteFactList;
    }
}
