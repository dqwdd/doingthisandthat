package com.example.testee33

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testee33.network.api.Status
import com.example.testee33.databinding.ActivityMainBinding
import com.example.testee33.endlesstest.EndlessRecyclerViewScrollListener
import com.example.testee33.endlesstest.TestAdapter

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var testAdapter: TestAdapter

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    private lateinit var scrollListener: EndlessRecyclerViewScrollListener

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

                            initAdapter()
                            initListener()

                            for (i: Int in 1..100) {
                                testAdapter.setItems(it.data!!.data)
                            }
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

    private fun initAdapter() {
        testAdapter = TestAdapter()

        val linearLayoutManager = LinearLayoutManager(this)
        binding.rvTest.layoutManager = linearLayoutManager

        scrollListener = object : EndlessRecyclerViewScrollListener(linearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                Toast.makeText(this@MainActivity, "tt", Toast.LENGTH_SHORT).show()
                Log.e("tetest", "tetetete")
            }
        }
        binding.rvTest.addOnScrollListener(scrollListener)
        binding.rvTest.adapter = testAdapter
    }

    private fun initListener() {
        testAdapter.setItemClickListener {
            Toast.makeText(this@MainActivity, it.cityName, Toast.LENGTH_SHORT).show()
            Log.e("tetest", it.cityName)
        }
    }
}