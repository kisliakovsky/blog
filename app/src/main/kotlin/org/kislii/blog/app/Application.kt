package org.kislii.blog.app

import org.takes.http.Exit
import org.takes.http.FtBasic

class Application(private val port: Int, private val exit: Exit) {

    constructor(port: Int) : this(port, { false })

    fun start() {
        FtBasic(WebServer(), port)
            .start(exit)
    }
}

fun main() {
    Application(8080).start()
}
