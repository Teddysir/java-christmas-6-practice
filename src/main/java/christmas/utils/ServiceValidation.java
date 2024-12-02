package christmas.utils;

import christmas.constants.ErrorMessageType;

public class ServiceValidation {

    public static void checkedTotalOrderAmount(int totalOrderAmount) {
        if(totalOrderAmount > 20 ) {
            throw new IllegalArgumentException(ErrorMessageType.INVALID_ORDER_AMOUNT.getMessage());
        }
    }


}
