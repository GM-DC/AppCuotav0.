package com.example.appcuota.features.feedetail.data.remote.api.dto

import com.example.appcuota.features.feedetail.domain.model.CuotaByAno

data class CuoteByAnoDTO(
    val ano: Int,
    val cuotas: List<AllCuoteDTO>
){
    fun toCuotaByAno() = CuotaByAno(
        ano = ano,
        cuotas = cuotas.map { it.toAllCuote() }
    )

}