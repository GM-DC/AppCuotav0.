package com.example.appcuota.features.datastoreglobal.domain.repository

import com.example.appcuota.features.datastoreglobal.domain.model.DataStoreModel
import kotlinx.coroutines.flow.Flow


interface DataStoreRepository {

    suspend fun saveDataStore(dataStoreModel: DataStoreModel)

    suspend fun getDataStore(): Flow<DataStoreModel>

    suspend fun cleanDataStore()

}