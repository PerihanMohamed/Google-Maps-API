package com.example.taskmaps.data.Repository

import com.example.taskmaps.data.remote.ApiIMPL
import com.example.taskmaps.model.AutoResponse
import com.example.taskmaps.model.PlaceDetail
import com.example.taskmaps.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class RetrofitRepository @Inject
constructor(
    private val apiServiceImpl: ApiIMPL
) {
    suspend fun getPlacesFromAutocomplete(input: String): Flow<Resource<AutoResponse>> =
        flow {
            emit(Resource.loading(data = null))
            Resource.success(apiServiceImpl.getAutoCompletePlaces(input))
        }.catch {
            Resource.error(data = null, msg = "Something went wrong!")
        }

    suspend fun getPlaceDetails(placeId: String): Flow<Resource<PlaceDetail>> =
        flow {
            emit(Resource.loading(data = null))
            Resource.success(apiServiceImpl.getPlaceDetails(placeId))
        }.catch {
            Resource.error(data = null, msg = "Something went wrong!")
        }

}