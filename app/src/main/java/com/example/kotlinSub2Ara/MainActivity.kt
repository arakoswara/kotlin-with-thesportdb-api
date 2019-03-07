package com.example.kotlinSub2Ara

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.*
import com.example.kotlinSub2Ara.Adapter.EventAdapter
import com.example.kotlinSub2Ara.Model.Event
import com.example.kotlinSub2Ara.Presenter.EventPresenter
import com.example.myapplication.Api.ApiRepository
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(), EventView {
    private lateinit var eventAdapter: EventAdapter
    private lateinit var presenter: EventPresenter
    private lateinit var eventName: String
    private lateinit var target: String
    private lateinit var idTarget: String
    private val events: MutableList<Event> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        club_list.layoutManager = LinearLayoutManager(this)
        eventAdapter = EventAdapter(events, this) {
            startActivity<DetailEvent>(
                "idEvent" to it.idEvent
            )
        }
        club_list.adapter = eventAdapter

        val spinnerItem = arrayOf("Next Match", "Last Match")
        val spinnerAdapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_dropdown_item, spinnerItem)
        spinner.adapter = spinnerAdapter

        val request = ApiRepository()
        val gson = Gson()
        presenter = EventPresenter(this, request, gson)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                eventName = spinner.selectedItem.toString()

                if (eventName == "Next Match") {
                    target = BuildConfig.NEXT_MATCH
                    idTarget = "4328"
                }
                else
                {
                    target = BuildConfig.LAST_MATCH
                    idTarget = "4328"
                }

                presenter.getEventList(target, idTarget)
            }
        }
    }

    override fun showEventList(data: List<Event>) {
        events.clear()
        events.addAll(data)
        eventAdapter.notifyDataSetChanged()
    }
}
