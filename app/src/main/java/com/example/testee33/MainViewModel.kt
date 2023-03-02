package com.example.testee33

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.testee33.network.FindCitiesResponse
import com.example.testee33.di.FindCityRepository
import com.example.testee33.network.api.Callback
import com.example.testee33.network.api.RetrofitBuilder
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val findCityRepository: FindCityRepository
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
        launchViewModelScope {
            Log.e("tetest11", findCityRepository.requestFindCityNames(findCityName).data[0].cityName)
            Log.e("tetest11", findCityRepository.requestFindCityNames(findCityName).data[1].cityName)
        }
    }
}