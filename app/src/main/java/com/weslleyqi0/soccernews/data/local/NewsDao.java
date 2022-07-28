package com.weslleyqi0.soccernews.data.local;

import com.weslleyqi0.soccernews.domain.News;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface NewsDao {
   @Insert(onConflict = OnConflictStrategy.REPLACE)
   void save(News news);

   @Query("SELECT * FROM news WHERE favorite = 1")
   List<News> loadFavoriteNews();
}
