package org.kislii.blog.app

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class VerboseApplicationTest {

    private val log: LoggerStub = LoggerStub("test_logger")

    @Test
    fun `logs application start`() {
        // given
        val application: Application = VerboseApplication(
            object : Application {
                override fun start() {}
            },
            log
        )

        // when
        application.start()

        // then
        log.containsInfo("Starting application")
    }

    @Test
    fun `rethrows application start exception and logs it`() {
        // given
        val application: Application = VerboseApplication(
            object : Application {
                override fun start() {
                    throw RuntimeException()
                }
            },
            log
        )

        // when / then
        assertThatThrownBy { application.start() }
            .isInstanceOf(RuntimeException::class.java)
        log.containsError("Failed to start application")
    }
}
