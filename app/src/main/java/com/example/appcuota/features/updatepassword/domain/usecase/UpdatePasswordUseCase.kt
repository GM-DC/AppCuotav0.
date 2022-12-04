package com.example.appcuota.features.updatepassword.domain.usecase

import com.example.appcuota.features.login.domain.model.Login
import com.example.appcuota.features.login.domain.model.LoginResponse
import com.example.appcuota.features.login.domain.repository.LoginRepository
import com.example.appcuota.features.updatepassword.domain.model.UpdatePassword
import com.example.appcuota.features.updatepassword.domain.repository.UpdatePasswordRepository
import com.example.appcuota.utils.NetworkResult
import javax.inject.Inject

class UpdatePasswordUseCase @Inject constructor(
    private val updatePasswordRepository : UpdatePasswordRepository
) {
    suspend operator fun invoke(updatePassword: UpdatePassword): NetworkResult<Boolean> {
        return updatePasswordRepository.postUpdatePassword(updatePassword)
    }
}