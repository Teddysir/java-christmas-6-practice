package christmas.controller;

import christmas.model.Restaurant;
import christmas.utils.ServiceValidation;
import christmas.view.InputView;

public class Controller {

    private final Restaurant restaurant = new Restaurant();

    public void start() {
        restaurant.initializeMenu();
        inputVisitDate();
    }


    public void inputVisitDate() {
        String rawDate = InputView.inputVisitDateMessage();
        int visitDate = ServiceValidation.checkedDateFormat(rawDate);

    }
}
