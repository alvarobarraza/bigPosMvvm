package com.example.bigposmvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bigposmvvm.data.database.dao.BigPosDao
import com.example.bigposmvvm.data.database.entities.M_USER
import com.example.bigposmvvm.data.database.entities.*


@Database(entities = [
    M_PEDIDO::class,
    M_PRODUCT_P::class,
    M_FORMADEPAGO::class,
    M_TERCERO::class,
    M_ARTICULO::class,
    M_LISTAPRECIO::class,
    M_SINONIMO::class,
    M_VENDEDOR::class,
    M_USER::class], version = 1)
abstract class AppDataBase:RoomDatabase() {

    abstract fun BdBigpos(): BigPosDao

    /*companion object{
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDataBase(context: Context):AppDataBase{
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "app_database"
                ).build()

                INSTANCE = instance

                return instance
            }
        }
    }*/

}