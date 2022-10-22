package com.example.bigposmvvm.domain.model

data class Datatable(
    val barcodes: List<Barcode>,
    val paymentForms: List<PaymentForm>,
    val persons: List<Person>,
    val products: List<Product>,
    val vendors: List<Vendor>
)