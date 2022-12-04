package com.example.appcuota.features.login.di

import com.example.appcuota.features.login.data.remote.LoginApi
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
    fun provideLogin(retrofit: Retrofit): LoginApi {
        return retrofit.create(LoginApi::class.java)
    }

}