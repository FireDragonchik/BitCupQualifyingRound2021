package framework.utils;

import java.util.Locale;
import java.util.Random;

public class RandomString {
    public static String randomString;

    public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final String lower = upper.toLowerCase(Locale.ROOT);

    public static final String digits = "0123456789";

    public static final String alphanum = upper + lower + digits;

    public static final char[] pool = alphanum.toCharArray();

    private static Random random = new Random();

    public static  char getChar(){
        return pool[random.nextInt(pool.length)];
    }

    public static String setRandomString(int lengthOfText){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lengthOfText; i++){
            stringBuilder.append(getChar());
        }
        randomString = new String(stringBuilder);
        return randomString;
    }
}
