package ru.skilanov.database;

import ru.skilanov.model.Item;

import java.util.List;

/**
 * Интерфейс dao.
 */
public interface ItemDao {

    /**
     * Получение всех item.
     *
     * @return список item.
     */
    List<Item> getAll();

    /**
     * Ввод item.
     *
     * @param item item
     */
    void insert(Item item);

    /**
     * Удаление всех item.
     */
    void deleteAll();
}
