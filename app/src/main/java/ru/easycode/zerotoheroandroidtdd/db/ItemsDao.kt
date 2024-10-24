package ru.easycode.zerotoheroandroidtdd.db

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query

@Dao
interface ItemsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(item : ItemCache)

    @Query("SELECT * FROM items_table")
    fun list() : List<ItemCache>

    @Delete
    fun delete(id : Long)

    @Query("SELECT * FROM items_table WHERE id=:id")
    fun item(id : Long) : ItemCache
}

