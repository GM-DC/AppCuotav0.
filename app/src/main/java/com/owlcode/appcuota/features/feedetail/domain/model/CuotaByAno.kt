package com.owlcode.appcuota.features.feedetail.domain.model

data class CuotaByAno(
    val ano: Int,
    val cuotas: List<AllCuote>
)