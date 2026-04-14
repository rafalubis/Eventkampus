package com.app.foodorder.event.data

import com.app.foodorder.event.R
import com.app.foodorder.event.model.Event

object EventRepository {

    private val events = listOf(
        Event(1, "Seminar AI", "PRODI", "10 Mei 2026", "Aula Kampus",
            "Seminar tentang AI terbaru", R.drawable.seminar, "Seminar"),

        Event(2, "Lomba Coding", "BEM", "15 Mei 2026", "Lab Komputer",
            "Kompetisi coding mahasiswa", R.drawable.lomba, "Lomba"),

        Event(3, "Workshop UI/UX", "Tim Software", "20 Mei 2026", "Ruang 301",
            "Belajar desain UI/UX", R.drawable.workshop, "Workshop"),

        Event(4, "Seminar Startup", "HIMA", "25 Mei 2026", "BTI",
            "Belajar membangun startup", R.drawable.startup, "Seminar")
    )

    fun getEvents(): List<Event> {
        return events
    }

    fun getEventById(id: Int): Event? {
        return events.find { it.id == id }
    }
}