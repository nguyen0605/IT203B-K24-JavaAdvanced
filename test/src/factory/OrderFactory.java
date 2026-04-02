package factory;

import model.OnlineOrder;
import model.Order;
import model.StoreOrder;

public class OrderFactory {
    public static Order createOrder(String type) {
        switch (type.toLowerCase()) {
            case "online":
                return new OnlineOrder();
            case "store":
                return new StoreOrder();
            default:
                throw new IllegalArgumentException("Loại không hợp lệ");
        }
    }
}
