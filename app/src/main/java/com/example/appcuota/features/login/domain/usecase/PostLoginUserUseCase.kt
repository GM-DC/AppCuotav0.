package com.example.appcuota.features.login.domain.usecase

import com.example.appcuota.features.login.domain.model.Login
import com.example.appcuota.features.login.domain.model.LoginResponse
import com.example.appcuota.features.login.domain.repository.LoginRepository
import com.example.appcuota.utils.NetworkResult
import javax.inject.Inject

class PostLoginUserUseCase @Inject constructor(
    private val loginUserRepository : LoginRepository
) {
    suspend operator fun invoke(login: Login): NetworkResult<LoginResponse> {
        return loginUserRepository.postLoginUser(login)
    }
}