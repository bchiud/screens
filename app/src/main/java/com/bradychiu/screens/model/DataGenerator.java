package com.bradychiu.screens.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataGenerator {

    private static DataGenerator singleton;
    private List<Item> itemsList;

    private DataGenerator() {
        itemsList = new ArrayList<>();
    }

    public static DataGenerator getInstance() {
        if(singleton == null) {
            singleton = new DataGenerator();
        }

        return singleton;
    }

    public List<Item> getItems() {
        return itemsList;
    }

    public Item getItem(UUID uuid) {
        int size = getSize();
        Item currentItem;
        for(int i = 0; i < size; i++) {
            currentItem = itemsList.get(i);
            if(currentItem.getUuid().equals(uuid)) {
                return currentItem;
            }
        }

        return null;
    }

    public int getSize() {
        return itemsList.size();
    }

    private Item createNewItem() {
        return new Item(UUID.randomUUID(), (int) (Math.random() * 100));
    }

    public void addItemToBeginning() {
        itemsList.add(0, createNewItem());
    }

    public void addItemToEnd() {
        itemsList.add(createNewItem());
    }

    public void removeItemFromBeginning() {
        itemsList.remove(0);
    }

    public void removeItemFromEnd() {
        itemsList.remove(getSize() - 1);
    }
}
