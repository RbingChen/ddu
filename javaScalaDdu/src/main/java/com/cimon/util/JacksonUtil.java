package com.cimon.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.*;

public class JacksonUtil {
    private static ObjectMapper defaultObjectMapper = new ObjectMapper();

    public JacksonUtil() {
    }

    public static <T> T parseObject(String json, Class<T> clazz) {
        return parseObject((String)json, (Class<T>)clazz, (ObjectMapper)null);
    }

    public static <T> T parseObject(String json, Class<T> clazz, ObjectMapper objectMapper) {
        if (StringUtils.isBlank(json)) {
            return null;
        } else {
            try {
                return objectMapper == null ? defaultObjectMapper.readValue(json, clazz) : objectMapper.readValue(json, clazz);
            } catch (IOException var4) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static Map<String, Object> parseObject(String json) {
        if (StringUtils.isBlank(json)) {
            return Maps.newHashMap();
        } else {
            try {
                ObjectMapper mapper = new ObjectMapper();
                return (Map)mapper.readValue(json, Map.class);
            } catch (IOException var2) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static <T> T parseObject(JsonNode jsonNode, Class<T> clazz) {
        return parseObject((JsonNode)jsonNode, (Class<T>)clazz, (ObjectMapper)null);
    }

    public static <T> T parseObject(JsonNode jsonNode, Class<T> clazz, ObjectMapper objectMapper) {
        return objectMapper == null ? defaultObjectMapper.convertValue(jsonNode, clazz) : objectMapper.convertValue(jsonNode, clazz);
    }

    public static <T> T parseObject(String json, TypeReference<T> typeReference) {
        return parseObject((String)json, (TypeReference<T>)typeReference, (ObjectMapper)null);
    }

    public static <T> T parseObject(String json, TypeReference<T> typeReference, ObjectMapper objectMapper) {
        if (StringUtils.isBlank(json)) {
            return null;
        } else {
            try {
                return objectMapper == null ? defaultObjectMapper.readValue(json, typeReference) : objectMapper.readValue(json, typeReference);
            } catch (IOException var4) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static <T> T parseObject(String json, Type type) {
        return parseObject((String)json, (Type)type, (ObjectMapper)null);
    }

    public static <T> T parseObject(String json, Type type, ObjectMapper objectMapper) {
        if (StringUtils.isBlank(json)) {
            return null;
        } else {
            try {
                JavaType javaType = defaultObjectMapper.getTypeFactory().constructType(type);
                return objectMapper == null ? defaultObjectMapper.readValue(json, javaType) : objectMapper.readValue(json, javaType);
            } catch (IOException var4) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static <T> String toJSONString(T t) {
        return toJSONString(t, (ObjectMapper)null);
    }

    public static <T> String toJSONString(T t, ObjectMapper objectMapper) {
        if (Objects.isNull(t)) {
            return null;
        } else {
            try {
                return objectMapper == null ? defaultObjectMapper.writeValueAsString(t) : objectMapper.writeValueAsString(t);
            } catch (JsonProcessingException var3) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static String toJSONString(Object object, boolean prettyFormat) {
        String res = null;

        try {
            if (prettyFormat) {
                res = defaultObjectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
            } else {
                res = defaultObjectMapper.writeValueAsString(object);
            }

            return res;
        } catch (JsonProcessingException var4) {
            throw new IllegalArgumentException();
        }
    }

    public static JsonNode toJsonNode(String text) {
        JsonNode jsonNode = null;
        if (!StringUtils.isEmpty(text)) {
            try {
                jsonNode = defaultObjectMapper.readTree(text);
            } catch (IOException var3) {
                throw new IllegalArgumentException();
            }
        }

        return jsonNode;
    }

    public static ObjectNode toObjectNode(String text) {
        ObjectNode objectNode = null;
        if (!StringUtils.isEmpty(text)) {
            try {
                objectNode = (ObjectNode)defaultObjectMapper.readTree(text);
            } catch (IOException var3) {
                throw new IllegalArgumentException();
            }
        }

        return objectNode;
    }

    public static ObjectNode toObjectNode(Object object) {
        ObjectNode objectNode = null;
        objectNode = (ObjectNode)defaultObjectMapper.valueToTree(object);
        return objectNode;
    }

    public static ArrayNode toArrayNode(String text) {
        ArrayNode arrayNode = null;
        if (!StringUtils.isEmpty(text)) {
            try {
                arrayNode = (ArrayNode)defaultObjectMapper.readTree(text);
            } catch (IOException var3) {
                throw new IllegalArgumentException();
            }
        }

        return arrayNode;
    }

    public static ArrayNode toArrayNode(Object object) {
        ArrayNode arrayNode = (ArrayNode)defaultObjectMapper.valueToTree(object);
        return arrayNode;
    }

    public static <T> T fileToBean(File file, Class<T> clazz) {
        return fileToBean(file, clazz, (ObjectMapper)null);
    }

    public static <T> List<T> jsonToBeanList(String json, Class<T> clazz) {
        return jsonToBeanList(json, clazz, (ObjectMapper)null);
    }

    public static <T> List<T> jsonToBeanList(String json, Class<T> clazz, ObjectMapper objectMapper) {
        if (StringUtils.isBlank(json)) {
            return null;
        } else {
            try {
                JavaType javaType = defaultObjectMapper.getTypeFactory().constructParametricType(ArrayList.class, new Class[]{clazz});
                return objectMapper == null ? (List)defaultObjectMapper.readValue(json, javaType) : (List)objectMapper.readValue(json, javaType);
            } catch (IOException var4) {

                throw new IllegalArgumentException();
            }
        }
    }

    public static <T> Map<String, T> jsonToBeanMap(String json, Class<T> clazz) {
        return jsonToBeanMap(json, clazz, (ObjectMapper)null);
    }

    public static <T> Map<String, T> jsonToBeanMap(String json, Class<T> clazz, ObjectMapper objectMapper) {
        if (StringUtils.isBlank(json)) {
            return null;
        } else {
            try {
                JavaType javaType = defaultObjectMapper.getTypeFactory().constructParametricType(HashMap.class, new Class[]{String.class, clazz});
                return objectMapper == null ? (Map)defaultObjectMapper.readValue(json, javaType) : (Map)objectMapper.readValue(json, javaType);
            } catch (IOException var4) {

                throw new IllegalArgumentException();
            }
        }
    }

    public static <T> T fileToBean(File file, Class<T> clazz, ObjectMapper objectMapper) {
        if (!file.exists()) {
            return null;
        } else {
            try {
                return objectMapper == null ? defaultObjectMapper.readValue(file, clazz) : objectMapper.readValue(file, clazz);
            } catch (IOException var4) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static ArrayNode createArrayNode() {
        return defaultObjectMapper.createArrayNode();
    }

    public static ObjectNode createObjectNode() {
        return defaultObjectMapper.createObjectNode();
    }

    public static ObjectNode updateNodeValue(ObjectNode objectNode, String key) {
        return objectNode.get(key) == null ? objectNode : objectNode.put(key, objectNode.get(key).toString());
    }

    public static ObjectNode updateNode(ObjectNode objectNode) {
        Iterator it = objectNode.fieldNames();

        while(true) {
            String key;
            do {
                if (!it.hasNext()) {
                    return objectNode;
                }

                key = (String)it.next();
            } while(!(objectNode.get(key) instanceof ObjectNode) && !(objectNode.get(key) instanceof ArrayNode));

            if (objectNode.get(key) != null) {
                objectNode.put(key, objectNode.get(key).toString());
            }
        }
    }

    public static ObjectNode updateNodeTimeValue(ObjectNode objectNode, String key) {
        if (objectNode.get(key) == null) {
            return objectNode;
        } else {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            try {
                return StringUtils.isBlank(objectNode.get(key).asText()) ? null : objectNode.put(key, format.parse(objectNode.get(key).asText()).getTime());
            } catch (Exception var4) {

                throw new RuntimeException(var4);
            }
        }
    }

    public static ArrayNode updateNodeTimeValue(ArrayNode arrayNode, String key) {
        if (arrayNode.get(key) == null) {
            return arrayNode;
        } else {
            ArrayNode newArrayNode = createArrayNode();
            Iterator it = arrayNode.iterator();

            while(it.hasNext()) {
                try {
                    if (StringUtils.isBlank(arrayNode.get(key).asText())) {
                        return null;
                    }

                    newArrayNode.add(updateNodeTimeValue((ObjectNode)it.next(), key));
                } catch (Exception var5) {

                    throw new RuntimeException(var5);
                }
            }

            return newArrayNode;
        }
    }

    static {
        defaultObjectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        defaultObjectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        defaultObjectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        defaultObjectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        defaultObjectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        defaultObjectMapper.disable(new JsonParser.Feature[]{JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES});
        defaultObjectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        defaultObjectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        defaultObjectMapper.enable(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS);
        defaultObjectMapper.enable(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS);
    }
}
