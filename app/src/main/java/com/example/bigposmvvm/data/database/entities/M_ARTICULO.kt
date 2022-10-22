package com.example.bigposmvvm.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "M_ARTICULO")
data class M_ARTICULO(

    @PrimaryKey(autoGenerate = false)
    val CODIGOREF: Int,
    val REFER:String,
    var NOMREF:String,
    val COSTO:Double,
    val PORIVA:Double,
    val ESTADO: Int

):Serializable