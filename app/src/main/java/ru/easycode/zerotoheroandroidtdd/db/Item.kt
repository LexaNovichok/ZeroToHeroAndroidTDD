package ru.easycode.zerotoheroandroidtdd.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Item(
    @PrimaryKey()
    @ColumnInfo(name = "id")
    var id : Long,

    @ColumnInfo(name = "text")
    var text : String
)