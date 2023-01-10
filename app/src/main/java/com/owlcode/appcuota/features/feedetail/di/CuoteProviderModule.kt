package com.owlcode.appcuota.features.feedetail.di

import com.owlcode.appcuota.features.feedetail.data.remote.api.ApiQuote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CuoteProviderModule {

    @Singleton
    @Provides
    fun provideCuote(retrofit: Retrofit): ApiQuote {
        return retrofit.create(ApiQuote::class.java)
    }

}