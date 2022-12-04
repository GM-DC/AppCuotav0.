package com.example.appcuota.features.datastoreglobal.di

import android.content.Context
import com.example.appcuota.features.datastoreglobal.data.DataStoreRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModel {

    @Singleton
    @Provides
    fun provideDataStoreRepository(@ApplicationContext context: Context)= DataStoreRepositoryImpl(context)

}