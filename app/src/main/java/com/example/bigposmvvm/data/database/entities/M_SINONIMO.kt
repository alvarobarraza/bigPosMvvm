package com.example.bigposmvvm.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "M_SINONIMO")
data class M_SINONIMO(

    val CODIGOREF:Int,
    @PrimaryKey(autoGenerate = false)
    val REFER:String,
    val ESTADO: Int

):Serializable
