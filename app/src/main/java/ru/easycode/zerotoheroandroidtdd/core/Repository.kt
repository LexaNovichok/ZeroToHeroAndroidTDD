package ru.easycode.zerotoheroandroidtdd.core

import ru.easycode.zerotoheroandroidtdd.db.ItemCache
import ru.easycode.zerotoheroandroidtdd.db.ItemsDao

interface Repository {

    interface Read {
        fun list() : List<ItemCache>
        fun item(id : Long) : ItemCache
    }

    interface Delete {
        fun delete(id : Long)
    }

    interface Add {
        fun add(item : ItemCache)
    }

    interface Mutable : Read

    interface All : Read, Delete, Add

    class Base(
        private val dataSource : ItemsDao,
        private val now : Now) : All {

        override fun list(): List<ItemCache> {
            return dataSource.list()
        }

        override fun item(id: Long): ItemCache {
            return dataSource.item(id)
        }

        override fun add(item: ItemCache) {
            item.id = now.nowMillis()
            dataSource.add(item)
        }

        override fun delete(id: Long) {
            dataSource.delete(id)
        }


    }
}