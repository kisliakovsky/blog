package org.kislii.blog.app

import com.jcabi.http.request.JdkRequest
import com.jcabi.http.response.RestResponse
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors.newSingleThreadExecutor

internal class ApplicationSpec {

    companion object {

        @BeforeAll
        @JvmStatic
        internal fun `set up`() {
            newSingleThreadExecutor().submit {
                Application(8080).start()
            }
        }
    }

    @Test
    fun `GET returns text page`() {
        JdkRequest("http://127.0.0.1:8080/posts")
            .fetch()
            .`as`(RestResponse::class.java)
            .assertStatus(200)
            .assertBody(equalTo("""[{"id":"0","date":"1599128130000","title":"Hello, world!"}]"""))
    }
}
