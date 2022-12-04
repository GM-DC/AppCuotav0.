package com.example.appcuota.features.login.domain.repository

import com.example.appcuota.features.login.domain.model.Login
import com.example.appcuota.features.login.domain.model.LoginResponse
import com.example.appcuota.utils.NetworkResult


interface LoginRepository {

    suspend fun postLoginUser(login: Login): NetworkResult<LoginResponse>

}