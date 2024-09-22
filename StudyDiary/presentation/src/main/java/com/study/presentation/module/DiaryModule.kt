package com.study.presentation.module

import com.study.data.db.DiaryDao
import com.study.data.db.DiaryDatabase
import com.study.data.repository.DiaryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DiaryModule {
    @Singleton
    @Provides
    fun provideDiaryDao(diaryDatabase: DiaryDatabase): DiaryDao = diaryDatabase.diaryDao()

    @Singleton
    @Provides
    fun provideDiaryRepository(diaryDao: DiaryDao): DiaryRepository = DiaryRepository(diaryDao)
}