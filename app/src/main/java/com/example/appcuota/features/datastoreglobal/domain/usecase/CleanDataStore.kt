package com.example.appcuota.features.datastoreglobal.domain.usecase

import com.example.appcuota.features.datastoreglobal.domain.repository.DataStoreRepository
import javax.inject.Inject

class CleanDataStore @Inject constructor(
    private val dataStoreRepository : DataStoreRepository
) {
    suspend operator fun invoke() {
        return dataStoreRepository.cleanDataStore()
    }
}