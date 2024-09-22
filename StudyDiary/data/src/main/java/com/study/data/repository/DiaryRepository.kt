package com.study.data.repository

import com.study.data.db.DiaryDao
import com.study.data.entity.DiaryEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import java.time.LocalDateTime
import javax.inject.Inject

class DiaryRepository @Inject constructor(
    private val diaryDao: DiaryDao
) {
    val diaries: Flow<List<DiaryEntity>> = diaryDao.getAll().flowOn(Dispatchers.IO).conflate()

    suspend fun insertDiaryDao(diary: DiaryEntity) = diaryDao.insertDiary(diary)

    suspend fun deleteDiaryDao(id: Long) = diaryDao.deleteDiary(id)

    suspend fun deleteAllDao() = diaryDao.deleteAll()

    suspend fun updateDiaryDao(
        id: Long,
        title: String? = null,
        content: String? = null,
        date: LocalDateTime? = null,
    ) {
        title?.let { diaryDao.updateTitle(id, it) }
        content?.let { diaryDao.updateContent(id, it) }
        date?.let { diaryDao.updateDate(id, it) }
    }

    suspend fun getAllDao(): Flow<List<DiaryEntity>> =
        diaryDao.getAll().flowOn(Dispatchers.IO).conflate()

    suspend fun getDiaryDao(id: Long): DiaryEntity =
        diaryDao.getDiary(id)
}