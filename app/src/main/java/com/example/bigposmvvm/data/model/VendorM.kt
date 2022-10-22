package com.example.bigposmvvm.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VendorM(
    val codven: Int,
    val nitcli: String,
    val nomven: String
):Parcelable