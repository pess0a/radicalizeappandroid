package com.pessoadev.radicalizeapp.di

import com.google.firebase.firestore.FirebaseFirestore
import com.pessoadev.radicalizeapp.presentation.main.data.MainRepository
import com.pessoadev.radicalizeapp.presentation.main.data.MainRepositoryImpl
import com.pessoadev.radicalizeapp.presentation.main.presentation.MainViewModel
import org.koin.dsl.module
import org.koin.android.viewmodel.dsl.viewModel

val AppModule = module {

    viewModel { MainViewModel(get()) }

    single { createMainRepository(get())}
}

fun createMainRepository(db : FirebaseFirestore): MainRepository {
    return MainRepositoryImpl(db)
}