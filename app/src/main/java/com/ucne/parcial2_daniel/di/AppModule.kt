package com.ucne.parcial2_daniel.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.ucne.parcial2_daniel.data.VerbosApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi
            .Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Singleton
    @Provides
    fun provideSagApi(moshi: Moshi):VerbosApi {
        return Retrofit.Builder()
            .baseUrl("https://private-a127e-verbos.apiary-mock.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(VerbosApi::class.java)

    }
}