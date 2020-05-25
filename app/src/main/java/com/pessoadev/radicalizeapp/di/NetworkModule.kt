package com.pessoadev.radicalizeapp.di

import com.google.firebase.firestore.FirebaseFirestore
import org.koin.dsl.module

val NetworkModule = module {
    single { FirebaseFirestore.getInstance() }
}