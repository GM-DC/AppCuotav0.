package com.owlcode.appcuota.features.login.data.remote

import com.owlcode.appcuota.features.login.data.remote.dto.LoginDTO
import com.owlcode.appcuota.features.login.data.remote.dto.LoginResponseDTO
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {

    @POST("/api/Users/LoginClienteCuota")
    suspend fun postLogin(@Body login: LoginDTO) : LoginResponseDTO

}