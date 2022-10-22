package com.example.bigposmvvm.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PaymentFormM(
    val desforpag: String,
    val forpag: String
):Parcelable