package commons;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
import exception.APIRuntimeException;
import resp.IResponseStatusMsg;
import utils.ArrayUtils;
import utils.CollectionUtils;
import utils.StringSpliceUtils;
import utils.StringUtils;

import java.util.Collection;
import java.util.Map;

public class AssertUtils {
    public AssertUtils() {
    }

    public static void isNull(Object object, IResponseStatusMsg resultCode, String message, Object... args) {
        if (object != null) {
            throw new APIRuntimeException(resultCode, StringSpliceUtils.splice(message, args));
        }
    }

    public static void isNull(Object object, IResponseStatusMsg resultCode) {
        if (object != null) {
            throw new APIRuntimeException(resultCode);
        }
    }

    public static void isNull(Object object, IResponseStatusMsg resultCode, String message) {
        if (object != null) {
            throw new APIRuntimeException(resultCode, message);
        }
    }

    public static void notNull(Object object, IResponseStatusMsg resultCode, String message, Object... args) {
        if (object == null) {
            throw new APIRuntimeException(resultCode, StringSpliceUtils.splice(message, args));
        }
    }

    public static void notNull(Object object, IResponseStatusMsg resultCode) {
        if (object == null) {
            throw new APIRuntimeException(resultCode);
        }
    }

    public static void notNull(Object object, IResponseStatusMsg resultCode, String message) {
        if (object == null) {
            throw new APIRuntimeException(resultCode, message);
        }
    }

    public static void notNull(Object object, Integer status, String message) {
        if (object == null) {
            throw new APIRuntimeException(status, message);
        }
    }

    public static void isTrue(boolean expression, IResponseStatusMsg resultCode, String message, Object... args) {
        if (!expression) {
            throw new APIRuntimeException(resultCode, StringSpliceUtils.splice(message, args));
        }
    }

    public static void isTrue(boolean expression, IResponseStatusMsg resultCode) {
        if (!expression) {
            throw new APIRuntimeException(resultCode);
        }
    }

    public static void isTrue(boolean expression, IResponseStatusMsg resultCode, String message) {
        if (!expression) {
            throw new APIRuntimeException(resultCode, message);
        }
    }

    public static void isTrue(boolean expression, Integer status, String message) {
        if (!expression) {
            throw new APIRuntimeException(status, message);
        }
    }

