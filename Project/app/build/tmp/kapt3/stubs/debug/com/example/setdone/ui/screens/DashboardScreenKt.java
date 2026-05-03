package com.example.setdone.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001aF\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\nH\u0007\u001a@\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007\u00a8\u0006\u0012"}, d2 = {"BadgeChip", "", "text", "", "DashboardScreen", "viewModel", "Lcom/example/setdone/ui/viewmodel/WorkoutViewModel;", "onAddExercise", "Lkotlin/Function0;", "onEditExercise", "Lkotlin/Function1;", "Lcom/example/setdone/data/model/Exercise;", "onStartWorkout", "ExerciseCard", "exercise", "onStart", "onEdit", "onDelete", "app_debug"})
public final class DashboardScreenKt {
    
    @androidx.compose.runtime.Composable
    public static final void DashboardScreen(@org.jetbrains.annotations.NotNull
    com.example.setdone.ui.viewmodel.WorkoutViewModel viewModel, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onAddExercise, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.example.setdone.data.model.Exercise, kotlin.Unit> onEditExercise, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.example.setdone.data.model.Exercise, kotlin.Unit> onStartWorkout) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ExerciseCard(@org.jetbrains.annotations.NotNull
    com.example.setdone.data.model.Exercise exercise, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.example.setdone.data.model.Exercise, kotlin.Unit> onStart, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onEdit, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDelete) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void BadgeChip(@org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
}