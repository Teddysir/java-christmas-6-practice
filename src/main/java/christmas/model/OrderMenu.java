package christmas.model;

import christmas.constants.MenuType;

public class OrderMenu {

    private String name;
    private int price;
    private int quantity;
    private MenuType type;

    public OrderMenu(String name, int price, int quantity, MenuType type) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }

    public MenuType getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
