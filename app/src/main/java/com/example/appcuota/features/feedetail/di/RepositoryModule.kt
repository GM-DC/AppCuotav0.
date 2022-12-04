package com.example.appcuota.features.feedetail.di

import com.example.appcuota.features.feedetail.data.resouce.QuoteRepositoryImpl
import com.example.appcuota.features.feedetail.domain.repository.QuoteRepository
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
    abstract fun bindQuoteRepository(quoteRepositoryImpl: QuoteRepositoryImpl) : QuoteRepository

}