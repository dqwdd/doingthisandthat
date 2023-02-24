package com.example.testee33

data class FindCitiesResponse(
    var data: List<FindCitiesBody>,
    var message: String,
    var status: Int
)

data class FindCitiesBody(
    var cityName: String,
    var imageUrl: String,
    var latitude: Double,
    var longitude: Double
)