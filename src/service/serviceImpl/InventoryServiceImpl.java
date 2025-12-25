package service.serviceImpl;

import model.Item;
import pojo.SearchRequest;
import repository.ItemRepository;
import service.InventoryService;
import Utils.Utils;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryServiceImpl implements InventoryService {

    private final ItemRepository repository = new ItemRepository();

    @Override
    public void addItem(String brand, String category, int price) {
        repository.addItem(new Item(brand, category, price));
        System.out.println("AddItem(" + brand + ", " + category + ", " + price + ")");
    }

    @Override
    public void addInventory(String brand, String category, int quantity) {
        Item item = repository.getItem(brand, category);
        if (item == null) {
            System.out.println("Item not found");
            return;
        }
        item.addQuantity(quantity);
        System.out.println("AddInventory(" + brand + ", " + category + ", " + quantity + ")");
    }

    @Override
    public List<Item> searchItems(SearchRequest req, String orderBy, boolean asc) {
        return repository.getAllItems().stream()
                .filter(i -> req.brands == null || req.brands.contains(i.getBrand()))
                .filter(i -> req.categories == null || req.categories.contains(i.getCategory()))
                .filter(i -> req.minPrice == null || i.getPrice() >= req.minPrice)
                .filter(i -> req.maxPrice == null || i.getPrice() <= req.maxPrice)
                .sorted(Utils.getComparator(orderBy, asc))
                .collect(Collectors.toList());
    }
}
