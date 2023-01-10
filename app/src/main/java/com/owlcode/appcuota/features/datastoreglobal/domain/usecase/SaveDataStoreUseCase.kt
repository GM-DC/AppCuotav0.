package com.owlcode.appcuota.features.datastoreglobal.domain.usecase

import com.owlcode.appcuota.features.datastoreglobal.domain.model.DataStoreModel
import com.owlcode.appcuota.features.datastoreglobal.domain.repository.DataStoreRepository
import javax.inject.Inject

class SaveDataStoreUseCase @Inject constructor(
    private val dataStoreRepository : DataStoreRepository
) {
    suspend operator fun invoke(dataStoreModel: DataStoreModel){
        dataStoreRepository.saveDataStore(dataStoreModel)
    }
}