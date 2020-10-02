package org.kislii.blog.domain.post

import org.kislii.blog.domain.Media
import org.kislii.blog.domain.View
import java.time.Instant

interface Post : View {

    fun id(): Long
    fun date(): Instant
    fun title(): String

    class FakePost(private val id: Long, private val date: Instant, private val title: String) : Post {

        override fun id(): Long {
            return id
        }

        override fun date(): Instant {
            return date
        }

        override fun title(): String {
            return title
        }

        override fun <T> printed(media: Media<T>): Media<T> {
            return media.with("id", id.toString())
                .with("date", date.toEpochMilli().toString())
                .with("title", title)
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as FakePost

            if (id != other.id) return false
            if (date != other.date) return false
            if (title != other.title) return false

            return true
        }

        override fun hashCode(): Int {
            var result = id.hashCode()
            result = 31 * result + date.hashCode()
            result = 31 * result + title.hashCode()
            return result
        }
    }
}
