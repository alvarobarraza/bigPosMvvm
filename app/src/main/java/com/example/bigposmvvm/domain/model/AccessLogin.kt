package com.example.bigposmvvm.domain.model

import com.example.bigposmvvm.data.database.entities.M_USER
import com.example.bigposmvvm.data.model.AccessLoginM

data class AccessLogin(
    var Perfil: String,
    var NombreUsuario: String,
    var Contraseña: String,
    var Grupo: Int,
)

fun AccessLoginM.toDomain() = AccessLogin(Perfil, NombreUsuario, Contraseña, Grupo)
fun M_USER.toDomain() = AccessLogin(Perfil, NombreUsuario, Contraseña, Grupo)
