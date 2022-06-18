package resp;

import utils.CompareUtils;

public interface IEnumItem<K, V> {
    K getCode();

    V getMessage();

    default boolean equalByCode(K code) {
        return CompareUtils.equals(this.getCode(), code);
    }
}
