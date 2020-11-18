package com.kislii.blog.adapter.redis

interface Cache {

    fun put(key: String, value: String)

    fun get(key: String) : String?
}
