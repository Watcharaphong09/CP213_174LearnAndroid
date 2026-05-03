package com.example.setdone.data.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.setdone.data.model.Exercise;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class WorkoutDao_Impl implements WorkoutDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Exercise> __insertionAdapterOfExercise;

  private final EntityDeletionOrUpdateAdapter<Exercise> __deletionAdapterOfExercise;

  private final EntityDeletionOrUpdateAdapter<Exercise> __updateAdapterOfExercise;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllExercises;

  public WorkoutDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfExercise = new EntityInsertionAdapter<Exercise>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `exercises` (`id`,`name`,`targetSets`,`targetReps`,`restTimeSeconds`,`isCompleted`,`createdAt`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Exercise entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        statement.bindLong(3, entity.getTargetSets());
        statement.bindLong(4, entity.getTargetReps());
        statement.bindLong(5, entity.getRestTimeSeconds());
        final int _tmp = entity.isCompleted() ? 1 : 0;
        statement.bindLong(6, _tmp);
        statement.bindLong(7, entity.getCreatedAt());
      }
    };
    this.__deletionAdapterOfExercise = new EntityDeletionOrUpdateAdapter<Exercise>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `exercises` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Exercise entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfExercise = new EntityDeletionOrUpdateAdapter<Exercise>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `exercises` SET `id` = ?,`name` = ?,`targetSets` = ?,`targetReps` = ?,`restTimeSeconds` = ?,`isCompleted` = ?,`createdAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Exercise entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        statement.bindLong(3, entity.getTargetSets());
        statement.bindLong(4, entity.getTargetReps());
        statement.bindLong(5, entity.getRestTimeSeconds());
        final int _tmp = entity.isCompleted() ? 1 : 0;
        statement.bindLong(6, _tmp);
        statement.bindLong(7, entity.getCreatedAt());
        statement.bindLong(8, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteAllExercises = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM exercises";
        return _query;
      }
    };
  }

  @Override
  public Object insertExercise(final Exercise exercise,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfExercise.insert(exercise);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteExercise(final Exercise exercise,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfExercise.handle(exercise);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateExercise(final Exercise exercise,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfExercise.handle(exercise);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllExercises(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllExercises.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAllExercises.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Exercise>> getAllExercises() {
    final String _sql = "SELECT * FROM exercises ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"exercises"}, new Callable<List<Exercise>>() {
      @Override
      @NonNull
      public List<Exercise> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfTargetSets = CursorUtil.getColumnIndexOrThrow(_cursor, "targetSets");
          final int _cursorIndexOfTargetReps = CursorUtil.getColumnIndexOrThrow(_cursor, "targetReps");
          final int _cursorIndexOfRestTimeSeconds = CursorUtil.getColumnIndexOrThrow(_cursor, "restTimeSeconds");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Exercise> _result = new ArrayList<Exercise>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Exercise _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmpTargetSets;
            _tmpTargetSets = _cursor.getInt(_cursorIndexOfTargetSets);
            final int _tmpTargetReps;
            _tmpTargetReps = _cursor.getInt(_cursorIndexOfTargetReps);
            final int _tmpRestTimeSeconds;
            _tmpRestTimeSeconds = _cursor.getInt(_cursorIndexOfRestTimeSeconds);
            final boolean _tmpIsCompleted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new Exercise(_tmpId,_tmpName,_tmpTargetSets,_tmpTargetReps,_tmpRestTimeSeconds,_tmpIsCompleted,_tmpCreatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getExerciseById(final int id, final Continuation<? super Exercise> $completion) {
    final String _sql = "SELECT * FROM exercises WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Exercise>() {
      @Override
      @Nullable
      public Exercise call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfTargetSets = CursorUtil.getColumnIndexOrThrow(_cursor, "targetSets");
          final int _cursorIndexOfTargetReps = CursorUtil.getColumnIndexOrThrow(_cursor, "targetReps");
          final int _cursorIndexOfRestTimeSeconds = CursorUtil.getColumnIndexOrThrow(_cursor, "restTimeSeconds");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final Exercise _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmpTargetSets;
            _tmpTargetSets = _cursor.getInt(_cursorIndexOfTargetSets);
            final int _tmpTargetReps;
            _tmpTargetReps = _cursor.getInt(_cursorIndexOfTargetReps);
            final int _tmpRestTimeSeconds;
            _tmpRestTimeSeconds = _cursor.getInt(_cursorIndexOfRestTimeSeconds);
            final boolean _tmpIsCompleted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _result = new Exercise(_tmpId,_tmpName,_tmpTargetSets,_tmpTargetReps,_tmpRestTimeSeconds,_tmpIsCompleted,_tmpCreatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
