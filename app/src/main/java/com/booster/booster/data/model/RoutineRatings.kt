package com.booster.booster.data.model

data class RoutineRatings(
    val id: Int,
    val userId: Int,
    val routineId: Int,
    val rating: Int,
    val createdAt: String
)
