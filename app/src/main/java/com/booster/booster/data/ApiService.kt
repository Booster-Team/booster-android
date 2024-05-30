package com.booster.booster.data

import com.booster.booster.data.model.Exercise
import retrofit2.http.GET

interface ApiService {

    @GET(ApiEndpoints.todayRoutineGet)
    suspend fun getTodayRoutine(): List<Exercise>
}