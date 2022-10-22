package com.example.bigposmvvm.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "M_TERCERO")
data class M_TERCERO(

    @PrimaryKey(autoGenerate = false)
    val NITCLI: String,
    val NOMCLI: String,
    val DIRCLI: String,
    val TELCLI: String,
    val EMAIL: String,
    val PLAZO: Int,
    val LISPRE: Int

):Serializable
