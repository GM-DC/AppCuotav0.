package com.example.appcuota.features.updatepassword.domain.repository

import com.example.appcuota.features.updatepassword.domain.model.DocIdentidad
import com.example.appcuota.features.updatepassword.domain.model.ValidateCode

import com.example.appcuota.utils.NetworkResult

interface CodeRepository {

    suspend fun postSendCode(docIdentidad: DocIdentidad) : NetworkResult<Boolean>

    suspend fun postValideCode(validateCode : ValidateCode): NetworkResult<Boolean>

}