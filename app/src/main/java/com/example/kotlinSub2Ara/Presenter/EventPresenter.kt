package com.example.kotlinSub2Ara.Presenter

import com.example.kotlinSub2Ara.EventView
import com.example.kotlinSub2Ara.Model.EventList
import com.example.myapplication.Api.ApiRepository
import com.example.myapplication.Api.TheSportDbApi
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class EventPresenter (private val view: EventView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson
) {

    fun getEventList(league: String?, idTarget: String) {
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(TheSportDbApi.getEvents(league, idTarget)),
                EventList::class.java
            )

            uiThread {
                view.showEventList(data.events)
            }
        }
    }
}