    public static <T> void notEmpty(Collection<T> collection, IResponseStatusMsg resultCode) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new APIRuntimeException(resultCode);
        }
    }

    public static <T> void notEmpty(Collection<T> collection, IResponseStatusMsg resultCode, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new APIRuntimeException(resultCode, message);
        }
    }

    public static <T> void notEmpty(Collection<T> collection, Integer status, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new APIRuntimeException(status, message);
        }
    }

    public static <K, V> void notEmpty(Map<K, V> map, IResponseStatusMsg resultCode) {
        if (CollectionUtils.isEmpty(map)) {
            throw new APIRuntimeException(resultCode);
        }
    }

    public static <K, V> void notEmpty(Map<K, V> map, IResponseStatusMsg resultCode, String message) {
        if (CollectionUtils.isEmpty(map)) {
            throw new APIRuntimeException(resultCode, message);
        }
    }

    public static <K, V> void notEmpty(Map<K, V> map, Integer status, String message) {
        if (CollectionUtils.isEmpty(map)) {
            throw new APIRuntimeException(status, message);
        }
    }

    public static void notEmpty(Object[] array, IResponseStatusMsg resultCode) {
        if (ArrayUtils.isEmpty(array)) {
            throw new APIRuntimeException(resultCode);
        }
    }

    public static void notEmpty(Object[] array, IResponseStatusMsg resultCode, String message) {
        if (ArrayUtils.isEmpty(array)) {
            throw new APIRuntimeException(resultCode, message);
        }
    }

    public static void notEmpty(Object[] array, Integer status, String message) {
        if (ArrayUtils.isEmpty(array)) {
            throw new APIRuntimeException(status, message);
        }
    }

    public static void isBlank(CharSequence cs, IResponseStatusMsg resultCode) {
        if (StringUtils.isNotBlank(cs)) {
            throw new APIRuntimeException(resultCode);
        }
    }

    public static void isBlank(CharSequence cs, IResponseStatusMsg resultCode, String message) {
        if (StringUtils.isNotBlank(cs)) {
            throw new APIRuntimeException(resultCode, message);
        }
    }

    public static void isBlank(CharSequence cs, Integer status, String message) {
        if (StringUtils.isNotBlank(cs)) {
            throw new APIRuntimeException(status, message);
        }
    }

    public static void notBlank(CharSequence cs, IResponseStatusMsg resultCode) {
        if (StringUtils.isBlank(cs)) {
            throw new APIRuntimeException(resultCode);
        }
    }

    public static void notBlank(CharSequence cs, IResponseStatusMsg resultCode, String message) {
        if (StringUtils.isBlank(cs)) {
            throw new APIRuntimeException(resultCode, message);
        }
    }

    public static void notBlank(CharSequence cs, Integer status, String message) {
        if (StringUtils.isBlank(cs)) {
            throw new APIRuntimeException(status, message);
        }
    }

    public static <T> void isEmpty(Collection<T> collection, IResponseStatusMsg resultCode) {
        if (CollectionUtils.isNotEmpty(collection)) {
            throw new APIRuntimeException(resultCode);
        }
    }

    public static <T> void isEmpty(Collection<T> collection, IResponseStatusMsg resultCode, String message) {
        if (CollectionUtils.isNotEmpty(collection)) {
            throw new APIRuntimeException(resultCode, message);
        }
    }

    public static <T> void isEmpty(Collection<T> collection, Integer status, String message) {
        if (CollectionUtils.isNotEmpty(collection)) {
            throw new APIRuntimeException(status, message);
        }
    }

    public static <K, V> void isEmpty(Map<K, V> map, IResponseStatusMsg resultCode) {
        if (CollectionUtils.isNotEmpty(map)) {
            throw new APIRuntimeException(resultCode);
        }
    }

    public static <K, V> void isEmpty(Map<K, V> map, IResponseStatusMsg resultCode, String message) {
        if (CollectionUtils.isNotEmpty(map)) {
            throw new APIRuntimeException(resultCode, message);
        }
    }

    public static <K, V> void isEmpty(Map<K, V> map, Integer status, String message) {
        if (CollectionUtils.isNotEmpty(map)) {
            throw new APIRuntimeException(status, message);
        }
    }

    public static void isEmpty(Object[] array, IResponseStatusMsg resultCode) {
        if (ArrayUtils.isNotEmpty(array)) {
            throw new APIRuntimeException(resultCode);
        }
    }

    public static void isEmpty(Object[] array, IResponseStatusMsg resultCode, String message) {
        if (ArrayUtils.isNotEmpty(array)) {
            throw new APIRuntimeException(resultCode, message);
        }
    }

    public static void isEmpty(Object[] array, Integer status, String message) {
        if (ArrayUtils.isNotEmpty(array)) {
            throw new APIRuntimeException(status, message);
        }
    }

    public static void equal(Integer val1, Integer val2, IResponseStatusMsg resultCode) {
        if (val1 == null) {
            if (val2 != null) {
                throw new APIRuntimeException(resultCode);
            }
        } else if (!val1.equals(val2)) {
            throw new APIRuntimeException(resultCode);
        }

    }

    public static void equal(Integer val1, Integer val2, IResponseStatusMsg resultCode, String message) {
        if (val1 == null) {
            if (val2 != null) {
                throw new APIRuntimeException(resultCode, message);
            }
        } else if (!val1.equals(val2)) {
            throw new APIRuntimeException(resultCode, message);
        }

    }

    public static void equal(Object val1, Object val2, IResponseStatusMsg resultCode) {
        if (val1 == null) {
            if (val2 != null) {
                throw new APIRuntimeException(resultCode);
            }
        } else if (!val1.equals(val2)) {
            throw new APIRuntimeException(resultCode);
        }

    }

    public static void equal(Object val1, Object val2, IResponseStatusMsg resultCode, String message) {
        if (val1 == null) {
            if (val2 != null) {
                throw new APIRuntimeException(resultCode, message);
            }
        } else if (!val1.equals(val2)) {
            throw new APIRuntimeException(resultCode, message);
        }

    }

    public static <T> void notContains(Collection<T> c, T e, IResponseStatusMsg resultCode) {
        if (!CollectionUtils.isEmpty(c)) {
            if (c.contains(e)) {
                throw new APIRuntimeException(resultCode);
            }
        }
    }

    public static <T> void notContains(Collection<T> c, T e, IResponseStatusMsg resultCode, String message) {
        if (!CollectionUtils.isEmpty(c)) {
            if (c.contains(e)) {
                throw new APIRuntimeException(resultCode, message);
            }
        }
    }

    public static <T> void contains(Collection<T> c, T e, IResponseStatusMsg resultCode) {
        if (CollectionUtils.isEmpty(c) || !c.contains(e)) {
            throw new APIRuntimeException(resultCode);
        }
    }

    public static <T> void contains(Collection<T> c, T e, IResponseStatusMsg resultCode, String message) {
        if (CollectionUtils.isEmpty(c) || !c.contains(e)) {
            throw new APIRuntimeException(resultCode, message);
        }
    }
}
