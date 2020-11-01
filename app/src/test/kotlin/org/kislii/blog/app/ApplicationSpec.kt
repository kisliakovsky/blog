package org.kislii.blog.app

import com.jcabi.http.request.JdkRequest
import com.jcabi.http.response.RestResponse
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import java.util.concurrent.Executors.newSingleThreadExecutor

@TestInstance(PER_CLASS)
internal class ApplicationSpec {

    init {
        newSingleThreadExecutor().execute {
            BasicApplication(8080).start()
        }
        Thread.sleep(50)
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
