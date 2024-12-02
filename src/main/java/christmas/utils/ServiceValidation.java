package christmas.utils;

import christmas.constants.ErrorMessageType;
import christmas.constants.MenuType;
import christmas.model.Menu;
import christmas.model.OrderMenu;
import christmas.model.Restaurant;
import org.mockito.internal.matchers.Or;

import java.util.Arrays;
import java.util.List;

public class ServiceValidation {

    public static void checkedMaximumTotalOrderAmount(int totalOrderAmount) {
        if (totalOrderAmount > 20) {
            throw new IllegalArgumentException(ErrorMessageType.INVALID_TOTAL_ORDER_AMOUNT.getMessage());
        }
    }

    public static int checkedDateFormat(String rawDate) {
        try {
            int visitDate = Integer.parseInt(rawDate);
            if(visitDate < 1 || visitDate > 31) {
                throw new IllegalArgumentException(ErrorMessageType.INVALID_DATE_RANGE.getMessage());
            }
            return visitDate;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessageType.INVALID_DATE_FORMAT.getMessage());
        }
    }

    public static void checkedMinimumOrderAmount(int orderAmount) {
        if (orderAmount < 1) {
            throw new IllegalArgumentException(ErrorMessageType.INVALID_MINIMUM_ORDER_AMOUNT.getMessage());
        }
    }

    public static int checkedMenuAmountFormat(String rawMenuAmount) {
        try {
            return Integer.parseInt(rawMenuAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessageType.INVALID_MENU_AMOUNT.getMessage());
        }
    }

    public static void checkedOrderFormatHyphen(String rawMenu) {
        if (!rawMenu.contains("-")) {
            throw new IllegalArgumentException(ErrorMessageType.INVALID_ORDER_FORMAT.getMessage());
        }
    }

    public static void checkedOrderFormatComma(String rawMenu) {
        if (rawMenu.contains(",")) {
            throw new IllegalArgumentException(ErrorMessageType.INVALID_ORDER_FORMAT.getMessage());
        }
    }

    public static void checkedOrderFormatRepeatComma(String rawMenu) {
        if (rawMenu.contains(",,")) {
            throw new IllegalArgumentException(ErrorMessageType.INVALID_ORDER_FORMAT.getMessage());
        }
    }

    public static void checkedOrderFormatRepeatHyphen(String rawMenu) {
        if (rawMenu.contains("--")) {
            throw new IllegalArgumentException(ErrorMessageType.INVALID_ORDER_FORMAT.getMessage());
        }
    }

    public static void checkedExistsMenuName(List<Menu> menus, String menuName) {
        boolean exists = menus.stream()
                .anyMatch(menu -> menu.getName().equals(menuName));

        if(!exists) {
            throw new IllegalArgumentException(ErrorMessageType.EXISTS_ORDER_MENU.getMessage());
        }
    }

    public static void checkedDuplicateMenu(List<OrderMenu> orderMenus, String name) {
        for (OrderMenu orderMenu : orderMenus) {
            if (orderMenu.getName().equals(name)) {
                throw new IllegalArgumentException(ErrorMessageType.DUPLICATE_ORDER_MENU.getMessage());
            }
        }
    }

    public static void checkedOnlyDrinkMenu(List<OrderMenu> orderMenus) {
        int mainCount = 0;
        int appetizerCount = 0;
        int dessertCount = 0;
        for (OrderMenu orderMenu : orderMenus) {
            if (orderMenu.getType().equals(MenuType.MAIN)) {
                mainCount += 1;
            }
            if (orderMenu.getType().equals(MenuType.APPETIZER)) {
                appetizerCount += 1;
            }
            if (orderMenu.getType().equals(MenuType.DESSERT)) {
                dessertCount += 1;
            }
        }

        if(mainCount ==0 && appetizerCount ==0 && dessertCount ==0) {
            throw new IllegalArgumentException(ErrorMessageType.INVALID_ORDER_ONLY_DRINK.getMessage());
        }
    }



}
