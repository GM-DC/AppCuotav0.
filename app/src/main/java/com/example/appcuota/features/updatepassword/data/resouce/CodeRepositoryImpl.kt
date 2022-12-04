package com.example.appcuota.features.updatepassword.data.resouce

import com.example.appcuota.features.updatepassword.data.remote.SendCodeApi
import com.example.appcuota.features.updatepassword.data.remote.ValidateCodeApi
import com.example.appcuota.features.updatepassword.domain.model.DocIdentidad
import com.example.appcuota.features.updatepassword.domain.model.ValidateCode
import com.example.appcuota.features.updatepassword.domain.repository.CodeRepository
import com.example.appcuota.utils.NetworkResult
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class CodeRepositoryImpl @Inject constructor(
    private val validateCodeApi: ValidateCodeApi,
    private val sendCodeApi: SendCodeApi
): CodeRepository {
    override suspend fun postSendCode(docIdentidad: DocIdentidad): NetworkResult<Boolean> {
        try {
            sendCodeApi.postSendCode(docIdentidad.toDocIdentidadDTO())
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

    override suspend fun postValideCode(validateCode: ValidateCode): NetworkResult<Boolean> {
        try {
            validateCodeApi.postValidateCode(validateCode.toValideCodeDTO())
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