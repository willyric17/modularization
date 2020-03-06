package com.mokapos.modularization.customer.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.mokapos.modularization.customer.ui.injection.CustomerInjector
import com.mokapos.modularization.customer.usecase.CustomerUsecase
import javax.inject.Inject

class CustomerActivity() : AppCompatActivity() {
    @Inject
    lateinit var customerUsecase: CustomerUsecase

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        CustomerInjector.performInjection { it.inject(this) }
    }
}