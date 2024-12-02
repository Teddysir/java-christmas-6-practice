package christmas.utils;

import christmas.model.Menu;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Splitter {

    public static List<String> commaSplitter(String rawOrderList) { // 제로콜라-3, 바베큐립,2 -> [제로콜라-3], [바베큐립-2]
        return Arrays.stream(rawOrderList.split(","))
                .map(String::trim)
                .toList();
    }

    public static String[] hyphenSplitter(String rawHyphenMenu) { // 제로콜라-3 -> [제로콜라], [3]
        return rawHyphenMenu.split("-");
    }
}
