package com.example.setdone.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J&\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\t2\u0006\u0010\'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\tJ\u000e\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\tJ\u0006\u0010+\u001a\u00020#J\u000e\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u0007J\u0010\u0010.\u001a\u00020#2\b\u0010-\u001a\u0004\u0018\u00010\u0007J\u0006\u0010/\u001a\u00020#J\u0010\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020\tH\u0002J\u000e\u00102\u001a\u00020#2\u0006\u0010-\u001a\u00020\u0007J&\u00103\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\t2\u0006\u0010\'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\tR\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0019\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\r0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014\u00a8\u00064"}, d2 = {"Lcom/example/setdone/ui/viewmodel/WorkoutViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/setdone/data/repository/WorkoutRepository;", "(Lcom/example/setdone/data/repository/WorkoutRepository;)V", "_currentExercise", "Landroidx/compose/runtime/MutableState;", "Lcom/example/setdone/data/model/Exercise;", "_currentSet", "", "_editingExercise", "_exercises", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_isTimerRunning", "", "_timerValue", "currentExercise", "Landroidx/compose/runtime/State;", "getCurrentExercise", "()Landroidx/compose/runtime/State;", "currentSet", "getCurrentSet", "editingExercise", "getEditingExercise", "exercises", "Lkotlinx/coroutines/flow/StateFlow;", "getExercises", "()Lkotlinx/coroutines/flow/StateFlow;", "isTimerRunning", "timerJob", "Lkotlinx/coroutines/Job;", "timerValue", "getTimerValue", "addExercise", "", "name", "", "sets", "reps", "rest", "adjustTimer", "delta", "completeSet", "deleteExercise", "exercise", "setEditingExercise", "skipRest", "startTimer", "seconds", "startWorkout", "updateExercise", "app_debug"})
public final class WorkoutViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.setdone.data.repository.WorkoutRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.setdone.data.model.Exercise>> _exercises = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.setdone.data.model.Exercise>> exercises = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<com.example.setdone.data.model.Exercise> _currentExercise = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.State<com.example.setdone.data.model.Exercise> currentExercise = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.Integer> _currentSet = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.State<java.lang.Integer> currentSet = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.Integer> _timerValue = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.State<java.lang.Integer> timerValue = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.Boolean> _isTimerRunning = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.State<java.lang.Boolean> isTimerRunning = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<com.example.setdone.data.model.Exercise> _editingExercise = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.State<com.example.setdone.data.model.Exercise> editingExercise = null;
    @org.jetbrains.annotations.Nullable
    private kotlinx.coroutines.Job timerJob;
    
    public WorkoutViewModel(@org.jetbrains.annotations.NotNull
    com.example.setdone.data.repository.WorkoutRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.setdone.data.model.Exercise>> getExercises() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.State<com.example.setdone.data.model.Exercise> getCurrentExercise() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.State<java.lang.Integer> getCurrentSet() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.State<java.lang.Integer> getTimerValue() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.State<java.lang.Boolean> isTimerRunning() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.State<com.example.setdone.data.model.Exercise> getEditingExercise() {
        return null;
    }
    
    public final void addExercise(@org.jetbrains.annotations.NotNull
    java.lang.String name, int sets, int reps, int rest) {
    }
    
    public final void deleteExercise(@org.jetbrains.annotations.NotNull
    com.example.setdone.data.model.Exercise exercise) {
    }
    
    public final void setEditingExercise(@org.jetbrains.annotations.Nullable
    com.example.setdone.data.model.Exercise exercise) {
    }
    
    public final void updateExercise(@org.jetbrains.annotations.NotNull
    java.lang.String name, int sets, int reps, int rest) {
    }
    
    public final void startWorkout(@org.jetbrains.annotations.NotNull
    com.example.setdone.data.model.Exercise exercise) {
    }
    
    public final void completeSet() {
    }
    
    private final void startTimer(int seconds) {
    }
    
    public final void adjustTimer(int delta) {
    }
    
    public final void skipRest() {
    }
}