class Order {
    String orderId;
    String orderDate;

    String getOrderStatus() {
        return "Order placed";
    }
}

class ShippedOrder extends Order {
    String trackingNumber;

    String getOrderStatus() {
        return "Order shipped";
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    String getOrderStatus() {
        return "Order delivered";
    }
}

public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        order.orderId = "O12345";
        order.orderDate = "2025-02-07";

        ShippedOrder shippedOrder = new ShippedOrder();
        shippedOrder.orderId = "O12346";
        shippedOrder.orderDate = "2025-02-06";
        shippedOrder.trackingNumber = "T78910";

        DeliveredOrder deliveredOrder = new DeliveredOrder();
        deliveredOrder.orderId = "O12347";
        deliveredOrder.orderDate = "2025-02-05";
        deliveredOrder.trackingNumber = "T78911";
        deliveredOrder.deliveryDate = "2025-02-07";

        System.out.println("Order Status: " + order.getOrderStatus());
        System.out.println("Shipped Order Status: " + shippedOrder.getOrderStatus());
        System.out.println("Delivered Order Status: " + deliveredOrder.getOrderStatus());
    }
}

