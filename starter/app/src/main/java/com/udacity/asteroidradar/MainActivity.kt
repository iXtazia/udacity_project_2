package com.udacity.asteroidradar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.udacity.asteroidradar.adapter.AsteroidAdapter
import com.udacity.asteroidradar.api.NasaAPI
import com.udacity.asteroidradar.item.AsteroidItem
import kotlinx.android.synthetic.main.fragment_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private val _status = MutableLiveData<String>()
    private val _property = MutableLiveData<Asteroid>()
    val property: LiveData<Asteroid>
        get() = _property

    init {
        getNasaProperties()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun getNasaProperties() {
        println("je rentre")

        try {
            val listResult = NasaAPI.retrofitService.getProperties()
            println("je rentre $listResult")

            _status.value = "Success: ${listResult.size} Nasa test"
            println("ici" + _status.value)

            if (listResult.size > 0) {
                _property.value = listResult[0]

            }
        } catch (e: Exception) {
            println("error" + e.message)

            _status.value = "Failure: ${e.message}"
        }
    }
}
