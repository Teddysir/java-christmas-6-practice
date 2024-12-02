package christmas.model;

import christmas.constants.MenuType;

public class Menu {

    private String name;
    private int price;
    private MenuType type;

    public Menu(String name, int price, MenuType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

}
