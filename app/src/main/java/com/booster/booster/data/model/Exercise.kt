package com.booster.booster.data.model

import com.booster.booster.enums.TargetMuscle

data class Exercise(
    val id: Int,
    val name: String,
    val targetMuscle: TargetMuscle,
    val createdAt: String
)
