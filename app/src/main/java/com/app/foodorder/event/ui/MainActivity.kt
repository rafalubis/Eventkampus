package com.app.foodorder.event.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.app.foodorder.event.R
import com.app.foodorder.event.adapter.EventAdapter
import com.app.foodorder.event.data.EventRepository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }

        val listView = findViewById<ListView>(R.id.listView)

        val events = EventRepository.getEvents()
        val adapter = EventAdapter(this, events)

        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val eventId = events[position].id

            val intent = Intent(this, EventDetailActivity::class.java)
            intent.putExtra("EVENT_ID", eventId)
            startActivity(intent)

            overridePendingTransition(
                android.R.anim.slide_in_left,
                android.R.anim.slide_out_right
            )
        }
    }
}