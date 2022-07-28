package com.weslleyqi0.soccernews.data.local;

import com.weslleyqi0.soccernews.domain.News;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {News.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
   public abstract NewsDao newsDao();
}