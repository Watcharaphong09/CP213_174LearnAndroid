package com.example.setdone.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercises")
data class Exercise(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val targetSets: Int,
    val targetReps: Int,
    val restTimeSeconds: Int,
    val isCompleted: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)
