package com.example.marveltestitau.di

import com.example.marveltestitau.data.repository.CharactersRepository
import com.example.marveltestitau.data.repository.CharactersRepositoryImpl
import com.example.marveltestitau.data.source.api.Api
import com.example.marveltestitau.data.source.remote.CharactersDataSource
import com.example.marveltestitau.data.source.remote.CharactersDataSourceImpl
import com.example.marveltestitau.domain.usecase.CharactersUseCase
import com.example.marveltestitau.domain.usecase.GetCharactersUseCaseImpl
import com.example.marveltestitau.presetation.scenes.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val BASE_URL = "https://gateway.marvel.com/v1/public/"

val useCaseModule = module {
    single<CharactersUseCase> { GetCharactersUseCaseImpl(get()) }
}

val repositoryModule = module {
    single<CharactersRepository> { CharactersRepositoryImpl(get()) }
}

val datasourceModule = module {
    single<CharactersDataSource> { CharactersDataSourceImpl(get()) }
}

val networkModule = module {
    single { provideRetrofit() }
    single { provideComicApi(get()) }
}

fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideComicApi(retrofit: Retrofit): Api {
    return retrofit.create(Api::class.java)
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
}
