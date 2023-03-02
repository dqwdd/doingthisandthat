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
    fun loadFindCities(findCityName: String) {
        launchViewModelScope {
            Log.e("tetest11", findCityRepository.requestFindCityNames(findCityName).data[0].cityName)
            Log.e("tetest11", findCityRepository.requestFindCityNames(findCityName).data[1].cityName)
        }
    }
}