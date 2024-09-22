package com.study.data.db

import androidx.room.Database
import androidx.room.TypeConverters
import com.study.data.entity.DiaryEntity
import com.study.data.util.ListConverters

@Database(entities = [DiaryEntity::class], version = 1, exportSchema = false)
@TypeConverters(ListConverters::class)
abstract class DiaryDatabase {
    abstract fun diaryDao(): DiaryDao
}