package christmas.utils;

public class Splitter {

    public static String[] commaSplitter(String rawOrderList) { // 제로콜라-3, 바베큐립,2 -> [제로콜라-3], [바베큐립-2]
        return rawOrderList.split(",");
    }

    public static String[] hyphenSplitter(String rawHyphenMenu) { // 제로콜라-3 -> [제로콜라], [3]
        return rawHyphenMenu.split("-");
    }
}
