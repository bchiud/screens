package com.bradychiu.screens;

import com.bradychiu.screens.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataGenerator {

    private static DataGenerator SINGLETON_DATA_GENERATOR;
    private List<Item> SINGLETON_DATA_LIST = new ArrayList<>();

    public static DataGenerator getInstance() {
        if(SINGLETON_DATA_GENERATOR == null) {
            SINGLETON_DATA_GENERATOR = new DataGenerator();
        }

        return SINGLETON_DATA_GENERATOR;
    }

    public List<Item> getData() {
        if(SINGLETON_DATA_LIST.size() == 0) {
            for(int i = 0; i < 100; i++) {
                Item item = new Item(UUID.randomUUID(), i, (int) Math.random() * 100);
                SINGLETON_DATA_LIST.add(item);
            }
        }

        return SINGLETON_DATA_LIST;
    }

    public Item getItem(UUID uuid) {
        int i = 0;
        while(SINGLETON_DATA_LIST.get(i).getUuid() != uuid) {
            i++;
        }
        Item item = SINGLETON_DATA_LIST.get(i);
        return item;
    }
}
