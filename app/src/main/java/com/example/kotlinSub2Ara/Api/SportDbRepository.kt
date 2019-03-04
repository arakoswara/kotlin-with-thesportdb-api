package com.example.kotlinSub2Ara.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SportDbRepository {
    fun create(): SportDbService {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://www.thesportsdb.com")
            .build()
        return retrofit.create(SportDbService::class.java)
    }
}