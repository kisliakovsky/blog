package org.kislii.blog.app

import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class JsonMediaCollectionTest {

    private val objectMapper: ObjectMapper = ObjectMapper()

    @Test
    fun returns_media_collection_with_new_media() {
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
    fun returns_json_array() {
        // when
        val jsonString = JsonMediaCollection().collection(listOf(JsonMedia().with("key", "value")))
            .asString()

        // then
        assertThat(jsonString)
            .isEqualTo("""[{"key":"value"}]""")
    }
}
