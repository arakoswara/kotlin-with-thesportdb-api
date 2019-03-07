package com.example.kotlinSub2Ara.Api

import com.example.kotlinSub2Ara.Model.EventList
import com.example.kotlinSub2Ara.Model.TeamDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface SportDbService {
    @GET
    fun getEvents(@Url url: String): Call<TeamDetail>
    @GET
    fun getDetail(@Url url: String): Call<EventList>
}