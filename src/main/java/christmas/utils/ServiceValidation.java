package christmas.utils;

import christmas.constants.ErrorMessageType;

import java.util.IllegalFormatException;

public class ServiceValidation {

    public static void checkedTotalOrderAmount(int totalOrderAmount) {
        if(totalOrderAmount > 20 ) {
            throw new IllegalArgumentException(ErrorMessageType.INVALID_ORDER_AMOUNT.getMessage());
        }
    }

    public static void checkedDateFormat(String rawDate) {
        try {
             Integer.parseInt(rawDate);
        } catch (IllegalFormatException e) {
            throw new IllegalArgumentException(ErrorMessageType.INVALID_DATE_FORMAT.getMessage());
        }
    }


}
