package com.company.app.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.RelationUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.company.app.data.local.db.AppTypeConverters;
import com.company.app.data.local.entity.CallEntity;
import com.company.app.data.local.entity.TranscriptEntity;
import com.company.app.data.local.model.CallWithTranscriptLocal;
import com.company.app.domain.model.CallType;
import com.company.app.domain.model.TranscriptionStatus;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class CallDao_Impl implements CallDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CallEntity> __insertionAdapterOfCallEntity;

  private final AppTypeConverters __appTypeConverters = new AppTypeConverters();

  private final SharedSQLiteStatement __preparedStmtOfUpdateStatus;

  private final SharedSQLiteStatement __preparedStmtOfUpdateRecordingData;

  public CallDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCallEntity = new EntityInsertionAdapter<CallEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `calls` (`id`,`remoteUserId`,`source`,`type`,`timestamp`,`duration`,`audioFilePath`,`transcriptionStatus`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final CallEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getRemoteUserId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getRemoteUserId());
        }
        if (entity.getSource() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getSource());
        }
        final String _tmp = __appTypeConverters.fromCallType(entity.getType());
        if (_tmp == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, _tmp);
        }
        statement.bindLong(5, entity.getTimestamp());
        statement.bindLong(6, entity.getDuration());
        if (entity.getAudioFilePath() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getAudioFilePath());
        }
        final String _tmp_1 = __appTypeConverters.fromTranscriptionStatus(entity.getTranscriptionStatus());
        if (_tmp_1 == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, _tmp_1);
        }
      }
    };
    this.__preparedStmtOfUpdateStatus = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE calls SET transcriptionStatus=? WHERE id=?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateRecordingData = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE calls SET transcriptionStatus=?, audioFilePath=?, duration=? WHERE id=?";
        return _query;
      }
    };
  }

  @Override
  public Object upsert(final CallEntity call, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfCallEntity.insertAndReturnId(call);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insert(final CallEntity call, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfCallEntity.insertAndReturnId(call);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateStatus(final long id, final String status,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateStatus.acquire();
        int _argIndex = 1;
        if (status == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, status);
        }
        _argIndex = 2;
        _stmt.bindLong(_argIndex, id);
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
          __preparedStmtOfUpdateStatus.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateRecordingData(final long id, final String status, final String filePath,
      final long duration, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateRecordingData.acquire();
        int _argIndex = 1;
        if (status == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, status);
        }
        _argIndex = 2;
        if (filePath == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, filePath);
        }
        _argIndex = 3;
        _stmt.bindLong(_argIndex, duration);
        _argIndex = 4;
        _stmt.bindLong(_argIndex, id);
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
          __preparedStmtOfUpdateRecordingData.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<CallEntity>> observeCalls() {
    final String _sql = "SELECT * FROM calls ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"calls"}, new Callable<List<CallEntity>>() {
      @Override
      @NonNull
      public List<CallEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfRemoteUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "remoteUserId");
          final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfAudioFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "audioFilePath");
          final int _cursorIndexOfTranscriptionStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "transcriptionStatus");
          final List<CallEntity> _result = new ArrayList<CallEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final CallEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpRemoteUserId;
            if (_cursor.isNull(_cursorIndexOfRemoteUserId)) {
              _tmpRemoteUserId = null;
            } else {
              _tmpRemoteUserId = _cursor.getString(_cursorIndexOfRemoteUserId);
            }
            final String _tmpSource;
            if (_cursor.isNull(_cursorIndexOfSource)) {
              _tmpSource = null;
            } else {
              _tmpSource = _cursor.getString(_cursorIndexOfSource);
            }
            final CallType _tmpType;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfType);
            }
            _tmpType = __appTypeConverters.toCallType(_tmp);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final String _tmpAudioFilePath;
            if (_cursor.isNull(_cursorIndexOfAudioFilePath)) {
              _tmpAudioFilePath = null;
            } else {
              _tmpAudioFilePath = _cursor.getString(_cursorIndexOfAudioFilePath);
            }
            final TranscriptionStatus _tmpTranscriptionStatus;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfTranscriptionStatus)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfTranscriptionStatus);
            }
            _tmpTranscriptionStatus = __appTypeConverters.toTranscriptionStatus(_tmp_1);
            _item = new CallEntity(_tmpId,_tmpRemoteUserId,_tmpSource,_tmpType,_tmpTimestamp,_tmpDuration,_tmpAudioFilePath,_tmpTranscriptionStatus);
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
  public Object getAllCallsWithTranscripts(
      final Continuation<? super List<CallWithTranscriptLocal>> $completion) {
    final String _sql = "SELECT * FROM calls ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, true, _cancellationSignal, new Callable<List<CallWithTranscriptLocal>>() {
      @Override
      @NonNull
      public List<CallWithTranscriptLocal> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfRemoteUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "remoteUserId");
            final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
            final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
            final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
            final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
            final int _cursorIndexOfAudioFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "audioFilePath");
            final int _cursorIndexOfTranscriptionStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "transcriptionStatus");
            final LongSparseArray<TranscriptEntity> _collectionTranscript = new LongSparseArray<TranscriptEntity>();
            while (_cursor.moveToNext()) {
              final long _tmpKey;
              _tmpKey = _cursor.getLong(_cursorIndexOfId);
              _collectionTranscript.put(_tmpKey, null);
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshiptranscriptsAscomCompanyAppDataLocalEntityTranscriptEntity(_collectionTranscript);
            final List<CallWithTranscriptLocal> _result = new ArrayList<CallWithTranscriptLocal>(_cursor.getCount());
            while (_cursor.moveToNext()) {
              final CallWithTranscriptLocal _item;
              final CallEntity _tmpCall;
              final long _tmpId;
              _tmpId = _cursor.getLong(_cursorIndexOfId);
              final String _tmpRemoteUserId;
              if (_cursor.isNull(_cursorIndexOfRemoteUserId)) {
                _tmpRemoteUserId = null;
              } else {
                _tmpRemoteUserId = _cursor.getString(_cursorIndexOfRemoteUserId);
              }
              final String _tmpSource;
              if (_cursor.isNull(_cursorIndexOfSource)) {
                _tmpSource = null;
              } else {
                _tmpSource = _cursor.getString(_cursorIndexOfSource);
              }
              final CallType _tmpType;
              final String _tmp;
              if (_cursor.isNull(_cursorIndexOfType)) {
                _tmp = null;
              } else {
                _tmp = _cursor.getString(_cursorIndexOfType);
              }
              _tmpType = __appTypeConverters.toCallType(_tmp);
              final long _tmpTimestamp;
              _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
              final long _tmpDuration;
              _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
              final String _tmpAudioFilePath;
              if (_cursor.isNull(_cursorIndexOfAudioFilePath)) {
                _tmpAudioFilePath = null;
              } else {
                _tmpAudioFilePath = _cursor.getString(_cursorIndexOfAudioFilePath);
              }
              final TranscriptionStatus _tmpTranscriptionStatus;
              final String _tmp_1;
              if (_cursor.isNull(_cursorIndexOfTranscriptionStatus)) {
                _tmp_1 = null;
              } else {
                _tmp_1 = _cursor.getString(_cursorIndexOfTranscriptionStatus);
              }
              _tmpTranscriptionStatus = __appTypeConverters.toTranscriptionStatus(_tmp_1);
              _tmpCall = new CallEntity(_tmpId,_tmpRemoteUserId,_tmpSource,_tmpType,_tmpTimestamp,_tmpDuration,_tmpAudioFilePath,_tmpTranscriptionStatus);
              final TranscriptEntity _tmpTranscript;
              final long _tmpKey_1;
              _tmpKey_1 = _cursor.getLong(_cursorIndexOfId);
              _tmpTranscript = _collectionTranscript.get(_tmpKey_1);
              _item = new CallWithTranscriptLocal(_tmpCall,_tmpTranscript);
              _result.add(_item);
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
            _statement.release();
          }
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getCallWithTranscriptById(final long id,
      final Continuation<? super CallWithTranscriptLocal> $completion) {
    final String _sql = "SELECT * FROM calls WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, true, _cancellationSignal, new Callable<CallWithTranscriptLocal>() {
      @Override
      @Nullable
      public CallWithTranscriptLocal call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfRemoteUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "remoteUserId");
            final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
            final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
            final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
            final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
            final int _cursorIndexOfAudioFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "audioFilePath");
            final int _cursorIndexOfTranscriptionStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "transcriptionStatus");
            final LongSparseArray<TranscriptEntity> _collectionTranscript = new LongSparseArray<TranscriptEntity>();
            while (_cursor.moveToNext()) {
              final long _tmpKey;
              _tmpKey = _cursor.getLong(_cursorIndexOfId);
              _collectionTranscript.put(_tmpKey, null);
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshiptranscriptsAscomCompanyAppDataLocalEntityTranscriptEntity(_collectionTranscript);
            final CallWithTranscriptLocal _result;
            if (_cursor.moveToFirst()) {
              final CallEntity _tmpCall;
              final long _tmpId;
              _tmpId = _cursor.getLong(_cursorIndexOfId);
              final String _tmpRemoteUserId;
              if (_cursor.isNull(_cursorIndexOfRemoteUserId)) {
                _tmpRemoteUserId = null;
              } else {
                _tmpRemoteUserId = _cursor.getString(_cursorIndexOfRemoteUserId);
              }
              final String _tmpSource;
              if (_cursor.isNull(_cursorIndexOfSource)) {
                _tmpSource = null;
              } else {
                _tmpSource = _cursor.getString(_cursorIndexOfSource);
              }
              final CallType _tmpType;
              final String _tmp;
              if (_cursor.isNull(_cursorIndexOfType)) {
                _tmp = null;
              } else {
                _tmp = _cursor.getString(_cursorIndexOfType);
              }
              _tmpType = __appTypeConverters.toCallType(_tmp);
              final long _tmpTimestamp;
              _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
              final long _tmpDuration;
              _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
              final String _tmpAudioFilePath;
              if (_cursor.isNull(_cursorIndexOfAudioFilePath)) {
                _tmpAudioFilePath = null;
              } else {
                _tmpAudioFilePath = _cursor.getString(_cursorIndexOfAudioFilePath);
              }
              final TranscriptionStatus _tmpTranscriptionStatus;
              final String _tmp_1;
              if (_cursor.isNull(_cursorIndexOfTranscriptionStatus)) {
                _tmp_1 = null;
              } else {
                _tmp_1 = _cursor.getString(_cursorIndexOfTranscriptionStatus);
              }
              _tmpTranscriptionStatus = __appTypeConverters.toTranscriptionStatus(_tmp_1);
              _tmpCall = new CallEntity(_tmpId,_tmpRemoteUserId,_tmpSource,_tmpType,_tmpTimestamp,_tmpDuration,_tmpAudioFilePath,_tmpTranscriptionStatus);
              final TranscriptEntity _tmpTranscript;
              final long _tmpKey_1;
              _tmpKey_1 = _cursor.getLong(_cursorIndexOfId);
              _tmpTranscript = _collectionTranscript.get(_tmpKey_1);
              _result = new CallWithTranscriptLocal(_tmpCall,_tmpTranscript);
            } else {
              _result = null;
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
            _statement.release();
          }
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private void __fetchRelationshiptranscriptsAscomCompanyAppDataLocalEntityTranscriptEntity(
      @NonNull final LongSparseArray<TranscriptEntity> _map) {
    if (_map.isEmpty()) {
      return;
    }
    if (_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      RelationUtil.recursiveFetchLongSparseArray(_map, false, (map) -> {
        __fetchRelationshiptranscriptsAscomCompanyAppDataLocalEntityTranscriptEntity(map);
        return Unit.INSTANCE;
      });
      return;
    }
    final StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `id`,`callId`,`fullText`,`summary`,`speakerMap`,`timestamp` FROM `transcripts` WHERE `callId` IN (");
    final int _inputSize = _map.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int i = 0; i < _map.size(); i++) {
      final long _item = _map.keyAt(i);
      _stmt.bindLong(_argIndex, _item);
      _argIndex++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "callId");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfCallId = 1;
      final int _cursorIndexOfFullText = 2;
      final int _cursorIndexOfSummary = 3;
      final int _cursorIndexOfSpeakerMap = 4;
      final int _cursorIndexOfTimestamp = 5;
      while (_cursor.moveToNext()) {
        final long _tmpKey;
        _tmpKey = _cursor.getLong(_itemKeyIndex);
        if (_map.containsKey(_tmpKey)) {
          final TranscriptEntity _item_1;
          final long _tmpId;
          _tmpId = _cursor.getLong(_cursorIndexOfId);
          final long _tmpCallId;
          _tmpCallId = _cursor.getLong(_cursorIndexOfCallId);
          final String _tmpFullText;
          if (_cursor.isNull(_cursorIndexOfFullText)) {
            _tmpFullText = null;
          } else {
            _tmpFullText = _cursor.getString(_cursorIndexOfFullText);
          }
          final String _tmpSummary;
          if (_cursor.isNull(_cursorIndexOfSummary)) {
            _tmpSummary = null;
          } else {
            _tmpSummary = _cursor.getString(_cursorIndexOfSummary);
          }
          final String _tmpSpeakerMap;
          if (_cursor.isNull(_cursorIndexOfSpeakerMap)) {
            _tmpSpeakerMap = null;
          } else {
            _tmpSpeakerMap = _cursor.getString(_cursorIndexOfSpeakerMap);
          }
          final long _tmpTimestamp;
          _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
          _item_1 = new TranscriptEntity(_tmpId,_tmpCallId,_tmpFullText,_tmpSummary,_tmpSpeakerMap,_tmpTimestamp);
          _map.put(_tmpKey, _item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
