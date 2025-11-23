package com.company.app.data.local.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.company.app.data.local.entity.MessageEntity;
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
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class MessageDao_Impl implements MessageDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MessageEntity> __insertionAdapterOfMessageEntity;

  public MessageDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMessageEntity = new EntityInsertionAdapter<MessageEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `messages` (`id`,`chatId`,`senderId`,`contentEncrypted`,`timestamp`) VALUES (?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final MessageEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getChatId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getChatId());
        }
        if (entity.getSenderId() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getSenderId());
        }
        if (entity.getContentEncrypted() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getContentEncrypted());
        }
        statement.bindLong(5, entity.getTimestamp());
      }
    };
  }

  @Override
  public Object upsert(final MessageEntity message, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfMessageEntity.insert(message);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<MessageEntity>> observeMessages(final String chatId) {
    final String _sql = "SELECT * FROM messages WHERE chatId = ? ORDER BY timestamp ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (chatId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, chatId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"messages"}, new Callable<List<MessageEntity>>() {
      @Override
      @NonNull
      public List<MessageEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "chatId");
          final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "senderId");
          final int _cursorIndexOfContentEncrypted = CursorUtil.getColumnIndexOrThrow(_cursor, "contentEncrypted");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final List<MessageEntity> _result = new ArrayList<MessageEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final MessageEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpChatId;
            if (_cursor.isNull(_cursorIndexOfChatId)) {
              _tmpChatId = null;
            } else {
              _tmpChatId = _cursor.getString(_cursorIndexOfChatId);
            }
            final String _tmpSenderId;
            if (_cursor.isNull(_cursorIndexOfSenderId)) {
              _tmpSenderId = null;
            } else {
              _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
            }
            final String _tmpContentEncrypted;
            if (_cursor.isNull(_cursorIndexOfContentEncrypted)) {
              _tmpContentEncrypted = null;
            } else {
              _tmpContentEncrypted = _cursor.getString(_cursorIndexOfContentEncrypted);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            _item = new MessageEntity(_tmpId,_tmpChatId,_tmpSenderId,_tmpContentEncrypted,_tmpTimestamp);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
