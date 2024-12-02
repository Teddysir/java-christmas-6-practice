package christmas.model;

import christmas.view.OutputView;

import java.util.List;

public class Discount {

    private final Customer customer;
    private final Restaurant restaurant;

    private int dDayDiscount = 0;
    private int giftDiscount = 0;
    private int weekdayDiscount = 0;
    private int holidayDiscount = 0;
    private int specialDayDiscount = 0;

    public Discount(Customer customer, Restaurant restaurant) {
        this.customer = customer;
        this.restaurant = restaurant;
    }

    public void calculateMenu(int visitDate) {
        OutputView.OutputPurchasedMenusGuides();

        for (int i = 0; i < customer.getPurchasedMenus().size(); i++) {
            OutputView.OutputPurchasedMenus(customer.getPurchasedMenus().get(i).getName(), customer.getPurchasedMenus().get(i).getQuantity());
        }
        int beforeDiscountPrice = calculateBeforeDiscountPrice(customer.getPurchasedMenus());

        OutputView.OutputBeforeDiscountPrice(beforeDiscountPrice);

        boolean hasGift = checkedGift(beforeDiscountPrice);


        int dessertMenuQuantity = customer.getTotalDessertQuantity();
        int mainMenuQuantity = customer.getTotalMainMenuQuantity();

        dDay(visitDate);
        gift(hasGift);
        weekday(visitDate, dessertMenuQuantity);
        holiday(visitDate, mainMenuQuantity);
        specialDay(visitDate);


        if (dDayDiscount > 0 || giftDiscount > 0 || weekdayDiscount > 0 || holidayDiscount > 0 || specialDayDiscount > 0) {
            OutputView.OutputBenefitMessage(dDayDiscount, weekdayDiscount, holidayDiscount, hasGift, specialDayDiscount);
        } else {
            OutputView.OutputNoBenefitMessage();
        }

    }

    public void totalDiscount() {
        int totalDiscountPrice = 0 ;
        int totalDiscountPriceWithout = dDayDiscount + weekdayDiscount + holidayDiscount + specialDayDiscount;
        totalDiscountPrice += dDayDiscount + giftDiscount + weekdayDiscount + holidayDiscount + specialDayDiscount;
        OutputView.OutputTotalDiscountMessage(totalDiscountPrice);
        OutputView.OutputAfterDiscountPrice(calculateBeforeDiscountPrice(customer.getPurchasedMenus()) - totalDiscountPriceWithout);

    }

    private void specialDay(int visitDate) {
        int specialDayDiscountTrue = visitDate % 7;
        if (specialDayDiscountTrue == 3 || visitDate == 25) {
            setSpecialDayDiscount(1000);
        }
    }

    private void holiday(int visitDate, int mainMenuQuantity) {
        int weekDayDiscountTrue = visitDate % 7;
        if (weekDayDiscountTrue == 1 || weekDayDiscountTrue == 2) {
            setHolidayDiscount(mainMenuQuantity * 2023);
        }
    }

    private void weekday(int visitDate, int dessertMenuQuantity) {
        int weekDayDiscountTrue = visitDate % 7;
        if (weekDayDiscountTrue == 3 || weekDayDiscountTrue == 4 || weekDayDiscountTrue == 5 || weekDayDiscountTrue == 6 || weekDayDiscountTrue == 0) {
            setWeekdayDiscount(dessertMenuQuantity * 2023);
        }
    }

    private void gift(boolean hasGift) {
        if (hasGift) {
            setGiftDiscount(25000);
        }
    }

    private void dDay(int visitDate) {
        if (visitDate >= 1 && visitDate <= 25) {
            dDayDiscount = 1000 + visitDate * 100 - 100;
            setdDayDiscount(dDayDiscount);
        }

    }

    private int calculateBeforeDiscountPrice(List<OrderMenu> purchasedMenus) {
        int totalPrice = 0;
        for (OrderMenu purchasedMenu : purchasedMenus) {
            totalPrice += restaurant.getMenuPrice(purchasedMenu.getName()) * purchasedMenu.getQuantity();
        }
        return totalPrice;
    }

    private boolean checkedGift(int beforeDiscountPrice) {
        System.out.println("\n<증정 메뉴>");
        boolean hasGift = false;
        if (beforeDiscountPrice >= 120000) {
            hasGift = true;
            OutputView.OutputGiftMessage();
        } else {
            OutputView.OutputNoGiftMessage();
        }
        return hasGift;
    }


    public void setdDayDiscount(int dDayDiscount) {
        this.dDayDiscount = dDayDiscount;
    }

    public void setGiftDiscount(int giftDiscount) {
        this.giftDiscount = giftDiscount;
    }

    public void setWeekdayDiscount(int weekdayDiscount) {
        this.weekdayDiscount = weekdayDiscount;
    }

    public void setHolidayDiscount(int holidayDiscount) {
        this.holidayDiscount = holidayDiscount;
    }

    public void setSpecialDayDiscount(int specialDayDiscount) {
        this.specialDayDiscount = specialDayDiscount;
    }
}
