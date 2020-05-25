package com.pessoadev.radicalizeapp.presentation.main.data

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.tasks.await

interface MainRepository {
    suspend fun getActivitiesByCity(state : String) : Task<QuerySnapshot>
}

class MainRepositoryImpl (private val db : FirebaseFirestore) : MainRepository{

    override suspend fun getActivitiesByCity(state : String): Task<QuerySnapshot> {
        return db
            .collection("activities")
            .whereEqualTo("state", state)
            .get()

    }


}