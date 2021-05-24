package com.taetae98.iip.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.taetae98.iip.dto.Exercise;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ExerciseDao_Impl implements ExerciseDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Exercise> __insertionAdapterOfExercise;

  private final EntityDeletionOrUpdateAdapter<Exercise> __deletionAdapterOfExercise;

  private final EntityDeletionOrUpdateAdapter<Exercise> __updateAdapterOfExercise;

  public ExerciseDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfExercise = new EntityInsertionAdapter<Exercise>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Exercise` (`id`,`name`,`tip`,`image1`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Exercise value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getTip() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTip());
        }
        stmt.bindLong(4, value.getImage1());
      }
    };
    this.__deletionAdapterOfExercise = new EntityDeletionOrUpdateAdapter<Exercise>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Exercise` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Exercise value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfExercise = new EntityDeletionOrUpdateAdapter<Exercise>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Exercise` SET `id` = ?,`name` = ?,`tip` = ?,`image1` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Exercise value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getTip() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTip());
        }
        stmt.bindLong(4, value.getImage1());
        stmt.bindLong(5, value.getId());
      }
    };
  }

  @Override
  public void insert(final Exercise... arg) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfExercise.insert(arg);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Exercise... arg) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfExercise.handleMultiple(arg);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Exercise... arg) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfExercise.handleMultiple(arg);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Exercise>> select() {
    final String _sql = "SELECT * FROM Exercise";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Exercise"}, false, new Callable<List<Exercise>>() {
      @Override
      public List<Exercise> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfTip = CursorUtil.getColumnIndexOrThrow(_cursor, "tip");
          final int _cursorIndexOfImage1 = CursorUtil.getColumnIndexOrThrow(_cursor, "image1");
          final List<Exercise> _result = new ArrayList<Exercise>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Exercise _item;
            _item = new Exercise();
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            _item.setName(_tmpName);
            final String _tmpTip;
            if (_cursor.isNull(_cursorIndexOfTip)) {
              _tmpTip = null;
            } else {
              _tmpTip = _cursor.getString(_cursorIndexOfTip);
            }
            _item.setTip(_tmpTip);
            final int _tmpImage1;
            _tmpImage1 = _cursor.getInt(_cursorIndexOfImage1);
            _item.setImage1(_tmpImage1);
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
  public List<Exercise> selectData() {
    final String _sql = "SELECT * FROM Exercise";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfTip = CursorUtil.getColumnIndexOrThrow(_cursor, "tip");
      final int _cursorIndexOfImage1 = CursorUtil.getColumnIndexOrThrow(_cursor, "image1");
      final List<Exercise> _result = new ArrayList<Exercise>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Exercise _item;
        _item = new Exercise();
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final String _tmpTip;
        if (_cursor.isNull(_cursorIndexOfTip)) {
          _tmpTip = null;
        } else {
          _tmpTip = _cursor.getString(_cursorIndexOfTip);
        }
        _item.setTip(_tmpTip);
        final int _tmpImage1;
        _tmpImage1 = _cursor.getInt(_cursorIndexOfImage1);
        _item.setImage1(_tmpImage1);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
