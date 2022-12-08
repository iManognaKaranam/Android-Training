package eu.tutorials.a7_minutesworkoutapp.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/** Todo 3
 * Create an entity with @param [tableName]
 * Use @param [date] as primary key
 * */
@Entity(tableName = "history-table")
data class HistoryEntity(
    @PrimaryKey
    val date:String)
