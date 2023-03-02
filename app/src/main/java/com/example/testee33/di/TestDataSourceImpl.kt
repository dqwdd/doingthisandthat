package com.example.testee33.di

import com.example.testee33.network.FindCitiesResponse
import com.example.testee33.network.api.RetrofitBuilder
import javax.inject.Inject

class TestDataSourceImpl @Inject constructor(
) : TestDataSource {
    private val networkService = RetrofitBuilder.apiService

    override suspend fun requestFindCityNames(searchCity: String): FindCitiesResponse {
        return networkService.requestFindCitiesOfMission("")
    }
}