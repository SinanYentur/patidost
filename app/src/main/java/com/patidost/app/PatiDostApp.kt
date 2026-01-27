package com.patidost.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// Hilt'in doğru çalışması için bu sınıfın Application'dan miras alması ZORUNLUDUR.
@HiltAndroidApp
class PatiDostApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Başlangıç kodları buraya eklenebilir.
    }
}
