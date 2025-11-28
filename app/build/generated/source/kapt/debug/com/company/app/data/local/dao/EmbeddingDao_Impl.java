package com.company.app.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.company.app.data.local.vector.TranscriptEmbeddingEntity;
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
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class EmbeddingDao_Impl implements EmbeddingDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TranscriptEmbeddingEntity> __insertionAdapterOfTranscriptEmbeddingEntity;

  public EmbeddingDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTranscriptEmbeddingEntity = new EntityInsertionAdapter<TranscriptEmbeddingEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `embeddings` (`id`,`transcriptId`,`callId`,`textChunk`,`embeddingJson`,`timestamp`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final TranscriptEmbeddingEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getTranscriptId());
        statement.bindLong(3, entity.getCallId());
        if (entity.getTextChunk() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getTextChunk());
        }
        if (entity.getEmbeddingJson() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getEmbeddingJson());
        }
        statement.bindLong(6, entity.getTimestamp());
      }
    };
  }

  @Override
  public Object insert(final TranscriptEmbeddingEntity embedding,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTranscriptEmbeddingEntity.insert(embedding);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAll(final Continuation<? super List<TranscriptEmbeddingEntity>> $completion) {
    final String _sql = "SELECT * FROM embeddings";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<TranscriptEmbeddingEntity>>() {
      @Override
      @NonNull
      public List<TranscriptEmbeddingEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTranscriptId = CursorUtil.getColumnIndexOrThrow(_cursor, "transcriptId");
          final int _cursorIndexOfCallId = CursorUtil.getColumnIndexOrThrow(_cursor, "callId");
          final int _cursorIndexOfTextChunk = CursorUtil.getColumnIndexOrThrow(_cursor, "textChunk");
          final int _cursorIndexOfEmbeddingJson = CursorUtil.getColumnIndexOrThrow(_cursor, "embeddingJson");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final List<TranscriptEmbeddingEntity> _result = new ArrayList<TranscriptEmbeddingEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TranscriptEmbeddingEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpTranscriptId;
            _tmpTranscriptId = _cursor.getLong(_cursorIndexOfTranscriptId);
            final long _tmpCallId;
            _tmpCallId = _cursor.getLong(_cursorIndexOfCallId);
            final String _tmpTextChunk;
            if (_cursor.isNull(_cursorIndexOfTextChunk)) {
              _tmpTextChunk = null;
            } else {
              _tmpTextChunk = _cursor.getString(_cursorIndexOfTextChunk);
            }
            final String _tmpEmbeddingJson;
            if (_cursor.isNull(_cursorIndexOfEmbeddingJson)) {
              _tmpEmbeddingJson = null;
            } else {
              _tmpEmbeddingJson = _cursor.getString(_cursorIndexOfEmbeddingJson);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            _item = new TranscriptEmbeddingEntity(_tmpId,_tmpTranscriptId,_tmpCallId,_tmpTextChunk,_tmpEmbeddingJson,_tmpTimestamp);
            _result.add(_item);
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
  public Object getByCallId(final long callId,
      final Continuation<? super List<TranscriptEmbeddingEntity>> $completion) {
    final String _sql = "SELECT * FROM embeddings WHERE callId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, callId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<TranscriptEmbeddingEntity>>() {
      @Override
      @NonNull
      public List<TranscriptEmbeddingEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTranscriptId = CursorUtil.getColumnIndexOrThrow(_cursor, "transcriptId");
          final int _cursorIndexOfCallId = CursorUtil.getColumnIndexOrThrow(_cursor, "callId");
          final int _cursorIndexOfTextChunk = CursorUtil.getColumnIndexOrThrow(_cursor, "textChunk");
          final int _cursorIndexOfEmbeddingJson = CursorUtil.getColumnIndexOrThrow(_cursor, "embeddingJson");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final List<TranscriptEmbeddingEntity> _result = new ArrayList<TranscriptEmbeddingEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TranscriptEmbeddingEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpTranscriptId;
            _tmpTranscriptId = _cursor.getLong(_cursorIndexOfTranscriptId);
            final long _tmpCallId;
            _tmpCallId = _cursor.getLong(_cursorIndexOfCallId);
            final String _tmpTextChunk;
            if (_cursor.isNull(_cursorIndexOfTextChunk)) {
              _tmpTextChunk = null;
            } else {
              _tmpTextChunk = _cursor.getString(_cursorIndexOfTextChunk);
            }
            final String _tmpEmbeddingJson;
            if (_cursor.isNull(_cursorIndexOfEmbeddingJson)) {
              _tmpEmbeddingJson = null;
            } else {
              _tmpEmbeddingJson = _cursor.getString(_cursorIndexOfEmbeddingJson);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            _item = new TranscriptEmbeddingEntity(_tmpId,_tmpTranscriptId,_tmpCallId,_tmpTextChunk,_tmpEmbeddingJson,_tmpTimestamp);
            _result.add(_item);
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
