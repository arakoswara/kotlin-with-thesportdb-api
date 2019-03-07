package com.example.kotlinSub2Ara

import com.example.kotlinSub2Ara.Model.Event

interface EventView {
    fun showEventList(data: List<Event>)
}