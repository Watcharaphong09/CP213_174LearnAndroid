package com.example.setdone.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\nH\'J\u001b\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/example/setdone/data/local/WorkoutDao;", "", "deleteAllExercises", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteExercise", "exercise", "Lcom/example/setdone/data/model/Exercise;", "(Lcom/example/setdone/data/model/Exercise;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllExercises", "Lkotlinx/coroutines/flow/Flow;", "", "getExerciseById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertExercise", "updateExercise", "app_debug"})
@androidx.room.Dao
public abstract interface WorkoutDao {
    
    @androidx.room.Query(value = "SELECT * FROM exercises ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.setdone.data.model.Exercise>> getAllExercises();
    
    @androidx.room.Query(value = "SELECT * FROM exercises WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getExerciseById(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.setdone.data.model.Exercise> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertExercise(@org.jetbrains.annotations.NotNull
    com.example.setdone.data.model.Exercise exercise, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateExercise(@org.jetbrains.annotations.NotNull
    com.example.setdone.data.model.Exercise exercise, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteExercise(@org.jetbrains.annotations.NotNull
    com.example.setdone.data.model.Exercise exercise, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM exercises")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteAllExercises(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}