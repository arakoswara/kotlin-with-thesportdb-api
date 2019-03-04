package com.example.kotlinSub2Ara.Api

import com.example.kotlinSub2Ara.Model.Event
import retrofit2.Call
import retrofit2.http.GET

interface SportDbService {
    @GET("/api/v1/json/1/eventsnextleague.php?id=4328")
    fun getEvents(): Call<List<Event>>
}