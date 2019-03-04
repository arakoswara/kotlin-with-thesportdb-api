package com.example.kotlinSub2Ara.Model

import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("events")
    var events: List<EventList>
)