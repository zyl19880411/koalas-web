package com.muze.core.app.cache.cluster;

import java.util.Collection;
import java.util.Set;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

import com.muze.core.app.redis.JedisManager;
import com.muze.core.app.utils.SerializeUtil;

/**
 * redis shiro cache class
 *
 * @author michael
 */
public class JedisShiroCache<K, V> implements Cache<K, V> {

    private static final String REDIS_SHIRO_CACHE = "shiro-cache:";
    private static final int DB_INDEX = 1;
    //过期时间单位是秒
    private  int expireTime=0;

    private JedisManager jedisManager;

    private String name;

    public JedisShiroCache(String name, JedisManager jedisManager,int expireTime) {
        this.name = name;
        this.jedisManager = jedisManager;
        this.expireTime=expireTime;
    }

    /**
     * 自定义relm中的授权/认证的类名加上授权/认证英文名字
     */
    public String getName() {
        if (name == null)
            return "";
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @SuppressWarnings("unchecked")
    @Override
    public V get(K key) throws CacheException {
    	 System.out.println("get cache ");
        byte[] byteKey = SerializeUtil.serialize(buildCacheKey(key));
        byte[] byteValue = new byte[0];
        try {
            byteValue = jedisManager.getValueByKey(DB_INDEX, byteKey);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("get cache error");
        }
        return (V) SerializeUtil.deserialize(byteValue);
    }

    @Override
    public V put(K key, V value) throws CacheException {
        V previos = get(key);
        try {
        	  System.out.println("put cache ");
            jedisManager.saveValueByKey(DB_INDEX, SerializeUtil.serialize(buildCacheKey(key)),
                    SerializeUtil.serialize(value), expireTime);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("put cache error");
        }
        return previos;
    }

    @Override
    public V remove(K key) throws CacheException {
        V previos = get(key);
        try {
        	 System.out.println("remove cache ");
            jedisManager.deleteByKey(DB_INDEX, SerializeUtil.serialize(buildCacheKey(key)));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("remove cache error");
        }
        return previos;
    }

    @Override
    public void clear() throws CacheException {
        //TODO
    }

    @Override
    public int size() {
        if (keys() == null)
            return 0;
        return keys().size();
    }

    @Override
    public Set<K> keys() {
        //TODO
        return null;
    }

    @Override
    public Collection<V> values() {
        //TODO
        return null;
    }

    private String buildCacheKey(Object key) {
        return REDIS_SHIRO_CACHE + getName() + ":" + key;
    }

}
