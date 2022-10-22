package com.example.bigposmvvm.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DatatableM(
    val barcodes: List<BarcodeM>,
    val paymentForms: List<PaymentFormM>,
    val persons: List<PersonM>,
    val products: List<ProductM>,
    val vendors: List<VendorM>
):Parcelable