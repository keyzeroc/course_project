package project.io;

/**
 * Created by keyzR on 04.08.2017.
 */
public class Validator {

    public static boolean isReleaseYear(int year){
        return year >= 1880 && year <= 2050;
    }

    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
