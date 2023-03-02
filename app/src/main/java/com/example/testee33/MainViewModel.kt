package com.example.testee33

import androidx.lifecycle.MutableLiveData
import com.example.testee33.network.FindCityRepository
import com.example.testee33.network.api.Callback
import com.example.testee33.network.api.RetrofitBuilder
import java.lang.Exception

class MainViewModel(
    private val repository: FindCityRepository
) : BaseViewModel() {
    private val apiHelper = RetrofitBuilder.apiService

    val findCitiesData = MutableLiveData<Callback<FindCitiesResponse>>()

    fun setFindCities(inputCityName: String) {
        launchViewModelScope {
            findCitiesData.postValue(Callback.loading())
            try {
                val data = apiHelper.requestFindCitiesOfMission(inputCityName)
                findCitiesData.postValue(Callback.success(data))
            } catch (e: Exception) {
                findCitiesData.postValue(Callback.error(e.toString(), null))
            }
        }
    }

    fun loadFindCities(findCityName: String) {
        //repository.getFindCity(findCityName)
    }
}