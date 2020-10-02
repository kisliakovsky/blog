package org.kislii.blog.adapter.json

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.ObjectNode
import com.fasterxml.jackson.databind.node.TextNode
import org.kislii.blog.domain.Media
import org.kislii.blog.domain.MediaCollection

class JsonMedia(private val objectMapper: ObjectMapper, private val objectNode: ObjectNode) : Media<ObjectNode> {

    constructor(objectMapper: ObjectMapper) : this(objectMapper, objectMapper.createObjectNode())

    constructor() : this(ObjectMapper())

    override fun with(key: String, value: String): Media<ObjectNode> {
        objectNode.put(key, value)
        return JsonMedia(objectMapper, objectNode.deepCopy())
    }

    override fun with(key: String, value: ObjectNode): Media<ObjectNode> {
        objectNode.set<ObjectNode>(key, value)
        return JsonMedia(objectMapper, objectNode.deepCopy())
    }

    override fun with(key: String, values: Collection<String>): Media<ObjectNode> {
        objectNode.set<ArrayNode>(
            key,
            objectMapper.createArrayNode()
                .addAll(
                    values.asSequence()
                        .map { TextNode(it) }
                        .toList()
                )
        )
        return JsonMedia(objectMapper, objectNode.deepCopy())
    }

    override fun with(key: String, value: Media<ObjectNode>): Media<ObjectNode> {
        return with(key, objectMapper.readValue(value.asString(), ObjectNode::class.java))
    }

    override fun with(key: String, collection: MediaCollection<ObjectNode>): Media<ObjectNode> {
        objectNode.set<ArrayNode>(
            key,
            objectMapper.createArrayNode()
                .addAll(objectMapper.readValue(collection.asString(), object : TypeReference<List<ObjectNode>>() {}))
        )
        return JsonMedia(objectMapper, objectNode.deepCopy())
    }

    override fun asString(): String {
        return objectNode.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as JsonMedia

        if (objectNode != other.objectNode) return false

        return true
    }

    override fun hashCode(): Int {
        return objectNode.hashCode()
    }
}
