package com.owlcode.appcuota.features.login.domain.usecase

import com.owlcode.appcuota.features.login.domain.model.Login
import com.owlcode.appcuota.features.login.domain.model.LoginResponse
import com.owlcode.appcuota.features.login.domain.repository.LoginRepository
import com.owlcode.appcuota.utils.NetworkResult
import javax.inject.Inject

class PostLoginUserUseCase @Inject constructor(
    private val loginUserRepository : LoginRepository
) {
    suspend operator fun invoke(login: Login): NetworkResult<LoginResponse> {
        return loginUserRepository.postLoginUser(login)
    }
}