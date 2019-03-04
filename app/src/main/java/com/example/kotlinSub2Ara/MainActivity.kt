package com.example.kotlinSub2Ara

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.ProgressBar
import com.example.kotlinSub2Ara.Api.SportDbRepository
import com.example.kotlinSub2Ara.Model.Event
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var listTeam : RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sportDbRepository = SportDbRepository.create()
        sportDbRepository.getEvents().enqueue(object: Callback<List<Event>> {
            override fun onFailure(call: Call<List<Event>>, t: Throwable) {
                Log.e("THROWABLE ", t.message)
            }

            override fun onResponse(call: Call<List<Event>>, response: Response<List<Event>>) {
                Log.d("RESPONSE ", response.message())
            }
        })
    }
}
