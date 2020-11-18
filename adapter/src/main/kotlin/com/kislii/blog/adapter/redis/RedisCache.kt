package com.kislii.blog.adapter.redis

import redis.clients.jedis.Jedis

class RedisCache(private val redis: Jedis, private val name: String) : Cache {

    override fun put(key: String, value: String) {
        redis.hset(name, key, value)
    }

    override fun get(key: String): String? {
        return redis.hget(name, key)
    }
}
