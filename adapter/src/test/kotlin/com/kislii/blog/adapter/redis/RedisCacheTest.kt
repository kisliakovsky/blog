package com.kislii.blog.adapter.redis

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.testcontainers.containers.GenericContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.utility.DockerImageName
import redis.clients.jedis.Jedis


@Testcontainers
internal class RedisCacheTest {

    companion object {
        @Container
        val redis : GenericContainer<*> = GenericContainer<Nothing>(DockerImageName.parse("redis:5.0.3-alpine"))
                .withExposedPorts(6379)
    }

    var cache : Cache = RedisCache(Jedis(redis.host, redis.firstMappedPort), "test")

    @Test
    fun `retrieves value from cache`() {
        // given
        cache.put("key", "value")

        // when / then
        assertThat(cache.get("key")).isEqualTo("value")
    }

}
