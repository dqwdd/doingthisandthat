package com.example.testee33.network.api

import com.example.testee33.network.FindCitiesResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("mission/cities")
    suspend fun requestFindCitiesOfMission(
        @Query("city") city: String
    ): FindCitiesResponse

    @FormUrlEncoded
    @GET("mission/cities")
    fun getFindCitiesOfMission(
        @Query("city") city: String
    ): Call<FindCitiesResponse>

}

