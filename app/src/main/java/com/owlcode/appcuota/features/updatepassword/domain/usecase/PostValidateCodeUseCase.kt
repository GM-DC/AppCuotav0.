package com.owlcode.appcuota.features.updatepassword.domain.usecase

import com.owlcode.appcuota.features.updatepassword.domain.model.ValidateCode
import com.owlcode.appcuota.features.updatepassword.domain.repository.CodeRepository
import com.owlcode.appcuota.utils.NetworkResult
import javax.inject.Inject

class PostValidateCodeUseCase @Inject constructor(
    private val codeRepository : CodeRepository
) {
    suspend operator fun invoke(validateCode: ValidateCode): NetworkResult<Boolean> {
        return codeRepository.postValideCode(validateCode)
    }
}