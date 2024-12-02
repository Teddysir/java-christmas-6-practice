package christmas.utils;

import christmas.constants.ErrorMessageType;

import java.util.IllegalFormatException;

public class ServiceValidation {

    public static void checkedTotalOrderAmount(int totalOrderAmount) {
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

    public static void checkedOrderAmount(int orderAmount) {
        if(orderAmount < 1) {
            throw new IllegalArgumentException(ErrorMessageType.INVALID_ORDER_AMOUNT.getMessage());
        }
    }



}
