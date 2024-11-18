package vn.com.gsoft.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import vn.com.gsoft.security.service.RedisListService;

import java.time.Duration;
import java.util.List;

@Service
public class RedisListServiceImpl implements RedisListService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Value("${cache.duration.default}")
    private int durationDefault;

    // Thêm giá trị vào đầu danh sách
    @Override
    public void addValueToListStart(String key, String value) {
        ListOperations<String, String> listOps = redisTemplate.opsForList();
        List<String> existingValues = listOps.range(key, 0, -1);
        if (!existingValues.contains(value)) {
            listOps.leftPush(key, value);
            redisTemplate.expire(key, Duration.ofMinutes(durationDefault));
        }
    }

    // Thêm giá trị vào cuối danh sách
    @Override
    public void addValueToListEnd(String key, String value) {
        ListOperations<String, String> listOps = redisTemplate.opsForList();
        List<String> existingValues = listOps.range(key, 0, -1);
        if (!existingValues.contains(value)) {
            listOps.rightPush(key, value);
            redisTemplate.expire(key, Duration.ofMinutes(durationDefault));
        }
    }

    // Lấy toàn bộ danh sách giá trị
    public List<String> getListValues(String key) {
        ListOperations<String, String> listOps = redisTemplate.opsForList();
        return listOps.range(key, 0, -1);
    }

    // Xóa một giá trị cụ thể từ danh sách
    @Override
    public void removeValueFromList(String key, String value) {
        ListOperations<String, String> listOps = redisTemplate.opsForList();
        listOps.remove(key, 1, value);
    }

    // Xóa toàn bộ danh sách dựa trên key
    @Override
    public void deleteEntireList(String key) {
        redisTemplate.delete(key);
    }
}