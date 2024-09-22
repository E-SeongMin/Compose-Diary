package com.study.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "diary")
data class DiaryEntity(
    @ColumnInfo(name = "title") var title: String = "",
    @ColumnInfo(name = "date") var date: LocalDateTime = LocalDateTime.now(),
    @ColumnInfo(name = "content") var content: String = ""
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    override fun toString(): String {
        return "id = $id, name = ${title}, content = ${content}"
    }
}
