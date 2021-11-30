package com.cimon.framework.common;


import java.util.*;
import com.google.common.base.Strings;

public class FieldContext  {
    Map<String,Object> fieldContext;
    public FieldContext(){
        fieldContext = new HashMap();
    }
    public boolean isEmpty(){
        return fieldContext.isEmpty();
    }

    public boolean containsKey(String key) {
        return fieldContext.containsKey(key);
    }

    public Object get(String key) {
        return fieldContext.get(key);
    }

    public Object put(String key, Object value) {
        return fieldContext.put(key,value);
    }

    public void remove(String key) {
        if(!Strings.isNullOrEmpty(key)&fieldContext.containsKey(key))
            fieldContext.remove(key);
    }

    public void putAll(Map<? extends String, Object> m) {
        fieldContext.putAll(m);
    }

    public void clear() {
    }

    public Set<String> keySet() {
        return fieldContext.keySet();
    }

    public int size(){
        return fieldContext.size();
    }
}
