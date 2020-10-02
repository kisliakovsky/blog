package org.kislii.blog.domain

import java.util.function.Supplier

interface Views<T> {

    fun sequence(): Sequence<View>

    fun <U> printed(mediaSupplier: Supplier<Media<U>>, collection: MediaCollection<U>): MediaCollection<U>
}
