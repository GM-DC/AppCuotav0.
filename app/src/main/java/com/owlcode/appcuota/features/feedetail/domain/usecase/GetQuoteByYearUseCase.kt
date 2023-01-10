package com.owlcode.appcuota.features.feedetail.domain.usecase

import com.owlcode.appcuota.features.feedetail.domain.model.CuotaByAno
import com.owlcode.appcuota.features.feedetail.domain.repository.QuoteRepository
import com.owlcode.appcuota.utils.NetworkResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetQuoteByYearUseCase @Inject constructor(
    private val quoteRepository : QuoteRepository
) {
    operator fun invoke(docidentidad: String,ano :String): Flow<NetworkResult<List<CuotaByAno>>> {
        return quoteRepository.getCuotaByAno(docidentidad,ano)
    }
}