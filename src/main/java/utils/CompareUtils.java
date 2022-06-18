package utils;


public class CompareUtils {
    public CompareUtils() {
    }

    public static boolean equals(Integer var1, Integer var2) {
        return var1 == null ? var2 == null : var1.equals(var2);
    }

    public static boolean equals(Integer var1, Long var2) {
        return var1 == null ? var2 == null : Long.valueOf((long)var1).equals(var2);
    }

    public static boolean equals(Long var1, Integer var2) {
        return equals(var2, var1);
    }

    public static boolean greaterEquals(Integer var1, Integer var2) {
        return var1 != null && var2 != null && var1.compareTo(var2) >= 0;
    }

    public static boolean greater(Integer var1, Integer var2) {
        return var1 != null && var2 != null && var1.compareTo(var2) > 0;
    }

    public static boolean lessEquals(Integer var1, Integer var2) {
        return var1 != null && var2 != null && var1.compareTo(var2) <= 0;
    }

    public static boolean less(Integer var1, Integer var2) {
        return var1 != null && var2 != null && var1.compareTo(var2) < 0;
    }

    public static boolean equals(Object obj1, Object obj2) {
        return obj1 == null ? obj2 == null : obj1.equals(obj2);
    }

    public static boolean between(Integer value, Integer rangeStart, Integer rangeEnd) {
        return lessEquals(rangeStart, value) && lessEquals(value, rangeEnd);
    }

    public static <T extends Comparable> T max(T var1, T var2) {
        return var1.compareTo(var2) > 0 ? var1 : var2;
    }

    public static <T extends Comparable> T min(T var1, T var2) {
        return var2.compareTo(var1) > 0 ? var1 : var2;
    }
}
