package com.example.appcuota.features.feedetail.domain.usecase

import com.example.appcuota.features.feedetail.domain.model.CuotaByAno
import com.example.appcuota.features.feedetail.domain.repository.QuoteRepository
import com.example.appcuota.utils.NetworkResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetQuoteByYearUseCase @Inject constructor(
    private val quoteRepository : QuoteRepository
) {
    operator fun invoke(docidentidad: String,ano :String): Flow<NetworkResult<List<CuotaByAno>>> {
        return quoteRepository.getCuotaByAno(docidentidad,ano)
    }
}