package com.byterexx.document.common.utils;

import com.byterexx.document.common.exception.DocumentErrorCode;
import com.byterexx.document.common.exception.DocumentGenericException;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Slf4j
@Component
public class JsonUtil {

    public static <T> T fromJson(String jsonString, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        T object = null;
        isMalformedJSON(jsonString);
        try {
            objectMapper.setSerializationInclusion(Include.NON_NULL);
            objectMapper.enable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
            objectMapper.enable(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE);
            objectMapper.enable(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY);
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            object = objectMapper.readValue(jsonString.getBytes(), clazz);
        } catch (Exception e) {
            throw new DocumentGenericException("Error while parsing json ", e, DocumentErrorCode.SYSTEM_ERROR);
        }
        return object;
    }

    public static <T> T fromJsonForFilters(String jsonString, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        T object = null;
        isMalformedJSON(jsonString);
        try {
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            object = objectMapper.readValue(jsonString.getBytes(), clazz);
        } catch (Exception e) {
            log.error("Error in fromJsonForFilters method ", e);
        }
        return object;
    }

    public static <T> String toJson(T object) { // no usages
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = null;
        try {
            objectMapper.setSerializationInclusion(Include.NON_NULL);
            jsonString = objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            throw new DocumentGenericException("Error while parsing json ", e, DocumentErrorCode.SYSTEM_ERROR);
        }
        return jsonString;
    }

    public static <T> String toJsonIgnoreNulls(T object) { // no usages
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = null;
        try {
            objectMapper.setSerializationInclusion(Include.NON_NULL);
            objectMapper.setSerializationInclusion(Include.NON_ABSENT);
            objectMapper.setSerializationInclusion(Include.NON_DEFAULT);
            objectMapper.setSerializationInclusion(Include.NON_EMPTY);
            jsonString = objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            throw new DocumentGenericException("Error while parsing json ", e, DocumentErrorCode.SYSTEM_ERROR);
        }
        return jsonString;
    }

    public static <T> String toJson(T object, boolean prettyPrint) {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = null;
        try {
            objectMapper.setSerializationInclusion(Include.NON_NULL);
            jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (IOException e) {
            throw new DocumentGenericException("Error while parsing json ", e, DocumentErrorCode.SYSTEM_ERROR);
        }
        return jsonString;
    }

    public static <T> List<T> fromJsonAsList(String jsonString, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<T> object = null;
        try {
            objectMapper.setSerializationInclusion(Include.NON_NULL);
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            objectMapper.disable(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE);
            objectMapper.enable(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY);
            objectMapper.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
            JavaType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);
            object = objectMapper.readValue(jsonString.getBytes(), listType);
        } catch (Exception e) {
            throw new DocumentGenericException("Error while parsing json ", e, DocumentErrorCode.SYSTEM_ERROR);
        }
        return object;
    }

    public static void isMalformedJSON(String jsonString) {  //2 usages
        try {
            int tokenCount = 0;
            final JsonParser parser = new JsonFactory().createParser(jsonString);
            while (parser.nextToken() != null) {
                tokenCount++;
            }
            log.debug("Token counts after parsing json string {}",tokenCount);
        } catch (IOException e) {
            throw new DocumentGenericException("Error while parsing json ", e, DocumentErrorCode.SYSTEM_ERROR);
        }
    }

}