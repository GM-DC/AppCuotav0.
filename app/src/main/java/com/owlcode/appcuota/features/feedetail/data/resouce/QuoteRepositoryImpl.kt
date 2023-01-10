package com.owlcode.appcuota.features.feedetail.data.resouce

import com.owlcode.appcuota.features.feedetail.data.remote.api.ApiQuote
import com.owlcode.appcuota.features.feedetail.domain.model.CuotaByAno
import com.owlcode.appcuota.features.feedetail.domain.repository.QuoteRepository
import com.owlcode.appcuota.utils.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(
    private val api: ApiQuote
): QuoteRepository {
    override fun getAllCuota(ruc:String): Flow<NetworkResult<List<CuotaByAno>>> = flow{
        emit(NetworkResult.Loading())
        try {
            val list: MutableList<CuotaByAno> = mutableListOf()
            api.getRuc(ruc).map { it.toCuotaByAno() }.forEach { list.add(it)}

            println("list $list")

            emit(NetworkResult.Success(  data = list ))
        } catch (e: HttpException) {
            emit(
                NetworkResult.Error(
                    message = "Huy! Algo salió mal",
                    data = null
                ))
        } catch (e: IOException) {
            emit(
                NetworkResult.Error(
                    message = "No se pudo llegar al servidor, verifique su conexión a Internet",
                    data = null
                ))
        }
    }

    override fun getCuotaByAno(ruc: String, ano: String): Flow<NetworkResult<List<CuotaByAno>>> = flow{
        emit(NetworkResult.Loading())
        try {
            emit(NetworkResult.Success( api.getAnoRuc(ruc,ano).map {it.toCuotaByAno() } ))
        } catch (e: HttpException) {
            emit(
                NetworkResult.Error(
                    message = "Huy! Algo salió mal",
                    data = null
                ))
        } catch (e: IOException) {
            emit(
                NetworkResult.Error(
                    message = "No se pudo llegar al servidor, verifique su conexión a Internet",
                    data = null
                ))
        }
    }

}