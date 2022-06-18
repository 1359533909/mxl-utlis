package utils;

import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionUtils {
    public CollectionUtils() {
    }

    public static <T> boolean isEmpty(Collection<T> collect) {
        return collect == null || collect.isEmpty();
    }

    public static <T> boolean isNotEmpty(Collection<T> collect) {
        return !isEmpty(collect);
    }

    public static <K, V> boolean isEmpty(Map<K, V> map) {
        return map == null || map.isEmpty();
    }

    public static <K, V> boolean isNotEmpty(Map<K, V> map) {
        return !isEmpty(map);
    }

    public static <T> T[] toArray(Collection<T> collect, Class<T[]> clazz) {
        if (collect == null) {
            throw null;
        } else if (clazz == null) {
            return null;
        } else {
            Object[] data = collect.toArray();
            return Arrays.copyOf(data, data.length, clazz);
        }
    }

    public static <T> boolean containsElement(Collection<T> collect, T elem) {
        return elem != null && !isEmpty(collect) ? collect.contains(elem) : false;
    }

    public static <T> boolean containsAny(Collection<T> c, T... es) {
        if (!ArrayUtils.isEmpty(es) && !isEmpty(c)) {
            Object[] var2 = es;
            int var3 = es.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                T e = (T) var2[var4];
                if (c.contains(e)) {
                    return true;
                }
            }

            return false;
        } else {
            return false;
        }
    }

    public static boolean containsAny(Collection coll1, Collection coll2) {
        return !isEmpty(coll1) && !isEmpty(coll2) ? org.apache.commons.collections.CollectionUtils.containsAny(coll1, coll2) : false;
    }

    public static <E> List<E> concatList(List<E>... array) {
        if (array != null && array.length >= 1) {
            List<E> newList = new ArrayList();
            List[] var2 = array;
            int var3 = array.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                List<E> e = var2[var4];
                if (isNotEmpty((Collection)e)) {
                    newList.addAll(e);
                }
            }

            return newList;
        } else {
            return Collections.emptyList();
        }
    }

    public static <T> void addIf(Collection<T> c, T e) {
        if (e != null) {
            c.add(e);
        }

    }

    public static <K, V> boolean putIf(Map<K, V> map, K key, V value) {
        if (value != null) {
            map.put(key, value);
            return true;
        } else {
            return false;
        }
    }

    public static int sizeOf(Collection<?> c) {
        return c == null ? 0 : c.size();
    }

    public static int sizeOf(Map<?, ?> m) {
        return m == null ? 0 : m.size();
    }

    public static <T> T getFirst(Collection<T> c) {
        if (isEmpty(c)) {
            return null;
        } else {
            Iterator<T> it = c.iterator();
            return it.hasNext() ? it.next() : null;
        }
    }

    public static <T> T getFirst(List<T> list) {
        return isEmpty((Collection)list) ? null : list.get(0);
    }

    public static <T> T getLast(List<T> list) {
        return isEmpty((Collection)list) ? null : list.get(list.size() - 1);
    }

    public static <E> Set<E> toSet(E... elements) {
        if (ArrayUtils.isEmpty(elements)) {
            return new HashSet();
        } else {
            Set<E> set = Sets.newHashSetWithExpectedSize(elements.length);
            if (ArrayUtils.isNotEmpty(elements)) {
                Collections.addAll(set, elements);
            }

            return set;
        }
    }

    public static <K, T> Map<K, T> toMap(Collection<T> c, Function<T, K> keyFunction) {
        if (isEmpty(c)) {
            return new HashMap();
        } else {
            Map<K, T> map = new HashMap();
            Iterator var3 = c.iterator();

            while(var3.hasNext()) {
                T t = (T) var3.next();
                K key = keyFunction.apply(t);
                map.put(key, t);
            }

            return map;
        }
    }

    public static <K, T> Map<K, List<T>> toListMap(Collection<T> c, Function<T, K> keyFunction) {
        if (isEmpty(c)) {
            return new HashMap();
        } else {
            Map<K, List<T>> map = new HashMap();
            Iterator var3 = c.iterator();

            while(var3.hasNext()) {
                T t = (T) var3.next();
                K key = keyFunction.apply(t);
                ((List)map.computeIfAbsent(key, (k) -> {
                    return new ArrayList();
                })).add(t);
            }

            return map;
        }
    }

    public static <T, V> Set<V> getFieldValues(Collection<T> c, Function<T, V> valueFunction) {
        return (Set)c.stream().map(valueFunction).collect(Collectors.toSet());
    }

    public static <E> List<E> removeNullElements(List<E> list) {
        if (isEmpty((Collection)list)) {
            return list;
        } else {
            list.removeIf(Objects::isNull);
            return list;
        }
    }

    public static int predictMapSize(int potentialKeyNum) {
        return potentialKeyNum <= 0 ? 0 : potentialKeyNum * 4 / 3 + 1;
    }
}
