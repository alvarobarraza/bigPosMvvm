package com.example.bigposmvvm.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PersonM(
    val dircli: String,
    val email: String,
    val lispre: Int,
    val nitcli: String,
    val nomcli: String,
    val plazo: Int,
    val tecli: String
):Parcelable