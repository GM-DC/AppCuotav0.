package com.owlcode.appcuota.features.feedetail.domain.usecase

import com.owlcode.appcuota.features.feedetail.domain.model.CuotaByAno
import com.owlcode.appcuota.features.feedetail.domain.repository.QuoteRepository
import com.owlcode.appcuota.features.login.domain.model.Login
import com.owlcode.appcuota.utils.NetworkResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllQuoteUseCase @Inject constructor(
    private val quoteRepository : QuoteRepository
) {
    operator fun invoke(docidentidad: String): Flow<NetworkResult<List<CuotaByAno>>> {
        return quoteRepository.getAllCuota(docidentidad)
    }
}