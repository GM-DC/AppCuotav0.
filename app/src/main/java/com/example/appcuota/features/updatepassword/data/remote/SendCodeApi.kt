package com.example.appcuota.features.updatepassword.data.remote

import com.example.appcuota.features.updatepassword.data.remote.dto.DocIdentidadDTO

import retrofit2.http.Body
import retrofit2.http.POST

interface SendCodeApi {

    @POST("/api/Users/LoginClienteCuota/ResendCode")
    suspend fun postSendCode(@Body docIdentidad: DocIdentidadDTO)

}