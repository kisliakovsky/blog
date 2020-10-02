package org.kislii.blog.app.post

import org.kislii.blog.domain.post.Posts
import org.takes.facets.fork.FkRegex
import org.takes.facets.fork.FkWrap

class FkPosts(posts: Posts) : FkWrap(FkRegex("/posts", TkPosts(posts)))
