package com.booster.booster.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.booster.booster.data.TodayRoutineRepository
import com.booster.booster.data.model.Exercise
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodayRoutineViewModel @Inject constructor(private val todayRoutineRepository: TodayRoutineRepository): ViewModel() {
    private val _exercise = mutableStateOf<List<Exercise>>(emptyList())
    val exercises: State<List<Exercise>> get () = _exercise

    fun getTodayRoutine() {
        viewModelScope.launch {
            _exercise.value = todayRoutineRepository.getTodayRoutine()
        }
    }
}