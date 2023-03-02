package com.example.testee33.di

import com.example.testee33.network.FindCitiesResponse
import javax.inject.Inject

class FindCityRepositoryImpl @Inject constructor(
    private val testDataSource: TestDataSource
) : FindCityRepository {
    override suspend fun requestFindCityNames(cityName: String): FindCitiesResponse {
        return testDataSource.requestFindCityNames(cityName)
    }
}