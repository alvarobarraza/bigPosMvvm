package com.example.bigposmvvm.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BarcodeM(
    val codigoref: Int,
    val estado: Int,
    val refer: String
): Parcelable