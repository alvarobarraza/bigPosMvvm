package com.example.bigposmvvm.data.database.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.bigposmvvm.domain.model.AccessLogin
import kotlinx.parcelize.Parcelize

@Entity(tableName = "M_USER")
@Parcelize
data class M_USER(
    var Perfil: String,
    @PrimaryKey(autoGenerate = false)
    var NombreUsuario: String,
    var Contraseña: String,
    var Grupo: Int,
):Parcelable

