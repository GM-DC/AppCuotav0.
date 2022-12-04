package com.example.appcuota.features.datastoreglobal.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.appcuota.features.datastoreglobal.domain.model.DataStoreModel
import com.example.appcuota.features.datastoreglobal.domain.repository.DataStoreRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

const val DataStore_NAME = "DATASTORE"

val Context.datastore : DataStore<Preferences> by  preferencesDataStore(name = DataStore_NAME)

class DataStoreRepositoryImpl @Inject constructor(
    private val context: Context
) : DataStoreRepository {

    private val NAMEUSER = stringPreferencesKey("URLBASE")
    private val DNI = stringPreferencesKey("PORT")

    override suspend fun saveDataStore(dataStoreModel: DataStoreModel) {
        context.datastore.edit { pref ->
            pref[NAMEUSER] = dataStoreModel.nameUser
            pref[DNI] = dataStoreModel.dni
        }
    }

    override suspend fun getDataStore() =
        context.datastore.data.map { pref ->
            DataStoreModel(
                nameUser = pref[NAMEUSER] ?: "",
                dni = pref[DNI] ?: "",
            )
        }

    override suspend fun cleanDataStore() {
        context.datastore.edit { pref ->
            pref.clear()
        }
    }

}