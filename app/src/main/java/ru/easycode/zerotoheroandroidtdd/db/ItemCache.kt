package ru.easycode.zerotoheroandroidtdd.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "items_table")
data class ItemCache(
    @PrimaryKey()
    @ColumnInfo(name = "id")
    var id : Long,

    @ColumnInfo(name = "text")
    var text : String
)