package com.booster.booster.data

import com.booster.booster.data.model.Exercise
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TodayRoutineRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getTodayRoutine(): List<Exercise> = apiService.getTodayRoutine()
}