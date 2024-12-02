package christmas.controller;

import camp.nextstep.edu.missionutils.Console;
import christmas.constants.MenuType;
import christmas.model.Customer;
import christmas.model.OrderMenu;
import christmas.model.Restaurant;
import christmas.utils.ServiceValidation;
import christmas.utils.Splitter;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class Controller {

    private final Restaurant restaurant = new Restaurant();
    private final Customer customer = new Customer();

    public void start() {
        restaurant.initializeMenu();
        int visitDate = getVisitDate();
        getOrderMenus();
        ServiceValidation.checkedOnlyDrinkMenu(customer.getPurchasedMenus());

        calculateMenu();

    }


    private int getVisitDate() {
        String rawDate = InputView.inputVisitDateMessage();
        return ServiceValidation.checkedDateFormat(rawDate);
    }

    private void getOrderMenus() {
        InputView.inputOrderMenuMessage();
        String rawMenu = Console.readLine().trim();

        ServiceValidation.checkedOrderFormatRepeatComma(rawMenu);
        ServiceValidation.checkedOrderFormatRepeatHyphen(rawMenu);

        List<String> splitCommaMenus = Splitter.commaSplitter(rawMenu);

        addMenu(splitCommaMenus);
    }

    private void addMenu(List<String> splitCommaMenus) {
        int totalOrderAmount = 0;

        for (String splitCommaMenu : splitCommaMenus) {
            String[] splitHyphenMenu = Splitter.hyphenSplitter(splitCommaMenu);

            ServiceValidation.checkedOrderFormatComma(splitCommaMenu);
            ServiceValidation.checkedOrderFormatHyphen(splitCommaMenu);

            String menuName = splitHyphenMenu[0];
            int menuAmount = ServiceValidation.checkedMenuAmountFormat(splitHyphenMenu[1]);

            ServiceValidation.checkedExistsMenuName(restaurant.getMenuBoard(), menuName);
            ServiceValidation.checkedMinimumOrderAmount(menuAmount);

            updatePurchasedMenu(menuName, menuAmount);

            totalOrderAmount += menuAmount;
        }
        ServiceValidation.checkedMaximumTotalOrderAmount(totalOrderAmount);
    }

    private void updatePurchasedMenu(String menuName, int menuAmount) {
        int menuPrice = restaurant.getMenuPrice(menuName);
        MenuType type = restaurant.getMenuType(menuName);

        customer.addOrderMenu(menuName, menuPrice, menuAmount, type);
    }

    private void calculateMenu() {
        OutputView.OutputPurchasedMenusGuides();
        for (int i = 0; i < customer.getPurchasedMenus().size(); i++) {
            OutputView.OutputPurchasedMenus(customer.getPurchasedMenus().get(i).getName(), customer.getPurchasedMenus().get(i).getQuantity());
        }
        int beforeDiscountPrice = calculateBeforeDiscountPrice(customer.getPurchasedMenus());
        OutputView.OutputBeforeDiscountPrice(beforeDiscountPrice);

    }

    private int calculateBeforeDiscountPrice(List<OrderMenu> purchasedMenus) {
        int totalPrice = 0;
        for (int i = 0; i< purchasedMenus.size(); i++ ){
            totalPrice += restaurant.getMenuPrice(purchasedMenus.get(i).getName()) * purchasedMenus.get(i).getQuantity();
        }
        return totalPrice;
    }


}
