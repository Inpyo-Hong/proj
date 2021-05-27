package com.project.iip.dao;

import android.database.Cursor;
import androidx.collection.LongSparseArray;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.project.iip.dto.Exercise;
import com.project.iip.dto.Schedule;
import com.project.iip.dto.ScheduleWithExercise;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ScheduleDao_Impl implements ScheduleDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Schedule> __insertionAdapterOfSchedule;

  private final EntityDeletionOrUpdateAdapter<Schedule> __deletionAdapterOfSchedule;

  private final EntityDeletionOrUpdateAdapter<Schedule> __updateAdapterOfSchedule;

  public ScheduleDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSchedule = new EntityInsertionAdapter<Schedule>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Schedule` (`id`,`year`,`month`,`day`,`exerciseId`,`set`,`rep`,`done`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Schedule value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getYear());
        stmt.bindLong(3, value.getMonth());
        stmt.bindLong(4, value.getDay());
        stmt.bindLong(5, value.getExerciseId());
        stmt.bindLong(6, value.getSet());
        stmt.bindLong(7, value.getRep());
        final int _tmp;
        _tmp = value.getDone() ? 1 : 0;
        stmt.bindLong(8, _tmp);
      }
    };
    this.__deletionAdapterOfSchedule = new EntityDeletionOrUpdateAdapter<Schedule>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Schedule` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Schedule value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfSchedule = new EntityDeletionOrUpdateAdapter<Schedule>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Schedule` SET `id` = ?,`year` = ?,`month` = ?,`day` = ?,`exerciseId` = ?,`set` = ?,`rep` = ?,`done` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Schedule value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getYear());
        stmt.bindLong(3, value.getMonth());
        stmt.bindLong(4, value.getDay());
        stmt.bindLong(5, value.getExerciseId());
        stmt.bindLong(6, value.getSet());
        stmt.bindLong(7, value.getRep());
        final int _tmp;
        _tmp = value.getDone() ? 1 : 0;
        stmt.bindLong(8, _tmp);
        stmt.bindLong(9, value.getId());
      }
    };
  }

  @Override
  public void insert(final Schedule... arg) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSchedule.insert(arg);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Schedule... arg) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSchedule.handleMultiple(arg);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Schedule... arg) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfSchedule.handleMultiple(arg);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<ScheduleWithExercise> selectWithExerciseList() {
    final String _sql = "SELECT * FROM Schedule";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
      final int _cursorIndexOfMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "month");
      final int _cursorIndexOfDay = CursorUtil.getColumnIndexOrThrow(_cursor, "day");
      final int _cursorIndexOfExerciseId = CursorUtil.getColumnIndexOrThrow(_cursor, "exerciseId");
      final int _cursorIndexOfSet = CursorUtil.getColumnIndexOrThrow(_cursor, "set");
      final int _cursorIndexOfRep = CursorUtil.getColumnIndexOrThrow(_cursor, "rep");
      final int _cursorIndexOfDone = CursorUtil.getColumnIndexOrThrow(_cursor, "done");
      final LongSparseArray<Exercise> _collectionExercise = new LongSparseArray<Exercise>();
      while (_cursor.moveToNext()) {
        if (!_cursor.isNull(_cursorIndexOfExerciseId)) {
          final long _tmpKey = _cursor.getLong(_cursorIndexOfExerciseId);
          _collectionExercise.put(_tmpKey, null);
        }
      }
      _cursor.moveToPosition(-1);
      __fetchRelationshipExerciseAscomProjectIipDtoExercise(_collectionExercise);
      final List<ScheduleWithExercise> _result = new ArrayList<ScheduleWithExercise>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ScheduleWithExercise _item;
        final Schedule _tmpSchedule;
        if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfYear) && _cursor.isNull(_cursorIndexOfMonth) && _cursor.isNull(_cursorIndexOfDay) && _cursor.isNull(_cursorIndexOfExerciseId) && _cursor.isNull(_cursorIndexOfSet) && _cursor.isNull(_cursorIndexOfRep) && _cursor.isNull(_cursorIndexOfDone))) {
          final long _tmpId;
          _tmpId = _cursor.getLong(_cursorIndexOfId);
          final int _tmpYear;
          _tmpYear = _cursor.getInt(_cursorIndexOfYear);
          final int _tmpMonth;
          _tmpMonth = _cursor.getInt(_cursorIndexOfMonth);
          final int _tmpDay;
          _tmpDay = _cursor.getInt(_cursorIndexOfDay);
          final long _tmpExerciseId;
          _tmpExerciseId = _cursor.getLong(_cursorIndexOfExerciseId);
          final int _tmpSet;
          _tmpSet = _cursor.getInt(_cursorIndexOfSet);
          final int _tmpRep;
          _tmpRep = _cursor.getInt(_cursorIndexOfRep);
          final boolean _tmpDone;
          final int _tmp;
          _tmp = _cursor.getInt(_cursorIndexOfDone);
          _tmpDone = _tmp != 0;
          _tmpSchedule = new Schedule(_tmpId,_tmpYear,_tmpMonth,_tmpDay,_tmpExerciseId,_tmpSet,_tmpRep,_tmpDone);
        }  else  {
          _tmpSchedule = null;
        }
        Exercise _tmpExercise = null;
        if (!_cursor.isNull(_cursorIndexOfExerciseId)) {
          final long _tmpKey_1 = _cursor.getLong(_cursorIndexOfExerciseId);
          _tmpExercise = _collectionExercise.get(_tmpKey_1);
        }
        _item = new ScheduleWithExercise();
        _item.setSchedule(_tmpSchedule);
        _item.setExercise(_tmpExercise);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Schedule> selectWithDateAndExerciseId(final int year, final int month, final int day,
      final long exerciseId) {
    final String _sql = "SELECT * FROM Schedule WHERE year = ? AND month = ? AND day = ? AND exerciseId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 4);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, year);
    _argIndex = 2;
    _statement.bindLong(_argIndex, month);
    _argIndex = 3;
    _statement.bindLong(_argIndex, day);
    _argIndex = 4;
    _statement.bindLong(_argIndex, exerciseId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
      final int _cursorIndexOfMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "month");
      final int _cursorIndexOfDay = CursorUtil.getColumnIndexOrThrow(_cursor, "day");
      final int _cursorIndexOfExerciseId = CursorUtil.getColumnIndexOrThrow(_cursor, "exerciseId");
      final int _cursorIndexOfSet = CursorUtil.getColumnIndexOrThrow(_cursor, "set");
      final int _cursorIndexOfRep = CursorUtil.getColumnIndexOrThrow(_cursor, "rep");
      final int _cursorIndexOfDone = CursorUtil.getColumnIndexOrThrow(_cursor, "done");
      final List<Schedule> _result = new ArrayList<Schedule>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Schedule _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final int _tmpYear;
        _tmpYear = _cursor.getInt(_cursorIndexOfYear);
        final int _tmpMonth;
        _tmpMonth = _cursor.getInt(_cursorIndexOfMonth);
        final int _tmpDay;
        _tmpDay = _cursor.getInt(_cursorIndexOfDay);
        final long _tmpExerciseId;
        _tmpExerciseId = _cursor.getLong(_cursorIndexOfExerciseId);
        final int _tmpSet;
        _tmpSet = _cursor.getInt(_cursorIndexOfSet);
        final int _tmpRep;
        _tmpRep = _cursor.getInt(_cursorIndexOfRep);
        final boolean _tmpDone;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfDone);
        _tmpDone = _tmp != 0;
        _item = new Schedule(_tmpId,_tmpYear,_tmpMonth,_tmpDay,_tmpExerciseId,_tmpSet,_tmpRep,_tmpDone);
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

  private void __fetchRelationshipExerciseAscomProjectIipDtoExercise(
      final LongSparseArray<Exercise> _map) {
    if (_map.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      LongSparseArray<Exercise> _tmpInnerMap = new LongSparseArray<Exercise>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      int _mapIndex = 0;
      final int _limit = _map.size();
      while(_mapIndex < _limit) {
        _tmpInnerMap.put(_map.keyAt(_mapIndex), null);
        _mapIndex++;
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshipExerciseAscomProjectIipDtoExercise(_tmpInnerMap);
          _map.putAll(_tmpInnerMap);
          _tmpInnerMap = new LongSparseArray<Exercise>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshipExerciseAscomProjectIipDtoExercise(_tmpInnerMap);
        _map.putAll(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `id`,`name`,`tip`,`image1` FROM `Exercise` WHERE `id` IN (");
    final int _inputSize = _map.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int i = 0; i < _map.size(); i++) {
      long _item = _map.keyAt(i);
      _stmt.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "id");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfTip = CursorUtil.getColumnIndexOrThrow(_cursor, "tip");
      final int _cursorIndexOfImage1 = CursorUtil.getColumnIndexOrThrow(_cursor, "image1");
      while(_cursor.moveToNext()) {
        if (!_cursor.isNull(_itemKeyIndex)) {
          final long _tmpKey = _cursor.getLong(_itemKeyIndex);
          if (_map.containsKey(_tmpKey)) {
            final Exercise _item_1;
            _item_1 = new Exercise();
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            _item_1.setId(_tmpId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            _item_1.setName(_tmpName);
            final String _tmpTip;
            if (_cursor.isNull(_cursorIndexOfTip)) {
              _tmpTip = null;
            } else {
              _tmpTip = _cursor.getString(_cursorIndexOfTip);
            }
            _item_1.setTip(_tmpTip);
            final int _tmpImage1;
            _tmpImage1 = _cursor.getInt(_cursorIndexOfImage1);
            _item_1.setImage1(_tmpImage1);
            _map.put(_tmpKey, _item_1);
          }
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
