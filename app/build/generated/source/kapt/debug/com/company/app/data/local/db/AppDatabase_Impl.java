package com.company.app.data.local.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.company.app.data.local.dao.CallDao;
import com.company.app.data.local.dao.CallDao_Impl;
import com.company.app.data.local.dao.EmbeddingDao;
import com.company.app.data.local.dao.EmbeddingDao_Impl;
import com.company.app.data.local.dao.MessageDao;
import com.company.app.data.local.dao.MessageDao_Impl;
import com.company.app.data.local.dao.TranscriptDao;
import com.company.app.data.local.dao.TranscriptDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile MessageDao _messageDao;

  private volatile CallDao _callDao;

  private volatile TranscriptDao _transcriptDao;

  private volatile EmbeddingDao _embeddingDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(4) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `messages` (`id` TEXT NOT NULL, `chatId` TEXT NOT NULL, `senderId` TEXT NOT NULL, `contentEncrypted` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `calls` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `remoteUserId` TEXT NOT NULL, `source` TEXT NOT NULL, `type` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `audioFilePath` TEXT NOT NULL, `transcriptionStatus` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `transcripts` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `callId` INTEGER NOT NULL, `fullText` TEXT NOT NULL, `summary` TEXT NOT NULL, `speakerMap` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, FOREIGN KEY(`callId`) REFERENCES `calls`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS `embeddings` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `transcriptId` INTEGER NOT NULL, `callId` INTEGER NOT NULL, `textChunk` TEXT NOT NULL, `embeddingJson` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, FOREIGN KEY(`transcriptId`) REFERENCES `transcripts`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_embeddings_transcriptId` ON `embeddings` (`transcriptId`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5b7623d89bbdc3d9dccd64c63d229e17')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `messages`");
        db.execSQL("DROP TABLE IF EXISTS `calls`");
        db.execSQL("DROP TABLE IF EXISTS `transcripts`");
        db.execSQL("DROP TABLE IF EXISTS `embeddings`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsMessages = new HashMap<String, TableInfo.Column>(5);
        _columnsMessages.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessages.put("chatId", new TableInfo.Column("chatId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessages.put("senderId", new TableInfo.Column("senderId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessages.put("contentEncrypted", new TableInfo.Column("contentEncrypted", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessages.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMessages = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMessages = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMessages = new TableInfo("messages", _columnsMessages, _foreignKeysMessages, _indicesMessages);
        final TableInfo _existingMessages = TableInfo.read(db, "messages");
        if (!_infoMessages.equals(_existingMessages)) {
          return new RoomOpenHelper.ValidationResult(false, "messages(com.company.app.data.local.entity.MessageEntity).\n"
                  + " Expected:\n" + _infoMessages + "\n"
                  + " Found:\n" + _existingMessages);
        }
        final HashMap<String, TableInfo.Column> _columnsCalls = new HashMap<String, TableInfo.Column>(8);
        _columnsCalls.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCalls.put("remoteUserId", new TableInfo.Column("remoteUserId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCalls.put("source", new TableInfo.Column("source", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCalls.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCalls.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCalls.put("duration", new TableInfo.Column("duration", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCalls.put("audioFilePath", new TableInfo.Column("audioFilePath", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCalls.put("transcriptionStatus", new TableInfo.Column("transcriptionStatus", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCalls = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCalls = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCalls = new TableInfo("calls", _columnsCalls, _foreignKeysCalls, _indicesCalls);
        final TableInfo _existingCalls = TableInfo.read(db, "calls");
        if (!_infoCalls.equals(_existingCalls)) {
          return new RoomOpenHelper.ValidationResult(false, "calls(com.company.app.data.local.entity.CallEntity).\n"
                  + " Expected:\n" + _infoCalls + "\n"
                  + " Found:\n" + _existingCalls);
        }
        final HashMap<String, TableInfo.Column> _columnsTranscripts = new HashMap<String, TableInfo.Column>(6);
        _columnsTranscripts.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTranscripts.put("callId", new TableInfo.Column("callId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTranscripts.put("fullText", new TableInfo.Column("fullText", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTranscripts.put("summary", new TableInfo.Column("summary", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTranscripts.put("speakerMap", new TableInfo.Column("speakerMap", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTranscripts.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTranscripts = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysTranscripts.add(new TableInfo.ForeignKey("calls", "CASCADE", "NO ACTION", Arrays.asList("callId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesTranscripts = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTranscripts = new TableInfo("transcripts", _columnsTranscripts, _foreignKeysTranscripts, _indicesTranscripts);
        final TableInfo _existingTranscripts = TableInfo.read(db, "transcripts");
        if (!_infoTranscripts.equals(_existingTranscripts)) {
          return new RoomOpenHelper.ValidationResult(false, "transcripts(com.company.app.data.local.entity.TranscriptEntity).\n"
                  + " Expected:\n" + _infoTranscripts + "\n"
                  + " Found:\n" + _existingTranscripts);
        }
        final HashMap<String, TableInfo.Column> _columnsEmbeddings = new HashMap<String, TableInfo.Column>(6);
        _columnsEmbeddings.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmbeddings.put("transcriptId", new TableInfo.Column("transcriptId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmbeddings.put("callId", new TableInfo.Column("callId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmbeddings.put("textChunk", new TableInfo.Column("textChunk", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmbeddings.put("embeddingJson", new TableInfo.Column("embeddingJson", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmbeddings.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEmbeddings = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysEmbeddings.add(new TableInfo.ForeignKey("transcripts", "CASCADE", "NO ACTION", Arrays.asList("transcriptId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesEmbeddings = new HashSet<TableInfo.Index>(1);
        _indicesEmbeddings.add(new TableInfo.Index("index_embeddings_transcriptId", false, Arrays.asList("transcriptId"), Arrays.asList("ASC")));
        final TableInfo _infoEmbeddings = new TableInfo("embeddings", _columnsEmbeddings, _foreignKeysEmbeddings, _indicesEmbeddings);
        final TableInfo _existingEmbeddings = TableInfo.read(db, "embeddings");
        if (!_infoEmbeddings.equals(_existingEmbeddings)) {
          return new RoomOpenHelper.ValidationResult(false, "embeddings(com.company.app.data.local.vector.TranscriptEmbeddingEntity).\n"
                  + " Expected:\n" + _infoEmbeddings + "\n"
                  + " Found:\n" + _existingEmbeddings);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "5b7623d89bbdc3d9dccd64c63d229e17", "f843ba4bc8e7006dac44a2ebe6c7f0ba");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "messages","calls","transcripts","embeddings");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `messages`");
      _db.execSQL("DELETE FROM `calls`");
      _db.execSQL("DELETE FROM `transcripts`");
      _db.execSQL("DELETE FROM `embeddings`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(MessageDao.class, MessageDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CallDao.class, CallDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TranscriptDao.class, TranscriptDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(EmbeddingDao.class, EmbeddingDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public MessageDao messageDao() {
    if (_messageDao != null) {
      return _messageDao;
    } else {
      synchronized(this) {
        if(_messageDao == null) {
          _messageDao = new MessageDao_Impl(this);
        }
        return _messageDao;
      }
    }
  }

  @Override
  public CallDao callDao() {
    if (_callDao != null) {
      return _callDao;
    } else {
      synchronized(this) {
        if(_callDao == null) {
          _callDao = new CallDao_Impl(this);
        }
        return _callDao;
      }
    }
  }

  @Override
  public TranscriptDao transcriptDao() {
    if (_transcriptDao != null) {
      return _transcriptDao;
    } else {
      synchronized(this) {
        if(_transcriptDao == null) {
          _transcriptDao = new TranscriptDao_Impl(this);
        }
        return _transcriptDao;
      }
    }
  }

  @Override
  public EmbeddingDao embeddingDao() {
    if (_embeddingDao != null) {
      return _embeddingDao;
    } else {
      synchronized(this) {
        if(_embeddingDao == null) {
          _embeddingDao = new EmbeddingDao_Impl(this);
        }
        return _embeddingDao;
      }
    }
  }
}
