package org.kislii.blog.app.post

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.kislii.blog.domain.post.Post.FakePost
import org.kislii.blog.domain.post.Posts.FakePosts
import org.takes.rs.RsText
import java.time.Instant

internal class TkPostsTest {

    @Test
    fun `returns posts as json array`() {
        // given
        val posts = FakePosts(
            listOf(
                FakePost(0, Instant.parse("2020-09-03T10:15:30.00Z"), "Hello, world!")
            )
        )

        // when
        val response = TkPosts(posts).act(null)

        // then
        assertThat(response)
            .isEqualTo(RsText("""[{"id":"0","date":"1599128130000","title":"Hello, world!"}]"""))
    }
}
