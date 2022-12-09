package com.dbs.employeeapplication

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface HistoryDao {

    @Insert
    suspend fun insert(historyEntity:HistoryEntity)
    @Insert
    suspend fun insert(dashboardEntity: DashboardEntity)

    @Query("Select * from `history-table`")
    fun fetchALlDates():Flow<List<HistoryEntity>>

    @Query("Select * from `dashboard-table`")
    fun fetchALlUsers():Flow<List<DashboardEntity>>
}