package com.example.setdone.data.repository

import com.example.setdone.data.local.WorkoutDao
import com.example.setdone.data.model.Exercise
import kotlinx.coroutines.flow.Flow

class WorkoutRepository(private val workoutDao: WorkoutDao) {
    val allExercises: Flow<List<Exercise>> = workoutDao.getAllExercises()

    suspend fun getExerciseById(id: Int): Exercise? {
        return workoutDao.getExerciseById(id)
    }

    suspend fun insertExercise(exercise: Exercise) {
        workoutDao.insertExercise(exercise)
    }

    suspend fun updateExercise(exercise: Exercise) {
        workoutDao.updateExercise(exercise)
    }

    suspend fun deleteExercise(exercise: Exercise) {
        workoutDao.deleteExercise(exercise)
    }
}
