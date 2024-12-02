package christmas.model;

import christmas.constants.MenuType;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    List<Menu> menuBoard = new ArrayList<>();

    public void initializeMenu() {
        menuBoard.add(new Menu("양송이스프", 6000, MenuType.APPETIZER));
        menuBoard.add(new Menu("타파스", 5500, MenuType.APPETIZER));
        menuBoard.add(new Menu("시저샐러드", 8000, MenuType.APPETIZER));

        menuBoard.add(new Menu("티본스테이크", 55000, MenuType.MAIN));
        menuBoard.add(new Menu("바비큐립", 54000, MenuType.MAIN));
        menuBoard.add(new Menu("해산물파스타", 35000, MenuType.MAIN));
        menuBoard.add(new Menu("크리스마스파스타", 25000, MenuType.MAIN));

        menuBoard.add(new Menu("초코케이크", 15000, MenuType.DESSERT));
        menuBoard.add(new Menu("아이스크림", 5000, MenuType.DESSERT));

        menuBoard.add(new Menu("제로콜라", 3000, MenuType.DRINK));
        menuBoard.add(new Menu("레드와인", 60000, MenuType.DRINK));
        menuBoard.add(new Menu("샴페인", 25000, MenuType.DRINK));
    }

}
