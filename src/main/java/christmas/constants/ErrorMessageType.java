package christmas.constants;

public enum ErrorMessageType {

    INVALID_TOTAL_ORDER_AMOUNT("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다. 다시 입력 해주세요."),
    INVALID_DATE_FORMAT("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_MINIMUM_ORDER_AMOUNT("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_MENU_AMOUNT("[ERROR] 유효하지 않은 주문 개수입니다. 다시 입력해 주세요."),
    INVALID_ORDER_FORMAT("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    EXISTS_ORDER_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    DUPLICATE_ORDER_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_ORDER_ONLY_DRINK("[ERROR] 음료만 주문 시, 주문할 수 없습니다. 다시 입력 해주세요.");

    private final String message;

    ErrorMessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
