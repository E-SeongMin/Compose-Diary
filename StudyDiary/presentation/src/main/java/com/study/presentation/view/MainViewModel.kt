package com.study.presentation.view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.data.entity.DiaryEntity
import com.study.data.repository.DiaryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: DiaryRepository
) : ViewModel() {

    private val _diaries = MutableStateFlow<List<DiaryEntity>>(emptyList())
    val diaries = _diaries.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllDao().distinctUntilChanged().collect { diaryList ->
                if (diaryList.isEmpty()) {
                    Log.d("test", "diaryList is Empty")
                } else {
                    _diaries.value = diaryList
                }
            }
        }
    }

}