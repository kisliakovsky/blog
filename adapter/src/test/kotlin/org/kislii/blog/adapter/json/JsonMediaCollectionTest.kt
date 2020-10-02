package org.kislii.blog.adapter.json

import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class JsonMediaCollectionTest {

    private val objectMapper: ObjectMapper = ObjectMapper()

    @Test
    fun `returns media_collection with new media`() {
        // when
        val collection = JsonMediaCollection().with(JsonMedia().with("key", "value"))

        // then
        assertThat(collection)
            .isEqualTo(
                JsonMediaCollection(
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
        val collection = JsonMediaCollection().collection(listOf(JsonMedia().with("key", "value")))

        // then
        assertThat(collection)
            .isEqualTo(
                JsonMediaCollection(
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
        val jsonString = JsonMediaCollection().collection(listOf(JsonMedia().with("key", "value")))
            .asString()

        // then
        assertThat(jsonString)
            .isEqualTo("""[{"key":"value"}]""")
    }
}
