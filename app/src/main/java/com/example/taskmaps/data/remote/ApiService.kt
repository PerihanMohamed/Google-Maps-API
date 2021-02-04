package com.example.taskmaps.data.remote

import com.example.taskmaps.model.AutoResponse
import com.example.taskmaps.model.PlaceDetail
import com.example.taskmaps.util.*
import com.example.taskmaps.util.Constants.API_KEY
import com.example.taskmaps.util.Constants.GOOGLE_PLACE_AUTOCOMPLETE
import com.example.taskmaps.util.Constants.GOOGLE_PLACE_DETAILS
import com.example.taskmaps.util.Constants.HEADER_ACCEPT_ENCODING
import com.example.taskmaps.util.Constants.PLACE_AUTOCOMPLETE_COMPONENT
import com.example.taskmaps.util.Constants.PLACE_AUTOCOMPLETE_RADIUS
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @Headers(HEADER_ACCEPT_ENCODING)
    @GET(GOOGLE_PLACE_AUTOCOMPLETE)
    suspend fun getAutoCompletePlacesAsync(
        @Query("input") input: String?,
        @Query("components") component: String = PLACE_AUTOCOMPLETE_COMPONENT,
        @Query("radius") radius: String = PLACE_AUTOCOMPLETE_RADIUS,
        @Query("key") googleMapApiKey: String = API_KEY
    ): Deferred<AutoResponse>

    @Headers(HEADER_ACCEPT_ENCODING)
    @GET(GOOGLE_PLACE_DETAILS)
    suspend fun getPlaceDetailsAsync(
        @Query("place_id") placeID: String?,
        @Query("key") key: String = API_KEY
    ): Deferred<PlaceDetail>
}