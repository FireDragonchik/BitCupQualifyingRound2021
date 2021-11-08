package framework.utils;

public class RandomIntegerNumber {

    public static int randomNumber;

    public static int getRandomNumber(String minValue, String maxValue){
        randomNumber = Integer.parseInt(minValue) + (int)Math.round(Math.random() * Integer.parseInt(maxValue));
        return randomNumber;
    }
}
