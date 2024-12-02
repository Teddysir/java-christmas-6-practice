package christmas.controller;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.Restaurant;
import christmas.utils.ServiceValidation;
import christmas.utils.Splitter;
import christmas.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Controller {

    private final Restaurant restaurant = new Restaurant();

    public void start() {
        restaurant.initializeMenu();
        int visitDate = getVisitDate();
        getOrderMenus();
    }


    private int getVisitDate() {
        String rawDate = InputView.inputVisitDateMessage();
        return ServiceValidation.checkedDateFormat(rawDate);
    }

    private void getOrderMenus() {
        InputView.inputOrderMenuMessage();
        String rawMenu = Console.readLine().trim();

        List<String> splitCommaMenus = Splitter.commaSplitter(rawMenu);

        calculateMenu(splitCommaMenus);
    }

    private void calculateMenu(List<String> splitCommaMenus) {
        for (String splitCommaMenu : splitCommaMenus) {
            String[] splitHyphenMenu = Splitter.hyphenSplitter(splitCommaMenu);
            System.out.println(Arrays.toString(splitHyphenMenu));
        }
    }


}
