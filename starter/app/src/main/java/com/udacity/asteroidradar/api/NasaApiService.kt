package com.udacity.asteroidradar.api

import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.Constants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

val retrofit = Retrofit.Builder()
    .baseUrl(Constants.BASE_URL)
    .addConverterFactory(ScalarsConverterFactory.create())
    .build()

interface NasaApiService {
    @GET("neo/rest/v1/feed?start_date=2015-09-07&end_date=2015-09-08&api_key=${Constants.API_KEY}")
    fun getProperties(): Call<List<Asteroid>>

    @GET("planetary/apod?api_key=${Constants.API_KEY}")
    fun getPictureOfTheDay(): Call<List<Asteroid>>
}

object NasaAPI {
    val retrofitService: NasaApiService by lazy {
        retrofit.create(NasaApiService::class.java)
    }
}