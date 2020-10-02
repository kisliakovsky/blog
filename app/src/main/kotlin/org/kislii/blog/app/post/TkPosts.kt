package org.kislii.blog.app.post

import org.kislii.blog.adapter.json.JsonMedia
import org.kislii.blog.adapter.json.JsonMediaCollection
import org.kislii.blog.domain.post.Posts
import org.takes.Request
import org.takes.Response
import org.takes.Take
import org.takes.rs.RsText

class TkPosts(private val posts: Posts) : Take {

    override fun act(req: Request?): Response {
        val mediaCollection = JsonMediaCollection()
        posts.printed({ JsonMedia() }, mediaCollection)
        return RsText(mediaCollection.asString())
    }
}
