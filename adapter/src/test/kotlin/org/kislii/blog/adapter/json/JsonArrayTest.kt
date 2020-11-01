package org.kislii.blog.adapter.json

import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class JsonArrayTest {

    private val objectMapper: ObjectMapper = ObjectMapper()

    @Test
    fun `returns media_collection with new media`() {
        // when
        val collection = JsonArray().with(JsonObject().with("key", "value"))

        // then
        assertThat(collection)
            .isEqualTo(
                JsonArray(
                    objectMapper,
                    objectMapper.createArrayNode()
                        .add(
                            objectMapper.createObjectNode()
                                .put("key", "value")
                        )
                )
            )
    }

    @Test
    fun returns_media_collection() {
        // when
        val collection = JsonArray().collection(listOf(JsonObject().with("key", "value")))

        // then
        assertThat(collection)
            .isEqualTo(
                JsonArray(
                    objectMapper,
                    objectMapper.createArrayNode()
                        .add(
                            objectMapper.createObjectNode()
                                .put("key", "value")
                        )
                )
            )
    }

    @Test
    fun `returns json array`() {
        // when
        val jsonString = JsonArray().collection(listOf(JsonObject().with("key", "value")))
            .asString()

        // then
        assertThat(jsonString)
            .isEqualTo("""[{"key":"value"}]""")
    }
}
