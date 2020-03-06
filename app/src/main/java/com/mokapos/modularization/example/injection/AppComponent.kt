package com.mokapos.modularization.example.injection

import com.mokapos.modularization.customer.module.CustomerModule
import com.mokapos.modularization.customer.ui.injection.CustomerComponent
import com.mokapos.modularization.network.module.NetworkModule
import dagger.Component

@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        NetworkExtensionModule::class
    ]
)
interface AppComponent {

}


@Component(
    modules = [
        CustomerModule::class,
        NetworkModule::class,
        NetworkExtensionModule::class
    ]
)
interface AppCustomerComponent : CustomerComponent