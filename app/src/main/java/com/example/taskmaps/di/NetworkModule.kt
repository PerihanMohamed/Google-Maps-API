package com.example.taskmaps.di

import com.example.taskmaps.data.remote.ApiService
import com.example.taskmaps.util.Constants


import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton




    @Module
    @InstallIn(ApplicationComponent::class)
    object NetworkModule {

        @Singleton
        @Provides
        fun provideGsonBuilder(): Gson {
            return GsonBuilder()
                .create()
        }

        @Singleton
        @Provides
        fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
            return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        @Singleton
        @Provides
        fun provideOkHttpClientBuilder(interceptor: HttpLoggingInterceptor): OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
        }


        @Singleton
        @Provides
        fun provideAPIService(retrofit: Retrofit): ApiService {
            return retrofit
                .create(ApiService::class.java)
        }


        @Singleton
        @Provides
        fun provideRetrofit(
            okHttpClient: OkHttpClient,
            coroutineCallAdapterFactory: CoroutineCallAdapterFactory,
            gsonConverterFactory: GsonConverterFactory
        ): Retrofit {
            return Retrofit.Builder()
                .baseUrl(Constants.REMOTE_URL)
                .addCallAdapterFactory(coroutineCallAdapterFactory)
                .addConverterFactory(gsonConverterFactory)
                .client(okHttpClient)
                .build()
        }

        @Provides
        @Singleton
        fun getGsonConverterFactory(gson: Gson): GsonConverterFactory {
            return GsonConverterFactory.create(gson)
        }


        @Provides
        @Singleton
        fun getCoroutineCallAdapter(): CoroutineCallAdapterFactory {
            return CoroutineCallAdapterFactory.invoke()
        }
    }
