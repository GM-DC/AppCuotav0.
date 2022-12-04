package com.example.appcuota.features.datastoreglobal.domain.usecase

import com.example.appcuota.features.datastoreglobal.domain.model.DataStoreModel
import com.example.appcuota.features.datastoreglobal.domain.repository.DataStoreRepository
import javax.inject.Inject

class SaveDataStoreUseCase @Inject constructor(
    private val dataStoreRepository : DataStoreRepository
) {
    suspend operator fun invoke(dataStoreModel: DataStoreModel){
        dataStoreRepository.saveDataStore(dataStoreModel)
    }
}