package com.example.appcuota.features.feedetail.domain.repository

import com.example.appcuota.features.feedetail.domain.model.CuotaByAno
import com.example.appcuota.utils.NetworkResult
import kotlinx.coroutines.flow.Flow

interface QuoteRepository {

    fun getAllCuota(ruc:String): Flow<NetworkResult<List<CuotaByAno>>>

    fun getCuotaByAno(ruc:String , ano:String): Flow<NetworkResult<List<CuotaByAno>>>

}