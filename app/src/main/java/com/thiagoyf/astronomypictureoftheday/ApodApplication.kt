package com.thiagoyf.astronomypictureoftheday

import android.app.Application
import com.thiagoyf.core_data.di.DataDI
import com.thiagoyf.core_network.di.NetworkDI
import com.thiagoyf.feature_apod.di.FeatureApodDI
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ApodApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        koinInit()
    }

    private fun koinInit() {
        startKoin {
            androidContext(this@ApodApplication)
            modules(
                DataDI.module +
                        NetworkDI.module +
                        FeatureApodDI.module
            )
        }
    }
}