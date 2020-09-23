package org.kislii.blog.app

import org.takes.Request
import org.takes.Response
import org.takes.Take
import org.takes.facets.fork.FkRegex
import org.takes.facets.fork.TkFork

class WebServer(private val delegate: Take) : Take {

    constructor() : this(TkFork(FkRegex("/", "Hello, world!")))

    override fun act(req: Request?): Response {
        return delegate.act(req)
    }
}
