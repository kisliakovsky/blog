package org.kislii.blog.domain.post

import org.kislii.blog.domain.Media
import org.kislii.blog.domain.MediaCollection
import org.kislii.blog.domain.Views
import java.util.function.Supplier

interface Posts : Views<Post> {

    class FakePosts(private val posts: Collection<Post>) : Posts {

        override fun sequence(): Sequence<Post> {
            return posts.asSequence()
        }

        override fun <U> printed(mediaSupplier: Supplier<Media<U>>, collection: MediaCollection<U>): MediaCollection<U> {
            return collection.collection(sequence().map { it.printed(mediaSupplier.get()) }.toList())
        }
    }
}
