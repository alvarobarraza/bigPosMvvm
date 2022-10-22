package com.example.bigposmvvm.data.model

import android.os.Parcelable
import com.example.bigposmvvm.data.database.entities.M_USER
import com.example.bigposmvvm.domain.model.AccessLogin
import kotlinx.parcelize.Parcelize

@Parcelize
data class AccessLoginM(
    var Perfil: String,
    var NombreUsuario: String,
    var Contraseña: String,
    var Grupo: Int,
):Parcelable{
    fun toAccessLogin(): AccessLogin {
        return AccessLogin(
            user = Perfil,
            name = NombreUsuario,
            pass = Contraseña,
            group = Grupo
        )
    }
}


