package com.booster.booster.data.model

data class ExerciseDetails(
    val id: Int,
    val exerciseId: Int,
    val routineId: Int,
    val name: String,
    val sets: Int,
    val repetitions: Int,
    val createdAt: String
)
