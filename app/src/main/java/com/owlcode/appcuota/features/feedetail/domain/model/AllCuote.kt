package com.owlcode.appcuota.features.feedetail.domain.model

data class AllCuote(
    val mes: String,
    val fechaVencimiento: String,
    val importe: String,
    val estado: String,
    val numeroSerie: String,
    val cuota: Int
)