package com.company.app.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.company.app.data.local.entity.TranscriptEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class TranscriptDao_Impl implements TranscriptDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TranscriptEntity> __insertionAdapterOfTranscriptEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSummary;

  private final SharedSQLiteStatement __preparedStmtOfUpdateTranscript;

  public TranscriptDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTranscriptEntity = new EntityInsertionAdapter<TranscriptEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `transcripts` (`id`,`callId`,`fullText`,`summary`,`speakerMap`,`timestamp`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final TranscriptEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getCallId());
        if (entity.getFullText() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getFullText());
        }
        if (entity.getSummary() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getSummary());
        }
        if (entity.getSpeakerMap() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getSpeakerMap());
        }
        statement.bindLong(6, entity.getTimestamp());
      }
    };
    this.__preparedStmtOfUpdateSummary = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE transcripts SET summary=?, timestamp=? WHERE id=?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateTranscript = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE transcripts SET fullText=?, timestamp=? WHERE id=?";
        return _query;
      }
    };
  }

  @Override
  public Object upsert(final TranscriptEntity transcript,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTranscriptEntity.insert(transcript);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insert(final TranscriptEntity transcript,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfTranscriptEntity.insertAndReturnId(transcript);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateSummary(final long id, final String summary, final long timestamp,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSummary.acquire();
        int _argIndex = 1;
        if (summary == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, summary);
        }
        _argIndex = 2;
        _stmt.bindLong(_argIndex, timestamp);
        _argIndex = 3;
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
          __preparedStmtOfUpdateSummary.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateTranscript(final long id, final String text, final long timestamp,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateTranscript.acquire();
        int _argIndex = 1;
        if (text == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, text);
        }
        _argIndex = 2;
        _stmt.bindLong(_argIndex, timestamp);
        _argIndex = 3;
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
          __preparedStmtOfUpdateTranscript.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<TranscriptEntity> observeTranscript(final long callId) {
    final String _sql = "SELECT * FROM transcripts WHERE callId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, callId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"transcripts"}, new Callable<TranscriptEntity>() {
      @Override
      @Nullable
      public TranscriptEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCallId = CursorUtil.getColumnIndexOrThrow(_cursor, "callId");
          final int _cursorIndexOfFullText = CursorUtil.getColumnIndexOrThrow(_cursor, "fullText");
          final int _cursorIndexOfSummary = CursorUtil.getColumnIndexOrThrow(_cursor, "summary");
          final int _cursorIndexOfSpeakerMap = CursorUtil.getColumnIndexOrThrow(_cursor, "speakerMap");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final TranscriptEntity _result;
          if (_cursor.moveToFirst()) {
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
            _result = new TranscriptEntity(_tmpId,_tmpCallId,_tmpFullText,_tmpSummary,_tmpSpeakerMap,_tmpTimestamp);
          } else {
            _result = null;
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
  public Object getById(final long id, final Continuation<? super TranscriptEntity> $completion) {
    final String _sql = "SELECT * FROM transcripts WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<TranscriptEntity>() {
      @Override
      @Nullable
      public TranscriptEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCallId = CursorUtil.getColumnIndexOrThrow(_cursor, "callId");
          final int _cursorIndexOfFullText = CursorUtil.getColumnIndexOrThrow(_cursor, "fullText");
          final int _cursorIndexOfSummary = CursorUtil.getColumnIndexOrThrow(_cursor, "summary");
          final int _cursorIndexOfSpeakerMap = CursorUtil.getColumnIndexOrThrow(_cursor, "speakerMap");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final TranscriptEntity _result;
          if (_cursor.moveToFirst()) {
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
            _result = new TranscriptEntity(_tmpId,_tmpCallId,_tmpFullText,_tmpSummary,_tmpSpeakerMap,_tmpTimestamp);
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

  @Override
  public Object findByCallId(final long callId,
      final Continuation<? super TranscriptEntity> $completion) {
    final String _sql = "SELECT * FROM transcripts WHERE callId = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, callId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<TranscriptEntity>() {
      @Override
      @Nullable
      public TranscriptEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCallId = CursorUtil.getColumnIndexOrThrow(_cursor, "callId");
          final int _cursorIndexOfFullText = CursorUtil.getColumnIndexOrThrow(_cursor, "fullText");
          final int _cursorIndexOfSummary = CursorUtil.getColumnIndexOrThrow(_cursor, "summary");
          final int _cursorIndexOfSpeakerMap = CursorUtil.getColumnIndexOrThrow(_cursor, "speakerMap");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final TranscriptEntity _result;
          if (_cursor.moveToFirst()) {
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
            _result = new TranscriptEntity(_tmpId,_tmpCallId,_tmpFullText,_tmpSummary,_tmpSpeakerMap,_tmpTimestamp);
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
