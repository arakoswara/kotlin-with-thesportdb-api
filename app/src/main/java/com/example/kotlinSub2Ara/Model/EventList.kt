package com.example.kotlinSub2Ara.Model

import com.google.gson.annotations.SerializedName

class EventList {
    @SerializedName("idEvent")
    var idEvent: String? = null
    @SerializedName("idSoccerXML")
    var idSoccerXML: String? = null
    @SerializedName("strEvent")
    var strEvent: String? = null
    @SerializedName("strSport")
    var strSport: String? = null
    @SerializedName("idLeague")
    var idLeague: String? = null
    @SerializedName("strLeague")
    var strLeague: String? = null
    @SerializedName("strSeason")
    var strSeason: String? = null
    @SerializedName("strHomeTeam")
    var strHomeTeam: String? = null
    @SerializedName("strAwayTeam")
    var strAwayTeam: String? = null
    @SerializedName("intHomeScore")
    var intHomeScore: Any? = null
    @SerializedName("intRound")
    var intRound: String? = null
    @SerializedName("dateEvent")
    var dateEvent: String? = null
    @SerializedName("strDate")
    var strDate: String? = null
    @SerializedName("strTime")
    var strTime: String? = null
    @SerializedName("idHomeTeam")
    var idHomeTeam: String? = null
    @SerializedName("idAwayTeam")
    var idAwayTeam: String? = null
}