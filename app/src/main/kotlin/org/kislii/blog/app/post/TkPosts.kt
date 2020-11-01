package org.kislii.blog.app.post

import org.kislii.blog.adapter.json.JsonArray
import org.kislii.blog.adapter.json.JsonObject
import org.kislii.blog.domain.post.Posts
import org.takes.Request
import org.takes.Response
import org.takes.Take
import org.takes.rs.RsText

class TkPosts(private val posts: Posts) : Take {

    override fun act(req: Request?): Response {
        val mediaCollection = JsonArray()
        posts.printed({ JsonObject() }, mediaCollection)
        return RsText(mediaCollection.asString())
    }
}
