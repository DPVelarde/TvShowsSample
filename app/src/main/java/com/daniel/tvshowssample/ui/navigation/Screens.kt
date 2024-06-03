package com.daniel.tvshowssample.ui.navigation

enum class Screens(
    val route: String
) {
    ShowsSchedule("showsschedule"),
    ShowDetail("detail/{id}"),
    ShowSearch("search"),
    ShowsDatePicker("datepicker")
}
