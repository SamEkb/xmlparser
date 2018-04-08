package ru.skilanov.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "items")
public class ItemList {

    private List<Item> itemList = new ArrayList<>();

    @XmlElement(name = "item", type = Item.class)
    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void add(Item item) {
        itemList.add(item);
    }

    @Override
    public String toString() {
        return "ItemList{" +
                "itemList=" + itemList +
                '}';
    }
}
