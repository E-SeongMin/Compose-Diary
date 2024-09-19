package com.study.diary

import androidx.room.Database
import androidx.room.TypeConverters

@Database(entities = [Diary::class], version = 1, exportSchema = false)
abstract class DiaryDatabase {
}