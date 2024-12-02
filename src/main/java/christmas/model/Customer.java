package christmas.model;

import christmas.constants.MenuType;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    List<OrderMenu> purchasedMenus = new ArrayList<>();

    public void addOrderMenu(String name, int price, int quantity, MenuType type) {
        purchasedMenus.add(new OrderMenu(name, price, quantity, type));
    }
}
