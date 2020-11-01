package org.kislii.blog.app

import org.slf4j.Logger
import org.slf4j.Marker
import org.slf4j.event.Level
import org.slf4j.event.Level.ERROR
import org.slf4j.event.Level.INFO

class LoggerStub(private val name: String, private val logs: Map<Level, MutableList<String>>) : Logger {

    constructor(name: String) : this(
        name,
        mutableMapOf(
            INFO to mutableListOf(),
            ERROR to mutableListOf()
        )
    )

    override fun getName(): String {
        return name
    }

    override fun isTraceEnabled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isTraceEnabled(marker: Marker?): Boolean {
        TODO("Not yet implemented")
    }

    override fun trace(msg: String?) {
        TODO("Not yet implemented")
    }

    override fun trace(format: String?, arg: Any?) {
        TODO("Not yet implemented")
    }

    override fun trace(format: String?, arg1: Any?, arg2: Any?) {
        TODO("Not yet implemented")
    }

    override fun trace(format: String?, vararg arguments: Any?) {
        TODO("Not yet implemented")
    }

    override fun trace(msg: String?, t: Throwable?) {
        TODO("Not yet implemented")
    }

    override fun trace(marker: Marker?, msg: String?) {
        TODO("Not yet implemented")
    }

    override fun trace(marker: Marker?, format: String?, arg: Any?) {
        TODO("Not yet implemented")
    }

    override fun trace(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        TODO("Not yet implemented")
    }

    override fun trace(marker: Marker?, format: String?, vararg argArray: Any?) {
        TODO("Not yet implemented")
    }

    override fun trace(marker: Marker?, msg: String?, t: Throwable?) {
        TODO("Not yet implemented")
    }

    override fun isDebugEnabled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isDebugEnabled(marker: Marker?): Boolean {
        TODO("Not yet implemented")
    }

    override fun debug(msg: String?) {
        TODO("Not yet implemented")
    }

    override fun debug(format: String?, arg: Any?) {
        TODO("Not yet implemented")
    }

    override fun debug(format: String?, arg1: Any?, arg2: Any?) {
        TODO("Not yet implemented")
    }

    override fun debug(format: String?, vararg arguments: Any?) {
        TODO("Not yet implemented")
    }

    override fun debug(msg: String?, t: Throwable?) {
        TODO("Not yet implemented")
    }

    override fun debug(marker: Marker?, msg: String?) {
        TODO("Not yet implemented")
    }

    override fun debug(marker: Marker?, format: String?, arg: Any?) {
        TODO("Not yet implemented")
    }

    override fun debug(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        TODO("Not yet implemented")
    }

    override fun debug(marker: Marker?, format: String?, vararg arguments: Any?) {
        TODO("Not yet implemented")
    }

    override fun debug(marker: Marker?, msg: String?, t: Throwable?) {
        TODO("Not yet implemented")
    }

    override fun isInfoEnabled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isInfoEnabled(marker: Marker?): Boolean {
        TODO("Not yet implemented")
    }

    override fun info(msg: String?) {
        msg?.let { logs[INFO]?.add(it) }
    }

    override fun info(format: String?, arg: Any?) {
        TODO("Not yet implemented")
    }

    override fun info(format: String?, arg1: Any?, arg2: Any?) {
        TODO("Not yet implemented")
    }

    override fun info(format: String?, vararg arguments: Any?) {
        TODO("Not yet implemented")
    }

    override fun info(msg: String?, t: Throwable?) {
        TODO("Not yet implemented")
    }

    override fun info(marker: Marker?, msg: String?) {
        TODO("Not yet implemented")
    }

    override fun info(marker: Marker?, format: String?, arg: Any?) {
        TODO("Not yet implemented")
    }

    override fun info(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        TODO("Not yet implemented")
    }

    override fun info(marker: Marker?, format: String?, vararg arguments: Any?) {
        TODO("Not yet implemented")
    }

    override fun info(marker: Marker?, msg: String?, t: Throwable?) {
        TODO("Not yet implemented")
    }

    override fun isWarnEnabled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isWarnEnabled(marker: Marker?): Boolean {
        TODO("Not yet implemented")
    }

    override fun warn(msg: String?) {
        TODO("Not yet implemented")
    }

    override fun warn(format: String?, arg: Any?) {
        TODO("Not yet implemented")
    }

    override fun warn(format: String?, vararg arguments: Any?) {
        TODO("Not yet implemented")
    }

    override fun warn(format: String?, arg1: Any?, arg2: Any?) {
        TODO("Not yet implemented")
    }

    override fun warn(msg: String?, t: Throwable?) {
        TODO("Not yet implemented")
    }

    override fun warn(marker: Marker?, msg: String?) {
        TODO("Not yet implemented")
    }

    override fun warn(marker: Marker?, format: String?, arg: Any?) {
        TODO("Not yet implemented")
    }

    override fun warn(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        TODO("Not yet implemented")
    }

    override fun warn(marker: Marker?, format: String?, vararg arguments: Any?) {
        TODO("Not yet implemented")
    }

    override fun warn(marker: Marker?, msg: String?, t: Throwable?) {
        TODO("Not yet implemented")
    }

    override fun isErrorEnabled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isErrorEnabled(marker: Marker?): Boolean {
        TODO("Not yet implemented")
    }

    override fun error(msg: String?) {
        TODO("Not yet implemented")
    }

    override fun error(format: String?, arg: Any?) {
        TODO("Not yet implemented")
    }

    override fun error(format: String?, arg1: Any?, arg2: Any?) {
        TODO("Not yet implemented")
    }

    override fun error(format: String?, vararg arguments: Any?) {
        TODO("Not yet implemented")
    }

    override fun error(msg: String?, t: Throwable?) {
        msg?.let { logs[ERROR]?.add(it) }
    }

    override fun error(marker: Marker?, msg: String?) {
        TODO("Not yet implemented")
    }

    override fun error(marker: Marker?, format: String?, arg: Any?) {
        TODO("Not yet implemented")
    }

    override fun error(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        TODO("Not yet implemented")
    }

    override fun error(marker: Marker?, format: String?, vararg arguments: Any?) {
        TODO("Not yet implemented")
    }

    override fun error(marker: Marker?, msg: String?, t: Throwable?) {
        TODO("Not yet implemented")
    }

    fun containsInfo(msg: String): Boolean {
        return logs[INFO]?.contains(msg) == true
    }

    fun containsError(msg: String): Boolean {
        return logs[ERROR]?.contains(msg) == true
    }
}
