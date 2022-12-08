package eu.tutorials.a7_minutesworkoutapp.dao

import androidx.room.Dao
import androidx.room.Insert
import eu.tutorials.a7_minutesworkoutapp.entity.HistoryEntity

//Todo 4 create a dao interface with insert method
@Dao
interface HistoryDao {

    @Insert
    suspend fun insert(historyEntity: HistoryEntity)
}