package com.booster.booster.model

data class CalendarRoutineItem(
    val title: String,
    val rating: String,
    val count: Int,
    val done: Int,
    val sets: Int,
    val exerciseName: String,
    val booked: Boolean,
    val createdAt: String
)
