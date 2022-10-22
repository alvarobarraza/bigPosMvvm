package com.example.bigposmvvm.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductM(
    val codigoref: Int,
    val costo: Double,
    val estado: Int,
    val iva: Double,
    val nomref: String,
    val precios: Map<String, Double>,
    val refer: String
):Parcelable