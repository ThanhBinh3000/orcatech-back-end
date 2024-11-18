package vn.com.gsoft.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import vn.com.gsoft.security.service.RedisListService;
import vn.com.gsoft.security.service.UserCacheService;

import java.util.List;

import static vn.com.gsoft.security.constant.CachingConstant.USER_TOKEN;

@Service
public class UserCacheServiceImpl implements UserCacheService {
    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private RedisListService redisListService;

    @Override
    public void clearCacheByUsername(String username) {
        List<String> tokens = redisListService.getListValues(username);
        tokens.forEach(token -> {
            String cacheKey = token + "-" + username;
            cacheManager.getCache(USER_TOKEN).evict(cacheKey);
        });
        redisListService.deleteEntireList(username);
    }
}