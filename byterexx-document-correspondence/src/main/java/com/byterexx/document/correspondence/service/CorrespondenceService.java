package com.byterexx.document.correspondence.service;

import java.util.Map;

public interface CorrespondenceService<T, K> {
    public static final String CREATE_CONFIGURATION = "CREATE_CONFIGURATION"; // 3 usages
    public static final String UPDATE_CONFIGURATION = "UPDATE_CONFIGURATION"; // 4 usages
    public static final String DELETE_CONFIGURATION = "DELETE_CONFIGURATION"; // 2 usages
    public static final String GET_CONFIGURATION = "GET_CONFIGURATION"; // 5 usages

    public static final String CREATE_TEMPLATE = "CREATE_TEMPLATE"; // 3 usages
    public static final String UPDATE_TEMPLATE = "UPDATE_TEMPLATE"; // 3 usages
    public static final String DELETE_TEMPLATE = "DELETE_TEMPLATE"; // 3 usages
    public static final String GET_TEMPLATE = "GET_TEMPLATE"; // 3 usages

    public static final String CREATE_CORRESPONDENCE = "CREATE_CORRESPONDENCE"; // 1 usage
    public static final String UPDATE_CORRESPONDENCE = "UPDATE_CORRESPONDENCE"; // 1 usage
    public static final String GET_CORRESPONDENCE = "GET_CORRESPONDENCE"; // 2 usages

    public static final String GET_AUDIT = "GET_AUDIT"; // 1 usage

    public K service(T request, Map<String, Object> parameters); // 8 implementations
}