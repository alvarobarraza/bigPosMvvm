package com.example.bigposmvvm.ui.viewUtil

import com.example.bigposmvvm.domain.model.AccessLogin

data class LoginState (
    val isLoading : Boolean = false,
    val accessLogin: AccessLogin? = null,
    val error : String = ""
)