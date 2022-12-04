package com.example.appcuota.features.updatepassword.di

import com.example.appcuota.features.updatepassword.data.resouce.CodeRepositoryImpl
import com.example.appcuota.features.updatepassword.data.resouce.UpdatePasswordRepositoryImpl
import com.example.appcuota.features.updatepassword.domain.repository.CodeRepository
import com.example.appcuota.features.updatepassword.domain.repository.UpdatePasswordRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UpdatePasswordRepositoryModule {

    @Binds
    abstract fun bindUpdatePasswordRepository(updatePasswordRepositoryImpl: UpdatePasswordRepositoryImpl) : UpdatePasswordRepository

    @Binds
    abstract fun bindCodeRepository(updatePasswordRepositoryImpl: CodeRepositoryImpl) : CodeRepository

}