package org.kislii.blog.app

import com.jcabi.http.request.JdkRequest
import com.jcabi.http.response.RestResponse
import org.hamcrest.Matchers
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors.newSingleThreadExecutor

class ApplicationSpec {

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
        JdkRequest("http://127.0.0.1:8080")
            .fetch()
            .`as`(RestResponse::class.java)
            .assertStatus(200)
            .assertBody(Matchers.equalTo("Hello, world!"))
    }
}
