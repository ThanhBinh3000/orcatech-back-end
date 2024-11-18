package vn.com.gsoft.security.service;

import java.util.List;

public interface RedisListService {
    void addValueToListStart(String key, String value);

    void addValueToListEnd(String key, String value);

    List<String> getListValues(String key);

    void removeValueFromList(String key, String value);

    //Delete entire list based on key
    void deleteEntireList(String key);
}