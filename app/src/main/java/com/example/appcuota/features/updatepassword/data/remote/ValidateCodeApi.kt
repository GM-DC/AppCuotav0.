package com.example.appcuota.features.updatepassword.data.remote

import com.example.appcuota.features.updatepassword.data.remote.dto.ValidateCodeDTO
import retrofit2.http.Body
import retrofit2.http.POST

interface ValidateCodeApi {

    @POST("/api/Users/LoginClienteCuota/ConfirmCode")
    suspend fun postValidateCode(@Body validateCode: ValidateCodeDTO)

}