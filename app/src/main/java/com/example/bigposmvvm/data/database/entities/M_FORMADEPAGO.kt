package com.example.bigposmvvm.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "M_FORMADEPAGO")
data class M_FORMADEPAGO(

    @PrimaryKey(autoGenerate = false)
    val FORPAG: String,
    val DESFROPAG: String,

):Serializable
