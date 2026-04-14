package com.app.foodorder.event.ui

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.app.foodorder.event.R
import com.app.foodorder.event.data.EventRepository

class EventDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val eventId = intent.getIntExtra("EVENT_ID", -1)
        val event = EventRepository.getEventById(eventId)

        val img = findViewById<ImageView>(R.id.imgDetail)
        val nama = findViewById<TextView>(R.id.txtNamaDetail)
        val deskripsi = findViewById<TextView>(R.id.txtDeskripsi)
        val btn = findViewById<Button>(R.id.btnDaftar)
        val btnBack = findViewById<ImageButton>(R.id.btnBackDetail)

        btnBack.setOnClickListener {
            finish()
        }

        event?.let {
            img.setImageResource(it.imageResId)
            nama.text = it.namaEvent
            deskripsi.text = it.deskripsi
        }

        btn.setOnClickListener {
            Toast.makeText(this, "Berhasil daftar event!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}