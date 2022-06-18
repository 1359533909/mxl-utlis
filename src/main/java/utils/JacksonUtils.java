package utils;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import exception.APIRuntimeException;
import lombok.extern.slf4j.Slf4j;
import resp.IResponseStatusMsg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class JacksonUtils {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final ObjectMapper noneNullMapper = new ObjectMapper();
    public static final String ROOT_PATH = "$";
    private static final String ROOT_PATH_PRE = "$.";

    public JacksonUtils() {
    }

    private static void initDefaultFeature(ObjectMapper mapper) {
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
    }

    public static <T> String toJsonString(T obj) {
        return toJsonString(obj, true);
    }

    public static <T> String toJsonString(T obj, boolean includeNull) {
        ObjectMapper realMapper = includeNull ? mapper : noneNullMapper;

        try {
            return realMapper.writeValueAsString(obj);
        } catch (IOException var4) {
            log.error(var4.getMessage(), var4);
            throw new APIRuntimeException(IResponseStatusMsg.APIEnum.JSON_PARSE_FAILED);
        }
    }

    public static <T> T parseObject(String json, Class<T> clz) {
        try {
            return mapper.readValue(json, clz);
        } catch (IOException var3) {
            log.error(var3.getMessage(), var3);
            throw new APIRuntimeException(IResponseStatusMsg.APIEnum.JSON_PARSE_FAILED);
        }
    }

    public static <T> T parseObject(String json, TypeReference typeReference) {
        try {
            return (T) mapper.readValue(json, typeReference);
        } catch (IOException var3) {
            log.error(var3.getMessage(), var3);
            throw new APIRuntimeException(IResponseStatusMsg.APIEnum.JSON_PARSE_FAILED);
        }
    }

    public static <T> List<T> parseList(String json, Class<T> clz) {
        try {
            JavaType javaType = constructParametricType(ArrayList.class, clz);
            return (List)mapper.readValue(json, javaType);
        } catch (IOException var3) {
            log.error(var3.getMessage(), var3);
            throw new APIRuntimeException(IResponseStatusMsg.APIEnum.JSON_PARSE_FAILED);
        }
    }

    public static <K, V> Map<K, V> parseMap(String json, Class<K> keyClz, Class<V> valueClz) {
        try {
            JavaType javaType = constructParametricType(LinkedHashMap.class, keyClz, valueClz);
            return (Map)mapper.readValue(json, javaType);
        } catch (IOException var4) {
            log.error(var4.getMessage(), var4);
            throw new APIRuntimeException(IResponseStatusMsg.APIEnum.JSON_PARSE_FAILED);
        }
    }

    public static <K, V> Map<K, List<V>> parseMap4ListValue(String json, Class<K> keyClz, Class<V> elementValueClz) {
        try {
            JavaType javaType = constructParametricType(LinkedHashMap.class, constructType(keyClz), constructParametricType(ArrayList.class, elementValueClz));
            return (Map)mapper.readValue(json, javaType);
        } catch (IOException var4) {
            log.error("parse map 4 list exception:", var4);
            throw new APIRuntimeException(IResponseStatusMsg.APIEnum.JSON_PARSE_FAILED);
        }
    }

    public static <T> T[] parseArray(String json, Class<T> clz) {
        try {
            JavaType javaType = mapper.getTypeFactory().constructArrayType(clz);
            return (T[]) mapper.readValue(json, javaType);
        } catch (IOException var3) {
            log.error(var3.getMessage(), var3);
            throw new APIRuntimeException(IResponseStatusMsg.APIEnum.JSON_PARSE_FAILED);
        }
    }

    private static JavaType constructType(Class<?> rawType) {
        return mapper.getTypeFactory().constructType(rawType);
    }

    private static JavaType constructParametricType(Class<?> parametrized, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(parametrized, elementClasses);
    }

    private static JavaType constructParametricType(Class<?> rawType, JavaType... parameterTypes) {
        return mapper.getTypeFactory().constructParametricType(rawType, parameterTypes);
    }

    public static <T> T parseByPath(String json, String path, Class<T> clz) {
        JavaType javaType = mapper.getTypeFactory().constructType(clz);
        return parseByPath(json, path, javaType);
    }

    public static <T> T parseByPath(String json, String path, TypeReference<T> typeReference) {
        JavaType javaType = mapper.getTypeFactory().constructType(typeReference);
        return parseByPath(json, path, javaType);
    }

    public static <T> List<T> parseListByPath(String json, String path, Class<T> clz) {
        JavaType javaType = constructParametricType(ArrayList.class, clz);
        return (List)parseByPath(json, path, javaType);
    }

    public static <T> T[] parseArrayByPath(String json, String path, Class<T> clz) {
        JavaType javaType = mapper.getTypeFactory().constructArrayType(clz);
        return (T[]) parseByPath(json, path, (JavaType)javaType);
    }

    public static <K, V> Map<K, V> parseMapByPath(String json, String path, Class<K> keyClz, Class<V> valueClz) {
        JavaType javaType = constructParametricType(LinkedHashMap.class, keyClz, valueClz);
        return (Map)parseByPath(json, path, javaType);
    }

    public static <T> T parseByPath(String json, String path, JavaType javaType) {
        try {
            JsonNode node = readNodeByPath(json, path);
            return node == null ? null : mapper.readValue(mapper.treeAsTokens(node), javaType);
        } catch (IOException var4) {
            log.error(var4.getMessage(), var4);
            throw new APIRuntimeException(IResponseStatusMsg.APIEnum.JSON_PARSE_FAILED, var4);
        }
    }

    public static <T> T treeToValue(TreeNode treeNode, Class<T> clazz) {
        try {
            return mapper.treeToValue(treeNode, clazz);
        } catch (IOException var3) {
            log.error(var3.getMessage(), var3);
            throw new APIRuntimeException(IResponseStatusMsg.APIEnum.JSON_PARSE_FAILED, var3);
        }
    }

    public static ObjectNode createObjectNode() {
        return mapper.createObjectNode();
    }

    public static ArrayNode createArrayNode() {
        return mapper.createArrayNode();
    }

    private static JsonNode readNodeByPath(String json, String path) throws IOException {
        if (StringUtils.isEmpty(json)) {
            return null;
        } else {
            if (StringUtils.startsWith(path, "$.")) {
                path = path.substring("$.".length());
            }

            JsonNode node = mapper.readTree(json);
            if (!StringUtils.isEmpty(path) && !path.equals("$")) {
                String[] fieldsArray = path.split("\\.");
                if (!ArrayUtils.isEmpty(fieldsArray)) {
                    String[] var4 = fieldsArray;
                    int var5 = fieldsArray.length;

                    for(int var6 = 0; var6 < var5; ++var6) {
                        String field = var4[var6];
                        if (node == null) {
                            break;
                        }

                        node = node.get(field);
                    }
                }

                return node;
            } else {
                return node;
            }
        }
    }

    public static JsonNode readTree(String jsonStr) {
        try {
            return readNodeByPath(jsonStr, (String)null);
        } catch (Exception var2) {
            log.error(var2.getMessage(), var2);
            throw new APIRuntimeException(IResponseStatusMsg.APIEnum.JSON_PARSE_FAILED, var2);
        }
    }

    public static String constructPath(String... nodeNames) {
        return ArrayUtils.isEmpty(nodeNames) ? "$" : StringUtils.join(nodeNames, ".");
    }

    static {
        initDefaultFeature(mapper);
        initDefaultFeature(noneNullMapper);
        noneNullMapper.setSerializationInclusion(Include.NON_NULL);
    }
}
