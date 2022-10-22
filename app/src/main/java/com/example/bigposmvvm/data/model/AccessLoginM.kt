package com.example.bigposmvvm.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AccessLoginM(
    var Perfil: String,
    var NombreUsuario: String,
    var Contraseña: String,
    var Grupo: Int,
):Parcelable
