package com.owlcode.appcuota.features.updatepassword.domain.repository

import com.owlcode.appcuota.features.login.domain.model.Login
import com.owlcode.appcuota.features.login.domain.model.LoginResponse
import com.owlcode.appcuota.features.updatepassword.domain.model.UpdatePassword
import com.owlcode.appcuota.utils.NetworkResult

interface UpdatePasswordRepository {

    suspend fun postUpdatePassword(updatePassword: UpdatePassword): NetworkResult<Boolean>

}