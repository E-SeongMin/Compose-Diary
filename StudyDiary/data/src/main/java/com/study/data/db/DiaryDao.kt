package com.study.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.study.data.entity.DiaryEntity
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime

@Dao
interface DiaryDao {

    @Insert
    fun insertDiary(diaryEntity: DiaryEntity)

    @Query("DELETE FROM diary where id = :id")
    fun deleteDiary(id: Long)

    @Query("DELETE FROM diary")
    fun deleteAll()

    @Query("UPDATE diary SET title = :title WHERE id = :id")
    fun updateTitle(id: Long, title: String)

    @Query("UPDATE diary SET content = :content WHERE id = :id")
    fun updateContent(id: Long, content: String)

    @Query("UPDATE diary SET date = :date WHERE id = :id")
    fun updateDate(id: Long, date: LocalDateTime)

    @Query("SELECT * FROM diary")
    fun getAll(): Flow<List<DiaryEntity>>

    @Query("SELECT * FROM diary where id = :id")
    fun getDiary(id: Long): DiaryEntity
}