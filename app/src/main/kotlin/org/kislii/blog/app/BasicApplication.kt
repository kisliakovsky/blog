package org.kislii.blog.app

import org.takes.http.Exit
import org.takes.http.FtBasic

class BasicApplication(private val port: Int, private val exit: Exit) : Application {

    constructor(port: Int) : this(port, { false })

    override fun start() {
        FtBasic(WebServer(), port)
            .start(exit)
    }
}
