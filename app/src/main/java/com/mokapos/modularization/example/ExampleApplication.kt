package com.mokapos.modularization.example

import android.app.Application
import android.util.Log
import com.mokapos.modularization.logger.Logger
import java.lang.Exception

class ExampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setupLogger()
        setupDagger()
    }

    private fun setupDagger() {

    }

    private fun setupLogger() {
        Logger.Setup.apply {
            addLogger(object : Logger.Setup.LogInterface {
                override fun onLog(
                    severity: Int,
                    tag: String,
                    message: String,
                    exception: Exception?
                ) {
                    when (severity) {
                        Logger.ERROR -> {
                            Log.e(tag, message, exception)
                        }
                        Logger.WARN -> {
                            Log.w(tag, message, exception)
                        }
                        Logger.INFO -> {
                            Log.i(tag, message, exception)
                        }
                        Logger.DEBUG -> {
                            Log.d(tag, message, exception)
                        }
                        Logger.VERBOSE -> {
                            Log.v(tag, message, exception)
                        }
                    }
                }
            })
        }
    }
}