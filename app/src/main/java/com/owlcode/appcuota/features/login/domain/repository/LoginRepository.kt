package com.owlcode.appcuota.features.login.domain.repository

import com.owlcode.appcuota.features.login.domain.model.Login
import com.owlcode.appcuota.features.login.domain.model.LoginResponse
import com.owlcode.appcuota.utils.NetworkResult


interface LoginRepository {

    suspend fun postLoginUser(login: Login): NetworkResult<LoginResponse>

}