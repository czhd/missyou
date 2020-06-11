package pro.kelu.missyou.util;

import pro.kelu.missyou.bo.PageCounter;

public class CommonUtil {

    public static PageCounter convertToPageParameter(int start, int count) {
        int page = start / count;
        return PageCounter.builder().page(page).count(count).build();
    }
}
