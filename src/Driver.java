import pojo.SearchRequest;
import service.InventoryService;
import service.serviceImpl.InventoryServiceImpl;

import java.util.Arrays;

public class Driver {
        public static void main(String[] args) {

                InventoryService service = new InventoryServiceImpl();

                service.addItem("Amul", "Milk", 100);
                service.addItem("Amul", "Curd", 50);
                service.addItem("Nestle", "Milk", 60);
                service.addItem("Nestle", "Curd", 90);

                service.addInventory("Amul", "Milk", 10);
                service.addInventory("Nestle", "Milk", 5);
                service.addInventory("Nestle", "Curd", 10);
                service.addInventory("Amul", "Milk", 10);
                service.addInventory("Amul", "Curd", 5);

                SearchRequest req = new SearchRequest();
                req.categories = Arrays.asList("Milk");

                service.searchItems(req, "price", false)
                                .forEach(System.out::println);

                SearchRequest brandReq = new SearchRequest();
                brandReq.brands = Arrays.asList("Nestle");

                System.out.println("\nSearch by brand = Nestle");
                service.searchItems(brandReq, "price", true)
                                .forEach(System.out::println);

        }
}
