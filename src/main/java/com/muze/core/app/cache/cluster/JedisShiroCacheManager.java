package com.muze.core.app.cache.cluster;

import org.apache.shiro.cache.Cache;
import org.springframework.beans.factory.annotation.Value;

import com.muze.core.app.redis.JedisManager;

/**
 * 这里的name是指自定义relm中的授权/认证的类名加上授权/认证英文名字
 *
 * @author michael
 */
public class JedisShiroCacheManager implements ShiroCacheManager {

    private JedisManager jedisManager;

    @Value("${muze.cache.timeout}")
    public String expireTime;
    
    @Override
    public <K, V> Cache<K, V> getCache(String name) {
        return new JedisShiroCache<K, V>(name, getJedisManager(),Integer.parseInt(expireTime));
    }

    @Override
    public void destroy() {
        getJedisManager().getJedis().shutdown();
    }

    public JedisManager getJedisManager() {
        return jedisManager;
    }

    public void setJedisManager(JedisManager jedisManager) {
        this.jedisManager = jedisManager;
    }
}
