package christmas.constants;

public enum MenuType {

    APPETIZER("에피타이저"),
    MAIN("메인메뉴"),
    DESSERT("디저트"),
    DRINK("음료");


    private final String type;

    MenuType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
