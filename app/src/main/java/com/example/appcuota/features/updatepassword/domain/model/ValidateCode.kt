package com.example.appcuota.features.updatepassword.domain.model

import com.example.appcuota.features.updatepassword.data.remote.dto.ValidateCodeDTO

data class ValidateCode(
    val code: String,
    val docIdentidad: String
){
    fun toValideCodeDTO() = ValidateCodeDTO(
        code = code,
        docIdentidad = docIdentidad
    )

}