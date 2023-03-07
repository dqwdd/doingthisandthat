package com.example.testee33.di

import com.example.testee33.network.FindCitiesResponse

interface FindCityRepository {
    suspend fun requestFindCityNames(cityName: String = ""): FindCitiesResponse
}