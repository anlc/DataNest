package com.data.nest.base

import android.app.Application
import android.content.Context

/**
 * Created by n on 2018/4/22.
 */
class CustomApplication : Application() {

    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}