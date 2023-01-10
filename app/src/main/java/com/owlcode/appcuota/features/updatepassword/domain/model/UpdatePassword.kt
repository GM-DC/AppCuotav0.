package com.owlcode.appcuota.features.updatepassword.domain.model

import com.owlcode.appcuota.features.updatepassword.data.remote.dto.UpdatePasswordDTO

data class UpdatePassword(
    val newPassword: String,
    val docIdentidad: String
){
    fun toUpdatePassword() = UpdatePasswordDTO(
        newPassword = newPassword,
        docIdentidad= docIdentidad
    )

}