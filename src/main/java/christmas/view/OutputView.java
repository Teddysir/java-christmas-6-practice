package christmas.view;

public class OutputView {

    public static void OutputPurchasedMenusGuides() {
        System.out.println("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
        System.out.println("<주문 메뉴>");
    }

    public static void OutputPurchasedMenus(String name, int quantity) {
        System.out.printf("%s %d개\n", name, quantity);
    }

    public static void OutputBeforeDiscountPrice(int price) {
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.printf("%,d원\n", price);
    }

    public static void OutputGiftMessage() {
        System.out.println("샴페인 1개\n");
    }

    public static void OutputNoGiftMessage() {
        System.out.println("없음");
    }

    // , int weekdayDiscount, int holidayDiscount, int specialDiscount, boolean giftDiscount
    public static void OutputBenefitMessage(int dDayDiscount, int weekdayDiscount, int holidayDiscount, boolean giftDiscount) {
        System.out.println("<혜택 내역>");
        dDayDiscount(dDayDiscount);
        weekdayDiscount(weekdayDiscount);
        holidayDiscount(holidayDiscount);
        giftDiscount(giftDiscount);
    }

    private static void weekdayDiscount(int weekdayDiscount) {
        if(weekdayDiscount > 0) {
            System.out.printf("평일 할인: -%,d원\n", weekdayDiscount);
        }
    }

    private static void holidayDiscount(int holidayDiscount) {
        if(holidayDiscount > 0) {
            System.out.printf("주말 할인: -%,d원\n", holidayDiscount);
        }
    }

    private static void giftDiscount(boolean hasGift) {
        if (hasGift) {
            System.out.println("증정 이벤트: -25,000원");
        }
    }

    private static void dDayDiscount(int dDayDiscount) {
        if (dDayDiscount >= 1000) {
            System.out.printf("크리스마스 디데이 할인: -%,d원\n", dDayDiscount);
        }
    }
}
