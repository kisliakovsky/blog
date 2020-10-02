package org.kislii.blog.app

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.ObjectNode
import org.kislii.blog.domain.Media
import org.kislii.blog.domain.MediaCollection

class JsonMediaCollection(private val objectMapper: ObjectMapper, private val arrayNode: ArrayNode) : MediaCollection<ObjectNode> {

    constructor(objectMapper: ObjectMapper) : this(objectMapper, objectMapper.createArrayNode())

    constructor() : this(ObjectMapper())

    override fun with(media: Media<ObjectNode>): MediaCollection<ObjectNode> {
        arrayNode.add(objectMapper.readValue(media.asString(), ObjectNode::class.java))
        return JsonMediaCollection(objectMapper, arrayNode.deepCopy())
    }

    override fun collection(collection: Collection<Media<ObjectNode>>): MediaCollection<ObjectNode> {
        var c: MediaCollection<ObjectNode> = this
        collection.asSequence()
            .forEach { c = c.with(it) }
        return c
    }

    override fun asString(): String {
        return arrayNode.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as JsonMediaCollection

        if (arrayNode != other.arrayNode) return false

        return true
    }

    override fun hashCode(): Int {
        return arrayNode.hashCode()
    }
}
