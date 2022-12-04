package com.example.appcuota.features.updatepassword.domain.usecase

import com.example.appcuota.features.updatepassword.domain.model.DocIdentidad
import com.example.appcuota.features.updatepassword.domain.repository.CodeRepository
import com.example.appcuota.utils.NetworkResult
import javax.inject.Inject

class PostSendCodeUseCase @Inject constructor(
    private val codeRepository : CodeRepository
) {
    suspend operator fun invoke(docIdentidad: DocIdentidad) : NetworkResult<Boolean>{
        return codeRepository.postSendCode(docIdentidad)
    }
}