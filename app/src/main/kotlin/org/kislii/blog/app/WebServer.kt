package org.kislii.blog.app

import org.kislii.blog.app.post.FkPosts
import org.kislii.blog.domain.post.Post.FakePost
import org.kislii.blog.domain.post.Posts.FakePosts
import org.takes.facets.fork.TkFork
import org.takes.tk.TkWrap
import java.time.Instant

class WebServer : TkWrap(
    TkFork(
        FkPosts(
            FakePosts(
                listOf(
                    FakePost(0, Instant.parse("2020-09-03T10:15:30.00Z"), "Hello, world!")
                )
            )
        )
    )
)
