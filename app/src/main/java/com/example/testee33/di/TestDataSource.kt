package com.example.testee33.di

import com.example.testee33.network.FindCitiesResponse

interface TestDataSource {
    suspend fun requestFindCityNames(searchCity: String): FindCitiesResponse
}