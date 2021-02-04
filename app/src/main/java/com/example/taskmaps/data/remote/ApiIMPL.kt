package com.example.taskmaps.data.remote

import com.example.taskmaps.model.AutoResponse
import com.example.taskmaps.model.PlaceDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiIMPL @Inject
constructor(
    private val apiService: ApiService
) {

    suspend fun getAutoCompletePlaces(
        input: String
    ): AutoResponse = withContext(Dispatchers.IO) {
        apiService.getAutoCompletePlacesAsync(input = input).await()
    }

    suspend fun getPlaceDetails(
        placeId: String
    ): PlaceDetail = withContext(Dispatchers.IO) {
        apiService.getPlaceDetailsAsync(placeID = placeId).await()
    }

}