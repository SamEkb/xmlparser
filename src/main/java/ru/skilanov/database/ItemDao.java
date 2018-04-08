package ru.skilanov.database;

import ru.skilanov.model.Item;

import java.util.List;

public interface ItemDao {

    List<Item> getAll();

    void insert(Item item);

    void deleteAll();
}
