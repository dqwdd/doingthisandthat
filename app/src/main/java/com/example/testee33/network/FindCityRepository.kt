package com.example.testee33.network

import com.example.testee33.FindCitiesResponse
import com.example.testee33.network.api.ApiService
import io.reactivex.Observable
import retrofit2.Call

class FindCityRepository(private val service: ApiService) {
    fun getFindCity(cityName: String = ""): Call<FindCitiesResponse> =
            service.getFindCitiesOfMission(cityName)
}