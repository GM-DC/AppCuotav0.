package com.example.appcuota.features.feedetail.data.remote.api

import com.example.appcuota.features.feedetail.data.remote.api.dto.CuoteByAnoDTO
import com.example.appcuota.features.feedetail.domain.model.CuotaByAno
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiQuote {

    @GET("api/CuotasComercial/GetAllCuotasComercial")
    suspend fun getRuc(@Query("Ruc") Ruc:String) : List<CuoteByAnoDTO>

    @GET("api/CuotasComercial/GetAllCuotasComercial")
    suspend fun getAnoRuc(@Query("Ruc") Ruc:String, @Query("Año") Ano:String) : List<CuoteByAnoDTO>

}