package com.muze.core.app.session.cluster;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;

import com.muze.core.app.redis.JedisManager;
import com.muze.core.app.utils.SerializeUtil;

/**
 * redis save shiro session class
 *
 * @author michael
 */
public class JedisShiroSessionRepository implements ShiroSessionRepository {

    private static final String REDIS_SHIRO_SESSION = "shiro-session:";
    private static final int DB_INDEX = 0;

    private JedisManager jedisManager;

    @Override
    public void saveSession(Session session) {
        if (session == null || session.getId() == null)
            throw new NullPointerException("session is empty");
        try {
            byte[] key = SerializeUtil.serialize(buildRedisSessionKey(session.getId()));
            byte[] value = SerializeUtil.serialize(session);
            long sessionTimeOut = session.getTimeout() / 1000;
            /*Long expireTime = sessionTimeOut + SESSION_VAL_TIME_SPAN + (5 * 60);*/
            Long expireTime=sessionTimeOut;
            getJedisManager().saveValueByKey(DB_INDEX, key, value, expireTime.intValue());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("save session error");
        }
    }

    @Override
    public void deleteSession(Serializable id) {
        if (id == null) {
            throw new NullPointerException("session id is empty");
        }
        try {
            getJedisManager().deleteByKey(DB_INDEX,
                    SerializeUtil.serialize(buildRedisSessionKey(id)));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("delete session error");
        }
    }

    @Override
    public Session getSession(Serializable id) {
        if (id == null)
            throw new NullPointerException("session id is empty");
        Session session = null;
        try {
            byte[] value = getJedisManager().getValueByKey(DB_INDEX, SerializeUtil
                    .serialize(buildRedisSessionKey(id)));
            session = SerializeUtil.deserialize(value, Session.class);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("get session error");
        }
        return session;
    }

    @Override
    public Collection<Session> getAllSessions() {
        //TODO
        System.out.println("get all sessions");
        return null;
    }

    private String buildRedisSessionKey(Serializable sessionId) {
        return REDIS_SHIRO_SESSION + sessionId;
    }

    public JedisManager getJedisManager() {
        return jedisManager;
    }

    public void setJedisManager(JedisManager jedisManager) {
        this.jedisManager = jedisManager;
    }
}
