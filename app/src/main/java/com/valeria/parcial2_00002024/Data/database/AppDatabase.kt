package com.valeria.parcial2_00002024.Data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.valeria.parcial2_00002024.Data.database.dao.OptionDao
import com.valeria.parcial2_00002024.Data.database.entities.OptionEntity

//se declara las entities y da acces a los daos

@Database(
    entities = [OptionEntity::class],
    //cuando se agrege otra tabla sube
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun optionDao(): OptionDao

    companion object {
        //Volatile y syncronized hacen que no se creen dos instancias
        @Volatile
        private var INSTANCE: AppDatabase? = null

        //companion object hace que toda la app exista
        //en una sola instancia de datos (singleton)
        fun getDatabase(context: Context): AppDatabase{
            return INSTANCE ?: synchronized(this){
                Room.databaseBuilder(
                    //context.applicationContext se utiliza para no fugar memoria
                    context = context.applicationContext,
                    klass = AppDatabase::class.java,
                    name = "rankeduca_database"
                )
                    .fallbackToDestructiveMigration(false)
                    .build()
                    .also {INSTANCE = it}
            }
        }
    }
}