package com.example.bigposmvvm.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "M_VENDEDOR")
data class M_VENDEDOR(

    @PrimaryKey(autoGenerate = false)
    var CODVEN: Int,
    var NITCLI: String,
    var NOMVEN: String

):Serializable
