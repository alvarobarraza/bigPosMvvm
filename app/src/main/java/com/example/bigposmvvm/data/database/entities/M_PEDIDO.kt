package com.example.bigposmvvm.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Pedido")
data class M_PEDIDO(

    @PrimaryKey(autoGenerate = true)
    val ID_Pedido: Int = 0,

    val cliente: String,
    val vendedor: Int,
    val fPago: String,
    val desc: Double,
    val comentario: String,
    val total: Double

):Serializable
