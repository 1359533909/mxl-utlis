package utils;

import java.lang.reflect.Array;
import java.util.Collection;

public class ArrayUtils extends org.apache.commons.lang3.ArrayUtils {
    public ArrayUtils() {
    }

    public static int length(Object[] array) {
        return array == null ? 0 : array.length;
    }

    public static int length(int[] array) {
        return array == null ? 0 : array.length;
    }

    public static int length(long[] array) {
        return array == null ? 0 : array.length;
    }

    public static <T> T[] concat(T[] a1, T... a2) {
        if (a1 == null && a2 == null) {
            return null;
        } else {
            int length1 = length(a1);
            int length2 = length(a2);
            int newLength = length1 + length2;
            Class componentType = a1 == null ? a2.getClass().getComponentType() : a1.getClass().getComponentType();
            T[] result = (T[]) Array.newInstance(componentType, newLength);
            if (length1 > 0) {
                System.arraycopy(a1, 0, result, 0, length1);
            }

            if (length2 > 0) {
                System.arraycopy(a2, 0, result, length1, length2);
            }

            return result;
        }
    }

    public static int[] concat(int[] a1, int... a2) {
        if (a1 == null && a2 == null) {
            return null;
        } else {
            int length1 = length(a1);
            int length2 = length(a2);
            int newLength = length1 + length2;
            int[] result = new int[newLength];
            if (length1 > 0) {
                System.arraycopy(a1, 0, result, 0, length1);
            }

            if (length2 > 0) {
                System.arraycopy(a2, 0, result, length1, length2);
            }

            return result;
        }
    }

    public static long[] concat(long[] a1, long... a2) {
        if (a1 == null && a2 == null) {
            return null;
        } else {
            int length1 = length(a1);
            int length2 = length(a2);
            int newLength = length1 + length2;
            long[] result = new long[newLength];
            if (length1 > 0) {
                System.arraycopy(a1, 0, result, 0, length1);
            }

            if (length2 > 0) {
                System.arraycopy(a2, 0, result, length1, length2);
            }

            return result;
        }
    }

    public static String toString(Object[] array) {
        if (array != null && array.length != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            sb.append(StringUtils.join(array, ','));
            return sb.append(']').toString();
        } else {
            return "[]";
        }
    }

    public static String toString(int[] array) {
        if (array != null && array.length != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            sb.append(StringUtils.join(array, ','));
            return sb.append(']').toString();
        } else {
            return "[]";
        }
    }

    public static String toString(long[] array) {
        if (array != null && array.length != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            sb.append(StringUtils.join(array, ','));
            return sb.append(']').toString();
        } else {
            return "[]";
        }
    }

    public static <T> T[] toArray(T... items) {
        return items;
    }

    public static int[] toIntArray(int... items) {
        return items;
    }

    public static long[] toLongArray(long... items) {
        return items;
    }

    public static <T> T[] toArray(Collection collection, Class<T> componentType) {
        int length = collection == null ? 0 : collection.size();
        T[] result = (T[]) Array.newInstance(componentType, length);
        if (length > 0) {
            result = (T[]) collection.toArray(result);
        }

        return result;
    }

    public static int indexOf(Object[] array, Object objectToFind) {
        if (length(array) == 0) {
            return -1;
        } else {
            int startIndex = 0;
            int i;
            if (objectToFind == null) {
                for(i = startIndex; i < array.length; ++i) {
                    if (array[i] == null) {
                        return i;
                    }
                }
            } else if (array.getClass().getComponentType().isInstance(objectToFind)) {
                for(i = startIndex; i < array.length; ++i) {
                    if (objectToFind.equals(array[i])) {
                        return i;
                    }
                }
            }

            return -1;
        }
    }

    public static int indexOf(int[] array, int valueToFind) {
        if (length(array) == 0) {
            return -1;
        } else {
            int startIndex = 0;

            for(int i = startIndex; i < array.length; ++i) {
                if (valueToFind == array[i]) {
                    return i;
                }
            }

            return -1;
        }
    }

    public static int getArrayLength(Object o) {
        return getLength(o);
    }

    public static <T> boolean containsNotNullElement(T... elements) {
        if (isEmpty(elements)) {
            return false;
        } else {
            Object[] var1 = elements;
            int var2 = elements.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                T e = (T) var1[var3];
                if (e != null) {
                    return true;
                }
            }

            return false;
        }
    }
}

