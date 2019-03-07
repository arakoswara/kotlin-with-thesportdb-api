package com.example.kotlinSub2Ara

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinSub2Ara.Api.SportDbRepository
import com.example.kotlinSub2Ara.Model.Event
import com.example.kotlinSub2Ara.Model.TeamDetail
import com.example.kotlinSub2Ara.Presenter.DetailPresenter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_event.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailEvent : AppCompatActivity(), DetailView {

    private lateinit var presenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_event)

        val idEvent = intent.getStringExtra("idEvent")
        presenter = DetailPresenter(this)
        presenter.getDetail(idEvent)
    }

    override fun showDetail(data: Event) {

        val oldValue = "; "
        val oldValue2 = ";"
        val newValue = "\n"

        infoText.text = data.strLeague +" - "+data.strDate
        clubNameHome.text = data.strHomeTeam
        clubNameAway.text = data.strAwayTeam
        yellowHome.text = data.strHomeYellowCards.toString().replace(oldValue2, newValue)
        yellowAway.text = data.strAwayYellowCards.toString().replace(oldValue2, newValue)
        redHome.text = data.strHomeRedCards.toString().replace(oldValue2, newValue)
        redAway.text = data.strAwayRedCards.toString().replace(oldValue2, newValue)
        goalHome.text = data.strHomeGoalDetails.toString().replace(oldValue2, newValue)
        goalAway.text = data.strAwayGoalDetails.toString().replace(oldValue2, newValue)
        shotHome.text = data.intHomeShots.toString()
        shotAway.text = data.intAwayShots.toString()
        keeperHome.text = data.strHomeLineupGoalkeeper.toString().replace(oldValue, newValue)
        keeperAway.text = data.strAwayLineupGoalkeeper.toString().replace(oldValue, newValue)
        DefenderHome.text = data.strHomeLineupDefense.toString().replace(oldValue, newValue)
        DefenderAway.text = data.strAwayLineupDefense.toString().replace(oldValue, newValue)
        midFieldHome.text = data.strHomeLineupMidfield.toString().replace(oldValue, newValue)
        midFieldAway.text = data.strAwayLineupMidfield.toString().replace(oldValue, newValue)
        forwardHome.text = data.strHomeLineupForward.toString().replace(oldValue, newValue)
        forwardAway.text = data.strAwayLineupForward.toString().replace(oldValue, newValue)
        subHome.text = data.strHomeLineupSubstitutes.toString().replace(oldValue, newValue)
        subAway.text = data.strAwayLineupSubstitutes.toString().replace(oldValue, newValue)

        if (data.intHomeScore != null && data.intAwayScore != null) {
            score.text = data.intHomeScore +" : "+ data.intAwayScore
        }

        val sportDbRepository = SportDbRepository.create()
        sportDbRepository.getEvents(BuildConfig.DETAIL_TEAM+data.idHomeTeam).enqueue(object:
            Callback<TeamDetail> {
            override fun onFailure(call: Call<TeamDetail>, t: Throwable) {}

            override fun onResponse(call: Call<TeamDetail>, response: Response<TeamDetail>) {
                Picasso.get()
                    .load(response.body()!!.teams[0].strTeamBadge.toString())
                    .resize(100, 100)
                    .into(homeLogo)
            }
        })

        sportDbRepository.getEvents(BuildConfig.DETAIL_TEAM+data.idAwayTeam).enqueue(object:
            Callback<TeamDetail> {
            override fun onFailure(call: Call<TeamDetail>, t: Throwable) {}

            override fun onResponse(call: Call<TeamDetail>, response: Response<TeamDetail>) {
                Picasso.get()
                    .load(response.body()!!.teams[0].strTeamBadge.toString())
                    .resize(100, 100)
                    .into(logoAway)
            }
        })
    }
}
