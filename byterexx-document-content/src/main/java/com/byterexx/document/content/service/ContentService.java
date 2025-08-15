package com.byterexx.document.content.service;

import java.util.Map;

public interface ContentService<T, K> {
    public static final String CREATE_CONTENT = "CREATE_CONTENT";
    public static final String UPDATE_CONTENT = "UPDATE_CONTENT";
    public static final String DELETE_CONTENT = "DELETE_CONTENT";
    public static final String GET_CONTENT = "GET_CONTENT";

    public K service(T request, Map<String, Object> parameters);
}
