package com.example.testee33

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.testee33.databinding.ActivityMainBinding
import com.example.testee33.network.api.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

        binding.tvTest.setOnClickListener {
            viewModel.loadFindCities("")
        }
    }

    private fun setFindCitiesObserver() {
        viewModel.findCitiesData.observe(this) {
            when (it.status) {
                Status.LOADING -> {}
                Status.SUCCESS -> {
                    if (it.data?.status == 200) {
                        if (it.data?.data != null) {
                            Log.e("tetest", "it.data?.data != null")
                            Log.e("tetest", it.data!!.data[0].cityName)
                            Log.e("tetest", it.data!!.data[1].cityName)
                            Log.e("tetest", it.data!!.data[2].cityName)
                        }
                        else Log.e("tetest", "else - it.data?.data != null")
                    } else Log.e("tetest", "else - it.data?.status == 200")
                }
                Status.ERROR -> Log.e("tetest", "ERROR")
                else -> Log.e("tetest", "else")
            }
        }
    }

}