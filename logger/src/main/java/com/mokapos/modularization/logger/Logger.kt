package com.mokapos.modularization.logger

import java.lang.Exception

object Logger {
    const val ERROR = 6
    const val WARN = 5
    const val INFO = 4
    const val DEBUG = 3
    const val VERBOSE = 2

    internal val loggers = ArrayList<Setup.LogInterface>()

    private fun log(severity: Int, tag: String, message: String, exception: Exception? = null) {
        loggers.forEach {
            it.onLog(severity, tag, message, exception)
        }
    }

    @JvmStatic
    fun v(tag: String, message: String) {
        log(VERBOSE, tag, message)
    }

    @JvmStatic
    fun d(tag: String, message: String) {
        log(DEBUG, tag, message)
    }

    @JvmStatic
    fun i(tag: String, message: String) {
        log(INFO, tag, message)
    }

    @JvmStatic
    fun w(tag: String, message: String) {
        log(WARN, tag, message)
    }

    @JvmOverloads
    @JvmStatic
    fun e(tag: String, message: String, exception: Exception? = null) {
        log(ERROR, tag, message, exception)
    }

    object Setup {
        fun addLogger(logInterface: LogInterface) {
            loggers.add(logInterface)
        }

        interface LogInterface {
            fun onLog(severity: Int, tag: String, message: String, exception: Exception?)
        }
    }
}
