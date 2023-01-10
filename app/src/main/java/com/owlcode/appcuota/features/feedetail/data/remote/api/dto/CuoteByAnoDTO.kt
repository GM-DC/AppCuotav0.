package com.owlcode.appcuota.features.feedetail.data.remote.api.dto

import com.owlcode.appcuota.features.feedetail.domain.model.CuotaByAno

data class CuoteByAnoDTO(
    val año: Int,
    val cuotas: List<AllCuoteDTO>
){
    fun toCuotaByAno() = CuotaByAno(
        ano = año,
        cuotas = cuotas.map { it.toAllCuote() }
    )

}