package org.kislii.blog.domain

interface Media<T> {

    fun with(key: String, value: String): Media<T>

    fun with(key: String, values: Collection<String>): Media<T>

    fun with(key: String, value: T): Media<T>

    fun with(key: String, value: Media<T>): Media<T>

    fun with(key: String, collection: MediaCollection<T>): Media<T>

    fun asString(): String
}
