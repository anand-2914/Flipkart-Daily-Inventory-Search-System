package Utils;

import model.Item;
import java.util.Comparator;

public class Utils {

    public static Comparator<Item> getComparator(String orderBy, boolean asc) {
        Comparator<Item> comparator;

        switch (orderBy.toLowerCase()) {
            case "price":
                comparator = Comparator.comparingInt(Item::getPrice);
                break;
            case "quantity":
                comparator = Comparator.comparingInt(Item::getQuantity);
                break;
            default:
                comparator = Comparator.comparingInt(Item::getPrice);
        }
        return asc ? comparator : comparator.reversed();
    }
}
