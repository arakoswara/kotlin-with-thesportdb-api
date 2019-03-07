package com.example.myapplication.Api

import android.net.Uri
import com.example.kotlinSub2Ara.BuildConfig

object TheSportDbApi {
    fun getEvents(league: String?, id: String?) : String {
        val urlAPi =  Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.TSDB_API_KEY)
            .appendPath(league)
            .appendQueryParameter("id", id)
            .build()
            .toString()

        return urlAPi
    }
}