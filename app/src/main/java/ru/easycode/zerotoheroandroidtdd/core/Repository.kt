package ru.easycode.zerotoheroandroidtdd.core

import ru.easycode.zerotoheroandroidtdd.db.ItemCache
import ru.easycode.zerotoheroandroidtdd.db.ItemsDao

interface Repository {

    interface Read {
        fun list() : List<String>
    }

    interface Add {
        fun add(value : String)
    }
    interface Mutable : Read, Add

    class Base(
        private val dataSource : ItemsDao,
        private val now : Now
    ) : Mutable {
        override fun list(): List<String> =
            dataSource.list().map { it.text }

        override fun add(value: String) {
            val item = ItemCache(now.nowMillis(), value)
            dataSource.add(item)
        }

    }
}