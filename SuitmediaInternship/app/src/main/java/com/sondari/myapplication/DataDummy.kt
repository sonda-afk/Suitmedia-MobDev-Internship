package com.sondari.myapplication

import com.sondari.myapplication.api.data.ModelEvent

object DataDummy {
    fun generateDataDummy(): List<ModelEvent> {
        val event = ArrayList<ModelEvent>()

        event.add(
            ModelEvent(
                "https://image.freepik.com/free-vector/music-event-poster-template-with-abstract-shapes_1361-1316.jpg",
                "Music Party",
                "11, 12, 13 July 2021"
            )

        )
        event.add(
            ModelEvent(
                "https://image.freepik.com/free-vector/modern-music-event-poster-template_1361-1292.jpg",
                "Music Event",
                "11 July 2021"
            )

        )
        event.add(
            ModelEvent(
                "https://image.freepik.com/free-vector/music-event-poster-template-with-colorful-shapes_1361-1591.jpg",
                "Electronic Sound Event",
                "24, 25 October 2021"
            )

        )
        event.add(
            ModelEvent(
                "https://image.freepik.com/free-vector/music-event-banner_1361-2405.jpg",
                "Quarantine Music Event",
                "11 April 2021"
            )

        )
        event.add(
            ModelEvent(
                "https://www.infobdg.com/v2/wp-content/uploads/2015/04/CB4Ve8XVEAAn4fV.jpg",
                "Ganesha Music Event",
                "11 April 2015"
            )

        )

        return event
    }
}