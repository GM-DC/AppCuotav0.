package com.example.appcuota.features.datastoreglobal.di

import com.example.appcuota.features.datastoreglobal.data.DataStoreRepositoryImpl
import com.example.appcuota.features.datastoreglobal.domain.repository.DataStoreRepository
import com.example.appcuota.features.updatepassword.data.resouce.CodeRepositoryImpl
import com.example.appcuota.features.updatepassword.domain.repository.CodeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindDataStoreRepository(impl: DataStoreRepositoryImpl): DataStoreRepository

}