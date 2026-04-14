package com.app.foodorder.event.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.app.foodorder.event.R
import com.app.foodorder.event.model.Event

class EventAdapter(
    private val context: Context,
    private val events: List<Event>
) : BaseAdapter() {

    override fun getCount(): Int = events.size

    override fun getItem(position: Int): Any = events[position]

    override fun getItemId(position: Int): Long = events[position].id.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.item_event, parent, false)

        val event = events[position]

        val img = view.findViewById<ImageView>(R.id.imgEvent)
        val nama = view.findViewById<TextView>(R.id.txtNama)
        val tanggal = view.findViewById<TextView>(R.id.txtTanggal)
        val lokasi = view.findViewById<TextView>(R.id.txtLokasi)

        img.setImageResource(event.imageResId)
        nama.text = event.namaEvent
        tanggal.text = event.tanggal
        lokasi.text = event.lokasi

        return view
    }
}