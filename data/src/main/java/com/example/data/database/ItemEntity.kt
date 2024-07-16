package com.example.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items_table")
data class ItemEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "image") val image: Int,
    @ColumnInfo(name = "is_obtained") val isObtained: Boolean
)