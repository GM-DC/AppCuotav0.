package com.owlcode.appcuota.features.updatepassword.domain.usecase

import com.owlcode.appcuota.features.login.domain.model.Login
import com.owlcode.appcuota.features.login.domain.model.LoginResponse
import com.owlcode.appcuota.features.login.domain.repository.LoginRepository
import com.owlcode.appcuota.features.updatepassword.domain.model.UpdatePassword
import com.owlcode.appcuota.features.updatepassword.domain.repository.UpdatePasswordRepository
import com.owlcode.appcuota.utils.NetworkResult
import javax.inject.Inject

class UpdatePasswordUseCase @Inject constructor(
    private val updatePasswordRepository : UpdatePasswordRepository
) {
    suspend operator fun invoke(updatePassword: UpdatePassword): NetworkResult<Boolean> {
        return updatePasswordRepository.postUpdatePassword(updatePassword)
    }
}