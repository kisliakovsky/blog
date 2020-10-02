package org.kislii.blog.app

import com.jcabi.http.request.JdkRequest
import com.jcabi.http.response.RestResponse
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test
import org.takes.http.FtRemote

internal class WebServerSpec {

    @Test
    fun `GET returns text page`() {
        FtRemote(WebServer())
            .exec { home ->
                JdkRequest(home)
                    .uri()
                    .path("/posts")
                    .back()
                    .fetch()
                    .`as`(RestResponse::class.java)
                    .assertStatus(200)
                    .assertBody(equalTo("""[{"id":"0","date":"1599128130000","title":"Hello, world!"}]"""))
            }
    }
}
