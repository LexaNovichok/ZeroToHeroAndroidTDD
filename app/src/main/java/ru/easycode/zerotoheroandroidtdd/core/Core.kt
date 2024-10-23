package ru.easycode.zerotoheroandroidtdd.core

import android.content.Context
import androidx.room.Room
import ru.easycode.zerotoheroandroidtdd.db.ItemsDataBase

class Core(private val context : Context) {

    private val database by lazy {
            Room.databaseBuilder(
            context.applicationContext,
            ItemsDataBase::class.java,
            "text.db"
        ).build()
    }

    fun dao() = database.itemsDao()
}