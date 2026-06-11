package com.valeria.parcial2_00002024.Data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.valeria.parcial2_00002024.Data.database.entities.OptionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface OptionDao {

    @Query("SELECT * FROM options")
    //flow es un stream que emite cada vez que los datos cambian,
    //se actualiza cada que hay una adiccion o se elimina algo
    fun getAllOptions(): Flow<List<OptionEntity>>
        //si un id ya existe lo reemplaza
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //usan suspend porque no deben correr en el hilo principal
    suspend fun insertOption(option: OptionEntity)

    @Delete
    suspend fun deleteOption(option: OptionEntity)
}