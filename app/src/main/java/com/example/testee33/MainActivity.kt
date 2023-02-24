package com.example.testee33

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.testee33.network.api.Status
import com.example.testee33.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFindCitiesObserver()
        viewModel.setFindCities("")
    }

    private fun setFindCitiesObserver() {
        viewModel.findCitiesData.observe(this) {
            when (it.status) {
                Status.LOADING -> {}
                Status.SUCCESS -> {
                    if (it.data?.status == 200) {
                        Log.e("tetest", "status == 200")
                        if (it.data?.data == null) {
                            Log.e("tetest", "data == null")
                        } else {
                            Log.e("tetest", "data == null else")
                        }
                    } else {
                        Log.e("tetest", "status 200 else")
                    }
                }
                Status.ERROR -> {
                    Log.e("tetest", "ERROR")
                }
                else -> {
                    Log.e("tetest", "ELSE")
                }
            }
        }
    }
}