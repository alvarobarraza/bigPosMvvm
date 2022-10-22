package com.example.bigposmvvm.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "ProductP")
data class M_PRODUCT_P(
    val CODIGOREF:Int,
    val REFER:String,
    val NOMREF:String,
    val PORIVA: Double,
    val PRECIO: Double,
    val ID_Pedido:Int,
    val CANT:Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0

    ):Serializable
