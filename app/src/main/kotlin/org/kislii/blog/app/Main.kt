package org.kislii.blog.app

import org.slf4j.LoggerFactory

fun main() {
    VerboseApplication(
        BasicApplication(8080),
        LoggerFactory.getLogger("Main")
    ).start()
}
