package com.owlcode.appcuota.features.updatepassword.data.remote

import com.owlcode.appcuota.features.updatepassword.data.remote.dto.UpdatePasswordDTO
import retrofit2.http.Body
import retrofit2.http.POST

interface UpdatePasswordApi {

    @POST("/api/Users/LoginClienteCuota/UpdatePassword")
    suspend fun postUpdatePassword(@Body updatePassword: UpdatePasswordDTO)

}