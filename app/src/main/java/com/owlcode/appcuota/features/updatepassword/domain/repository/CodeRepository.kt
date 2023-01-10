package com.owlcode.appcuota.features.updatepassword.domain.repository

import com.owlcode.appcuota.features.updatepassword.domain.model.DocIdentidad
import com.owlcode.appcuota.features.updatepassword.domain.model.ValidateCode

import com.owlcode.appcuota.utils.NetworkResult

interface CodeRepository {

    suspend fun postSendCode(docIdentidad: DocIdentidad) : NetworkResult<Boolean>

    suspend fun postValideCode(validateCode : ValidateCode): NetworkResult<Boolean>

}