package com.example.setdone.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.FastForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.setdone.ui.viewmodel.WorkoutViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun WorkoutScreen(
    viewModel: WorkoutViewModel,
    onFinish: () -> Unit
) {
    val exercise = viewModel.currentExercise.value ?: return
    val currentSet = viewModel.currentSet.value
    val isTimerRunning = viewModel.isTimerRunning.value
    val timerValue = viewModel.timerValue.value

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        AnimatedContent(
            targetState = isTimerRunning,
            modifier = Modifier.padding(padding),
            transitionSpec = {
                fadeIn(animationSpec = tween(500)) + scaleIn(initialScale = 0.9f) with
                        fadeOut(animationSpec = tween(500)) + scaleOut(targetScale = 1.1f)
            }
        ) { running ->
            if (running) {
                RestTimerView(
                    timerValue = timerValue,
                    totalRest = exercise.restTimeSeconds,
                    onAdjust = { viewModel.adjustTimer(it) },
                    onSkip = { viewModel.skipRest() }
                )
            } else {
                if (currentSet > exercise.targetSets) {
                    LaunchedEffect(Unit) {
                        onFinish()
                    }
                } else {
                    WorkoutCounterView(
                        exerciseName = exercise.name,
                        currentSet = currentSet,
                        totalSets = exercise.targetSets,
                        reps = exercise.targetReps,
                        onDone = { viewModel.completeSet() }
                    )
                }
            }
        }
    }
}

@Composable
fun WorkoutCounterView(
    exerciseName: String,
    currentSet: Int,
    totalSets: Int,
    reps: Int,
    onDone: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = exerciseName, 
            style = MaterialTheme.typography.headlineLarge, 
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 40.sp
        )
        Spacer(Modifier.height(64.dp))
        
        Card(
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(32.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(48.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("SET", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                Text(
                    "$currentSet / $totalSets", 
                    fontSize = 72.sp, 
                    fontWeight = FontWeight.Black,
                    color = MaterialTheme.colorScheme.onSurface
                )
                
                Spacer(Modifier.height(32.dp))
                Divider(color = MaterialTheme.colorScheme.surfaceVariant)
                Spacer(Modifier.height(32.dp))
                
                Text("REPS", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                Text(
                    "$reps", 
                    fontSize = 56.sp, 
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
        
        Spacer(Modifier.weight(1f))
        
        Button(
            onClick = onDone,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Icon(Icons.Default.Check, contentDescription = null, modifier = Modifier.size(32.dp))
            Spacer(Modifier.width(16.dp))
            Text("COMPLETE SET", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun RestTimerView(
    timerValue: Int,
    totalRest: Int,
    onAdjust: (Int) -> Unit,
    onSkip: () -> Unit
) {
    val progress by animateFloatAsState(
        targetValue = timerValue.toFloat() / totalRest.toFloat().coerceAtLeast(1f),
        animationSpec = tween(1000, easing = LinearEasing)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "REST", 
            style = MaterialTheme.typography.headlineLarge, 
            color = MaterialTheme.colorScheme.secondary,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 4.sp
        )
        Spacer(Modifier.height(64.dp))
        
        Box(contentAlignment = Alignment.Center, modifier = Modifier.size(280.dp)) {
            CircularProgressIndicator(
                progress = 1f,
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.surfaceVariant,
                strokeWidth = 16.dp,
                strokeCap = StrokeCap.Round
            )
            CircularProgressIndicator(
                progress = progress,
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.secondary,
                strokeWidth = 16.dp,
                strokeCap = StrokeCap.Round
            )
            Text(
                formatTime(timerValue),
                fontSize = 80.sp,
                fontWeight = FontWeight.Black,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        
        Spacer(Modifier.height(64.dp))
        
        Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
            FilledTonalButton(
                onClick = { onAdjust(-10) },
                shape = CircleShape,
                modifier = Modifier.size(80.dp),
                colors = ButtonDefaults.filledTonalButtonColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) { Text("-10", fontSize = 20.sp, fontWeight = FontWeight.Bold) }
            
            FilledTonalButton(
                onClick = { onAdjust(10) },
                shape = CircleShape,
                modifier = Modifier.size(80.dp),
                colors = ButtonDefaults.filledTonalButtonColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) { Text("+10", fontSize = 20.sp, fontWeight = FontWeight.Bold) }
        }
        
        Spacer(Modifier.weight(1f))
        
        OutlinedButton(
            onClick = onSkip,
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = MaterialTheme.colorScheme.onSurfaceVariant
            ),
            border = androidx.compose.foundation.BorderStroke(2.dp, MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Icon(Icons.Default.FastForward, contentDescription = null)
            Spacer(Modifier.width(12.dp))
            Text("SKIP REST", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }
}

fun formatTime(seconds: Int): String {
    val m = seconds / 60
    val s = seconds % 60
    return "%02d:%02d".format(m, s)
}
