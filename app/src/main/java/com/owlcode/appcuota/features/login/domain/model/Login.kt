package com.owlcode.appcuota.features.login.domain.model

import com.owlcode.appcuota.features.login.data.remote.dto.LoginDTO


data class  Login (
    val dni: String,
    val password: String
){
    fun toLoginDTO() = LoginDTO(
        dni = dni,
        password = password
    )
}


