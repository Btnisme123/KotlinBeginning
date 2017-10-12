package com.example.framgianguyenvulan.kotlinbeginning.application

import android.app.Application
import com.example.framgianguyenvulan.kotlinbeginning.delegate.DelegatesExt

/**
 * Created by FRAMGIA\nguyen.vu.lan on 12/10/2017.
 */
class App : Application() {

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()

    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}