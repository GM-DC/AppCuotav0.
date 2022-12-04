package com.example.appcuota.features.feedetail.data.remote.api.dto

import com.example.appcuota.features.feedetail.domain.model.AllCuote

data class AllCuoteDTO(
    val mes: String,
    val fechaVencimiento: String,
    val importe: String,
    val estado: String,
    val numeroSerie: String,
    val cuota: Int
){
    fun toAllCuote() = AllCuote(
        mes = mes,
        fechaVencimiento = fechaVencimiento,
        importe = importe,
        estado = estado,
        numeroSerie = numeroSerie,
        cuota = cuota
    )
}