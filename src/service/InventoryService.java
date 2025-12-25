package service;

import java.util.List;
import model.Item;
import pojo.SearchRequest;

public interface InventoryService {

    void addItem(String brand, String category, int price);

    void addInventory(String brand, String category, int quantity);

    List<Item> searchItems(SearchRequest request, String orderBy, boolean asc);
}
