package christmas.utils;

import christmas.constants.ErrorMessageType;

public class ServiceValidation {

    public static void checkedMaximumTotalOrderAmount(int totalOrderAmount) {
        if(totalOrderAmount > 20 ) {
            throw new IllegalArgumentException(ErrorMessageType.INVALID_TOTAL_ORDER_AMOUNT.getMessage());
        }
    }

    public static int checkedDateFormat(String rawDate) {
        try {
             return Integer.parseInt(rawDate);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessageType.INVALID_DATE_FORMAT.getMessage());
        }
    }

    public static void checkedMinimumOrderAmount(int orderAmount) {
        if(orderAmount < 1) {
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
        if(!rawMenu.contains("-")) {
            throw new IllegalArgumentException(ErrorMessageType.INVALID_ORDER_FORMAT.getMessage());
        }
    }

    public static void checkedOrderFormatComma(String rawMenu) {
        if(!rawMenu.contains(",")) {
            throw new IllegalArgumentException(ErrorMessageType.INVALID_ORDER_FORMAT.getMessage());
        }
    }

    public static void checkedOrderFormatRepeatComma(String rawMenu) {
        if(rawMenu.contains(",,")) {
            throw new IllegalArgumentException(ErrorMessageType.INVALID_ORDER_FORMAT.getMessage());
        }
    }

    public static void checkedOrderFormatRepeatHyphen(String rawMenu) {
        if(rawMenu.contains("--")) {
            throw new IllegalArgumentException(ErrorMessageType.INVALID_ORDER_FORMAT.getMessage());
        }
    }



}
