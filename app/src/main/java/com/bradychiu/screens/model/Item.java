package com.bradychiu.screens.model;

import java.util.UUID;

public class Item {

    private UUID mUuid;
    private int mCount;
    private int mNumber;

    public Item(UUID uuid, int count, int number) {
        mUuid = uuid;
        mCount = count;
        mNumber = number;
    }

    public UUID getUuid() {
        return mUuid;
    }

    public void setUuid(UUID uuid) {
        mUuid = uuid;
    }

    public int getCount() {
        return mCount;
    }

    public void setCount(int count) {
        mCount = count;
    }

    public int getNumber() {
        return mNumber;
    }

    public void setNumber(int number) {
        mNumber = number;
    }

    @Override
    public String toString() {
        return "Item{" +
                "mUuid=" + mUuid +
                ", mNumber=" + mNumber +
                '}';
    }
}
