package com.example.bigposmvvm.domain.model

data class Product(
    val codigoref: Int,
    val costo: Double,
    val estado: Int,
    val iva: Double,
    val nomref: String,
    val precios: Map<String, Double>,
    val refer: String
)