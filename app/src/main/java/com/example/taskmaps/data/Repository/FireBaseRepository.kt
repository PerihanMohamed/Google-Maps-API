package com.example.taskmaps.data.Repository

import com.example.taskmaps.data.local.firebase.Firebase
import com.example.taskmaps.model.UserData
import com.example.taskmaps.util.Resource
import com.google.firebase.firestore.auth.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FireBaseRepository @Inject constructor(val firebase: Firebase){

    suspend fun getSourceLocations(): Flow<Resource<List<UserData>>> = flow {
        emit(Resource.loading(data = null))
        println("it.data.toString()")
        emit(Resource.success(firebase.getSourceLocations().documents.mapNotNull {
            it.toObject(UserData::class.java)
        }))
    }.catch {
        emit(Resource.error(data = null, msg = "Something went wrong!"))
    }


}