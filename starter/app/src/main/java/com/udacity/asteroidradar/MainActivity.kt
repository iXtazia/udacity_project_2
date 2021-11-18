package com.udacity.asteroidradar

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.udacity.asteroidradar.adapter.AsteroidAdapter
import com.udacity.asteroidradar.api.NasaAPI
import com.udacity.asteroidradar.api.NasaApiService
import com.udacity.asteroidradar.databinding.FragmentMainBinding
import com.udacity.asteroidradar.item.AsteroidItem
import kotlinx.android.synthetic.main.asteroid_view.*
import kotlinx.android.synthetic.main.fragment_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.lang.Exception
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofitBuilder = NasaAPI.retrofitService

        val retrofitData = retrofitBuilder.getProperties()
        retrofitData.enqueue(object : Callback<List<Asteroid>> {
            override fun onResponse(
                call: Call<List<Asteroid>>,
                response: Response<List<Asteroid>>
            ) {
                val responseBody = response.body()!!

                var mystringBuilder = StringBuilder()
                for (myData in responseBody) {
                    mystringBuilder.append(myData.id)
                    mystringBuilder.append("\n")
                }

                name_text_view.text = mystringBuilder
            }

            override fun onFailure(call: Call<List<Asteroid>>, t: Throwable) {
                Log.d("MainActivity", "OnFailure: " + t.message)
            }
        })
    }
}
