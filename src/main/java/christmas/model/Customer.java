package christmas.model;

import christmas.constants.MenuType;
import christmas.utils.ServiceValidation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {

    List<OrderMenu> purchasedMenus = new ArrayList<>();

    public void addOrderMenu(String name, int price, int quantity, MenuType type) {
        ServiceValidation.checkedDuplicateMenu(getPurchasedMenus(), name);
        purchasedMenus.add(new OrderMenu(name, price, quantity, type));
    }

    public List<OrderMenu> getPurchasedMenus() {
        return Collections.unmodifiableList(new ArrayList<>(purchasedMenus));
    }
}
