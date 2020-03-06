package com.mokapos.modularization.customer.ui.injection

object CustomerInjector {
    lateinit var component: CustomerComponent

    fun performInjection(injection: (CustomerComponent) -> Unit) {
        injection.invoke(component)
    }
}