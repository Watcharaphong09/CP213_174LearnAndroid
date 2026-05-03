package com.example.setdone.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.setdone.data.model.Exercise
import com.example.setdone.data.repository.WorkoutRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WorkoutViewModel(private val repository: WorkoutRepository) : ViewModel() {

    private val _exercises = MutableStateFlow<List<Exercise>>(emptyList())
    val exercises: StateFlow<List<Exercise>> = _exercises.asStateFlow()

    // Current Session State
    private val _currentExercise = mutableStateOf<Exercise?>(null)
    val currentExercise: State<Exercise?> = _currentExercise

    private val _currentSet = mutableStateOf(1)
    val currentSet: State<Int> = _currentSet

    private val _timerValue = mutableStateOf(0)
    val timerValue: State<Int> = _timerValue

    private val _isTimerRunning = mutableStateOf(false)
    val isTimerRunning: State<Boolean> = _isTimerRunning

    private val _editingExercise = mutableStateOf<Exercise?>(null)
    val editingExercise: State<Exercise?> = _editingExercise

    private var timerJob: Job? = null

    init {
        viewModelScope.launch {
            repository.allExercises.collect {
                _exercises.value = it
            }
        }
    }

    fun addExercise(name: String, sets: Int, reps: Int, rest: Int) {
        viewModelScope.launch {
            repository.insertExercise(Exercise(name = name, targetSets = sets, targetReps = reps, restTimeSeconds = rest))
        }
    }

    fun deleteExercise(exercise: Exercise) {
        viewModelScope.launch {
            repository.deleteExercise(exercise)
        }
    }

    fun setEditingExercise(exercise: Exercise?) {
        _editingExercise.value = exercise
    }

    fun updateExercise(name: String, sets: Int, reps: Int, rest: Int) {
        val exercise = _editingExercise.value ?: return
        viewModelScope.launch {
            repository.updateExercise(exercise.copy(
                name = name,
                targetSets = sets,
                targetReps = reps,
                restTimeSeconds = rest
            ))
            _editingExercise.value = null // Clear after update
        }
    }

    fun startWorkout(exercise: Exercise) {
        _currentExercise.value = exercise
        _currentSet.value = 1
        _isTimerRunning.value = false
    }

    fun completeSet() {
        val exercise = _currentExercise.value ?: return
        if (_currentSet.value < exercise.targetSets) {
            startTimer(exercise.restTimeSeconds)
        } else {
            // Workout Complete
            _currentSet.value += 1
        }
    }

    private fun startTimer(seconds: Int) {
        _timerValue.value = seconds
        _isTimerRunning.value = true
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            while (_timerValue.value > 0) {
                delay(1000)
                _timerValue.value -= 1
            }
            _isTimerRunning.value = false
            _currentSet.value += 1
        }
    }

    fun adjustTimer(delta: Int) {
        _timerValue.value = (_timerValue.value + delta).coerceAtLeast(0)
    }

    fun skipRest() {
        _timerValue.value = 0
        _isTimerRunning.value = false
        _currentSet.value += 1
        timerJob?.cancel()
    }
}
