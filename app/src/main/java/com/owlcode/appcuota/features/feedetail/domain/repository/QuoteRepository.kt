package com.owlcode.appcuota.features.feedetail.domain.repository

import com.owlcode.appcuota.features.feedetail.domain.model.CuotaByAno
import com.owlcode.appcuota.utils.NetworkResult
import kotlinx.coroutines.flow.Flow

interface QuoteRepository {

    fun getAllCuota(ruc:String): Flow<NetworkResult<List<CuotaByAno>>>

    fun getCuotaByAno(ruc:String , ano:String): Flow<NetworkResult<List<CuotaByAno>>>

}