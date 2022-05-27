package com.ydp.gateway.filters;

public class BaseContextHandler {
    private static final ThreadLocal<Object> threadContext = new ThreadLocal<>();

    private BaseContextHandler() {

    }

    /**
     * 取得thread context Map的实例。
     *
     * @return thread context Map的实例
     */
    public static Object getContextMap() {
        return threadContext.get();
    }
    public static void setContextMap(Object object) {
        threadContext.set(object);
    }
    public static void remove() {
        threadContext.remove();
    }
}
