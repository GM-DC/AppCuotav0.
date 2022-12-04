package com.example.appcuota.features.login.di

import com.example.appcuota.features.login.data.resouce.LoginRepositoryImpl
import com.example.appcuota.features.login.domain.repository.LoginRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindLoginRepository(loginRepositoryImpl: LoginRepositoryImpl) : LoginRepository

}