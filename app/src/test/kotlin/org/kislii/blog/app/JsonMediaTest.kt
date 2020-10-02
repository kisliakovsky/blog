package org.kislii.blog.app

import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class JsonMediaTest {

    private val objectMapper: ObjectMapper = ObjectMapper()

    @Test
    fun returns_json_media_with_new_key_value_pair() {
        // when
        val media = JsonMedia().with("key", "value")

        // then
        assertThat(media)
            .isEqualTo(
                JsonMedia(
                    objectMapper,
                    objectMapper.createObjectNode()
                        .put("key", "value")
                )
            )
    }

    @Test
    fun returns_json_media_with_array_of_strings() {
        // when
        val media = JsonMedia().with("key", listOf("value1", "value2"))

        // then
        assertThat(media)
            .isEqualTo(
                JsonMedia(
                    objectMapper,
                    objectMapper.createObjectNode()
                        .set("key", objectMapper.createArrayNode().add("value1").add("value2"))
                )
            )
    }

    @Test
    fun returns_json_media_with_nested_json() {
        // when
        val media = JsonMedia().with(
            "key",
            objectMapper.createObjectNode()
                .put("key", "value")
        )

        // then
        assertThat(media)
            .isEqualTo(
                JsonMedia(
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
    fun returns_json_media_with_nested_json_media() {
        // when
        val media = JsonMedia().with("key", JsonMedia().with("key", "value"))

        // then
        assertThat(media)
            .isEqualTo(
                JsonMedia(
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
    fun returns_json_media_with_array_of_media() {
        // when
        val media = JsonMedia().with(
            "key",
            JsonMediaCollection()
                .collection(listOf(JsonMedia().with("key", "value"), JsonMedia().with("key", "value")))
        )

        // then
        assertThat(media)
            .isEqualTo(
                JsonMedia(
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
    fun returns_json_string() {
        // when
        val jsonString = JsonMedia().with(
            "key",
            JsonMediaCollection()
                .collection(listOf(JsonMedia().with("key", "value"), JsonMedia().with("key", "value")))
        ).asString()

        // then
        assertThat(jsonString)
            .isEqualTo("""{"key":[{"key":"value"},{"key":"value"}]}""")
    }
}
