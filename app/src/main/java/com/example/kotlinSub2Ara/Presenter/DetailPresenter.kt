package com.example.kotlinSub2Ara.Presenter

import com.example.kotlinSub2Ara.Api.SportDbRepository
import com.example.kotlinSub2Ara.BuildConfig
import com.example.kotlinSub2Ara.DetailView
import com.example.kotlinSub2Ara.Model.EventList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailPresenter (private val view: DetailView) {
    fun getDetail(id: String?) {
        val detail = view

        val sportDbRepository = SportDbRepository.create()
        sportDbRepository.getDetail(BuildConfig.DETAIL_MATCH+id).enqueue(object: Callback<EventList> {
            override fun onFailure(call: Call<EventList>, t: Throwable) {
            }

            override fun onResponse(call: Call<EventList>, response: Response<EventList>) {
                response.body()?.events?.get(0)?.let { detail.showDetail(it) }
            }
        })
    }
}