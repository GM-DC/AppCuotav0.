package com.owlcode.appcuota.features.login.data.resouce

import com.owlcode.appcuota.features.login.data.remote.LoginApi
import com.owlcode.appcuota.features.login.domain.model.Login
import com.owlcode.appcuota.features.login.domain.model.LoginResponse
import com.owlcode.appcuota.features.login.domain.repository.LoginRepository
import com.owlcode.appcuota.utils.NetworkResult
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val api: LoginApi
):LoginRepository {
    override suspend fun postLoginUser(login: Login): NetworkResult<LoginResponse> {
        val response = try {
            api.postLogin(login = login.toLoginDTO())
        }catch (e: HttpException) {
            return NetworkResult.Error(
                message = "Huy! Algo salió mal",
                data = null
            )
        }catch (e: IOException) {
            return NetworkResult.Error(
                message = "No se pudo llegar al servidor, verifique su conexión a Internet",
                data = null
            )
        }catch (e: Exception) {
            return NetworkResult.Error(
                message = "Un error desconocido ocurrió",
                data = null
            )
        }
        return NetworkResult.Success(data = response.toLoginResponce())
    }

}