package com.loc.newsapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.loc.newsapp.domain.models.Article

@Database(entities = [Article::class], version = 4, exportSchema = false)
@TypeConverters(TypeConverter::class)
abstract class NewsDatabase:RoomDatabase() {
    abstract val articleDao:ArticleDAO

}