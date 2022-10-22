package com.example.bigposmvvm.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "M_LISTAPRECIO", primaryKeys = ["CODIGOREF", "CODLP"])
data class M_LISTAPRECIO (

    val CODIGOREF:Int,
    val CODLP:String,
    val PRECIO:Double

):Serializable