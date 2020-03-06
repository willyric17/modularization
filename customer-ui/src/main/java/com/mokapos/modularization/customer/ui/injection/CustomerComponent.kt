package com.mokapos.modularization.customer.ui.injection

import com.mokapos.modularization.customer.ui.activity.CustomerActivity

interface CustomerComponent {
    fun inject(activity: CustomerActivity)
}