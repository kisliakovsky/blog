package org.kislii.blog.domain

interface MediaCollection<T> {

    fun with(media: Media<T>): MediaCollection<T>

    fun collection(collection: Collection<Media<T>>): MediaCollection<T>

    fun asString(): String
}
