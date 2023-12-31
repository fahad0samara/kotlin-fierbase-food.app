package com.fahad.tastybite.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fahad.tastybite.data.local.dao.FavoriteDao
import com.fahad.tastybite.data.local.entities.Item
import com.fahad.tastybite.data.local.dao.ItemDao
import com.fahad.tastybite.data.local.entities.FavoriteItem

@Database(entities = [Item::class, FavoriteItem::class], version = 1, exportSchema = false)
 abstract  class AppDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
    abstract fun favoriteDao(): FavoriteDao
}

