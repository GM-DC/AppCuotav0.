package com.owlcode.appcuota.features.updatepassword.data.resouce

import com.owlcode.appcuota.features.updatepassword.data.remote.UpdatePasswordApi
import com.owlcode.appcuota.features.updatepassword.domain.model.UpdatePassword
import com.owlcode.appcuota.features.updatepassword.domain.repository.UpdatePasswordRepository
import com.owlcode.appcuota.utils.NetworkResult
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class UpdatePasswordRepositoryImpl @Inject constructor(
    private val updatePasswordApi: UpdatePasswordApi,
): UpdatePasswordRepository {
    override suspend fun postUpdatePassword(updatePassword: UpdatePassword): NetworkResult<Boolean> {
        try {
            updatePasswordApi.postUpdatePassword(updatePassword.toUpdatePassword())
        }catch (e: HttpException) {
            return NetworkResult.Error(
                message = "Huy! Algo salió mal",
                data = false
            )
        }catch (e: IOException) {
            return NetworkResult.Error(
                message = "No se pudo llegar al servidor, verifique su conexión a Internet",
                data = false
            )
        }catch (e: Exception) {
            return NetworkResult.Error(
                message = "Un error desconocido ocurrió",
                data = false
            )
        }
        return NetworkResult.Success(data = true)
    }

}