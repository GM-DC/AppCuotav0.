package com.example.appcuota.features.updatepassword.domain.repository

import com.example.appcuota.features.login.domain.model.Login
import com.example.appcuota.features.login.domain.model.LoginResponse
import com.example.appcuota.features.updatepassword.domain.model.UpdatePassword
import com.example.appcuota.utils.NetworkResult

interface UpdatePasswordRepository {

    suspend fun postUpdatePassword(updatePassword: UpdatePassword): NetworkResult<Boolean>

}