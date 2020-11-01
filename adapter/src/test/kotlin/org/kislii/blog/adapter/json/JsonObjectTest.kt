package org.kislii.blog.adapter.json

import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class JsonObjectTest {

    private val objectMapper: ObjectMapper = ObjectMapper()

    @Test
    fun `returns json media with new key value pair`() {
        // when
        val media = JsonObject().with("key", "value")

        // then
        assertThat(media)
            .isEqualTo(
                JsonObject(
                    objectMapper,
                    objectMapper.createObjectNode()
                        .put("key", "value")
                )
            )
    }

    @Test
    fun `returns json media with array of strings`() {
        // when
        val media = JsonObject().with("key", listOf("value1", "value2"))

        // then
        assertThat(media)
            .isEqualTo(
                JsonObject(
                    objectMapper,
                    objectMapper.createObjectNode()
                        .set("key", objectMapper.createArrayNode().add("value1").add("value2"))
                )
            )
    }

    @Test
    fun `returns json media with nested json`() {
        // when
        val media = JsonObject().with(
            "key",
            objectMapper.createObjectNode()
                .put("key", "value")
        )

        // then
        assertThat(media)
            .isEqualTo(
                JsonObject(
                    objectMapper,
                    objectMapper.createObjectNode()
                        .set(
                            "key",
                            objectMapper.createObjectNode()
                                .put("key", "value")
                        )
                )
            )
    }

    @Test
    fun `returns json media with nested json media`() {
        // when
        val media = JsonObject().with("key", JsonObject().with("key", "value"))

        // then
        assertThat(media)
            .isEqualTo(
                JsonObject(
                    objectMapper,
                    objectMapper.createObjectNode()
                        .set(
                            "key",
                            objectMapper.createObjectNode()
                                .put("key", "value")
                        )
                )
            )
    }

    @Test
    fun `returns json media with array of media`() {
        // when
        val media = JsonObject().with(
            "key",
            JsonArray()
                .collection(listOf(JsonObject().with("key", "value"), JsonObject().with("key", "value")))
        )

        // then
        assertThat(media)
            .isEqualTo(
                JsonObject(
                    objectMapper,
                    objectMapper.createObjectNode()
                        .set(
                            "key",
                            objectMapper.createArrayNode()
                                .add(
                                    objectMapper.createObjectNode()
                                        .put("key", "value")
                                )
                                .add(
                                    objectMapper.createObjectNode()
                                        .put("key", "value")
                                )
                        )
                )
            )
    }

    @Test
    fun `returns json string`() {
        // when
        val jsonString = JsonObject().with(
            "key",
            JsonArray()
                .collection(listOf(JsonObject().with("key", "value"), JsonObject().with("key", "value")))
        ).asString()

        // then
        assertThat(jsonString)
            .isEqualTo("""{"key":[{"key":"value"},{"key":"value"}]}""")
    }
}
