package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomArrayValue(String[] array) {
        int index = getRandomInt(0, array.length - 1);
        return array[index];
    }

    public static String getValueFromDate(String pattern, Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, Locale.ENGLISH);
        return formatter.format(date);
    }
}
