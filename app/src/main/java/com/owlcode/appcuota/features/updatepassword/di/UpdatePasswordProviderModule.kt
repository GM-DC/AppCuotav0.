package com.owlcode.appcuota.features.updatepassword.di

import com.owlcode.appcuota.features.updatepassword.data.remote.SendCodeApi
import com.owlcode.appcuota.features.updatepassword.data.remote.ValidateCodeApi
import com.owlcode.appcuota.features.updatepassword.data.remote.UpdatePasswordApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UpdatePasswordProviderModule {

    @Singleton
    @Provides
    fun provideUpdatePassword(retrofit: Retrofit): UpdatePasswordApi {
        return retrofit.create(UpdatePasswordApi::class.java)
    }

    @Singleton
    @Provides
    fun provideSendCode(retrofit: Retrofit): SendCodeApi {
        return retrofit.create(SendCodeApi::class.java)
    }

    @Singleton
    @Provides
    fun provideValidateCode(retrofit: Retrofit): ValidateCodeApi {
        return retrofit.create(ValidateCodeApi::class.java)
    }
}