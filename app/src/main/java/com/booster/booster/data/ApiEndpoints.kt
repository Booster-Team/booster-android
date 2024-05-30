package com.booster.booster.data

object ApiEndpoints {

    // 오늘 루틴
    const val todayRoutineGet = "/api/v1/routines/today"
    const val todayRoutineExerciseStateComplete = "/api/v1/routines/exercises/{exercise_id}/status?complete=true"
    const val todayRoutineStateComplete = "/api/v1/routines/{routine_id}/status?complete=true"
    const val todayRoutineBookmark = "/api/v1/routines/{routine_id}/bookmark?complete=true"
    const val todayRoutineRating = "/api/v1/routines/{routine_id}/rating"


    // 인증
    const val loginWithJoint = "/api/v1/auth/code/{provider}"
    const val logout = "/api/v1/auth/logout"
    const val refresh = "/api/v1/auth/refresh"


    // 유저
    const val memberInfoCheck = "/api/v1/members/{member-id}"
    const val memberInfoRemove = "/api/v1/members/{member-id}"
    const val memberInfoEdit = "/api/v1/members/{member-id}"
}