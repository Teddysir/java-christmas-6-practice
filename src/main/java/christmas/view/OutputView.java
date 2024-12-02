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
        System.out.printf("%,d원\n\n", price);
    }
}
