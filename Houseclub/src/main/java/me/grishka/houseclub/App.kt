package me.grishka.houseclub

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import me.grishka.appkit.utils.V
import me.grishka.houseclub.api.ClubhouseSession

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        V.setApplicationContext(context)
        ClubhouseSession.load()
    }

    companion object {
        // TODO: 메모리누수 고치기
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }
}
