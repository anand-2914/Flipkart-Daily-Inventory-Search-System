package repository;

import model.Item;
import java.util.*;

public class ItemRepository {

    private final Map<String, Item> store = new HashMap<>();

    private String key(String brand, String category) {
        return brand + "#" + category;
    }

    public void addItem(Item item) {
        store.putIfAbsent(key(item.getBrand(), item.getCategory()), item);
    }

    public Item getItem(String brand, String category) {
        return store.get(key(brand, category));
    }

    public Collection<Item> getAllItems() {
        return store.values();
    }
}
