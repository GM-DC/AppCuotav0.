package com.example.appcuota.features.login.domain.model

import com.example.appcuota.features.login.data.remote.dto.LoginDTO


data class  Login (
    val dni: String,
    val password: String
){
    fun toLoginDTO() = LoginDTO(
        dni = dni,
        password = password
    )
}


