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
                    .fetch()
                    .`as`(RestResponse::class.java)
                    .assertStatus(200)
                    .assertBody(equalTo("Hello, world!"))
            }
    }
}
