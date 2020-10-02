package org.kislii.blog.domain

interface View {

    fun <T> printed(media: Media<T>): Media<T>
}
