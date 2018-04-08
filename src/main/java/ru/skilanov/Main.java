package ru.skilanov;

import ru.skilanov.database.ItemDaoImpl;
import ru.skilanov.model.Item;
import ru.skilanov.parsers.ParseToXml;
import ru.skilanov.parsers.ParseToXslt;

import java.util.List;

/**
 * Класс запуска.
 */
public class Main {

    /**
     * Количество полей.
     */
    private static final int FIELD_COUNT = 10;

    /**
     * Точка входа в программу.
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    /**
     * Метод запускате программу в исполнение.
     */
    private void start() {
        ParseToXml parseToXml = new ParseToXml();
        ParseToXslt parseToXslt = new ParseToXslt();
        Item item = new Item();
        ItemDaoImpl tw = new ItemDaoImpl();

        item.setField(FIELD_COUNT);
        tw.deleteAll();
        tw.insert(item);

        parseToXml.marshall();
        parseToXslt.transformXml();
        parseToXml.unMarshall();

        List<Item> itemList = tw.getAll();
        int result = 0;
        for (Item i : itemList) {
            result = result + i.getField();
        }
        System.out.println(result);
    }
}