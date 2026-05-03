package com.example.setdone.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a:\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007\u001a6\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007\u001a\u001e\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007\u001a\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0003\u00a8\u0006\u0016"}, d2 = {"RestTimerView", "", "timerValue", "", "totalRest", "onAdjust", "Lkotlin/Function1;", "onSkip", "Lkotlin/Function0;", "WorkoutCounterView", "exerciseName", "", "currentSet", "totalSets", "reps", "onDone", "WorkoutScreen", "viewModel", "Lcom/example/setdone/ui/viewmodel/WorkoutViewModel;", "onFinish", "formatTime", "seconds", "app_debug"})
public final class WorkoutScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.animation.ExperimentalAnimationApi.class})
    @androidx.compose.runtime.Composable
    public static final void WorkoutScreen(@org.jetbrains.annotations.NotNull
    com.example.setdone.ui.viewmodel.WorkoutViewModel viewModel, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onFinish) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void WorkoutCounterView(@org.jetbrains.annotations.NotNull
    java.lang.String exerciseName, int currentSet, int totalSets, int reps, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDone) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void RestTimerView(int timerValue, int totalRest, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onAdjust, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onSkip) {
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String formatTime(int seconds) {
        return null;
    }
}