package com.manoriega.dolarhoy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentMemoryStore implements IConcurrentMemoryStore {

    private List<Item> itemList;

    @Override
    public void store(String key, Item item) throws IllegalArgumentException {
        itemList = new ArrayList<>();
        item.setKey(key);
        itemList.add(item);
    }

    @Override
    public void update(String key, int value1, int value2) {
        Item item = getItem(key);
        item.setValue1(value1);
        item.setValue2(value2);
        itemList.add(item);

    }

    @Override
    public Iterator<Item> valueIterator() {

        Iterator<Item> itemIterator = itemList.iterator();

        while (itemIterator.hasNext()) {
            return (Iterator<Item>) itemIterator.next();
        }
        return null;
    }

    @Override
    public void remove(String key) {
        Item item = getItem(key);
        itemList.remove(item);
    }

    @Override
    public Item getItem(String key) {
        for (Item item : itemList) {
            if (item.getKey().equals(key))
                return item;
        }
        return null;
    }

}
