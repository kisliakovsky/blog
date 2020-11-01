package org.kislii.blog.app

import org.slf4j.Logger

class VerboseApplication(private val application: Application, private val log: Logger) : Application {

    override fun start() {
        log.info("Starting application")
        try {
            application.start()
        } catch (e: Exception) {
            log.error("Failed to start application", e)
            throw e
        }
    }
}
