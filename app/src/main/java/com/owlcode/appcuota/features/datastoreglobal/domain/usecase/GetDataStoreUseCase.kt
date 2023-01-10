package com.owlcode.appcuota.features.datastoreglobal.domain.usecase

import com.owlcode.appcuota.features.datastoreglobal.domain.model.DataStoreModel
import com.owlcode.appcuota.features.datastoreglobal.domain.repository.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDataStoreUseCase @Inject constructor(
    private val dataStoreRepository : DataStoreRepository
) {
    suspend operator fun invoke():Flow<DataStoreModel> {
        return dataStoreRepository.getDataStore()
    }
}