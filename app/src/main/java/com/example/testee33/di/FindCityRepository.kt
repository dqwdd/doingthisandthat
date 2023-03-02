package com.example.testee33.di

import com.example.testee33.network.FindCitiesResponse
import com.example.testee33.network.api.Callback

interface FindCityRepository {
    suspend fun requestFindCityNames(cityName: String = ""): FindCitiesResponse
}