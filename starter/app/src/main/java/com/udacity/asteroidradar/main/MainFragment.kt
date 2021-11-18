package com.udacity.asteroidradar.main

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.Constants
import com.udacity.asteroidradar.MainActivity
import com.udacity.asteroidradar.R
import com.udacity.asteroidradar.adapter.AsteroidAdapter
import com.udacity.asteroidradar.api.NasaAPI
import com.udacity.asteroidradar.api.NasaApiService
import com.udacity.asteroidradar.api.getNextSevenDaysFormattedDates
import com.udacity.asteroidradar.databinding.FragmentMainBinding
import com.udacity.asteroidradar.item.AsteroidItem
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.lang.Exception
import java.lang.StringBuilder
import javax.security.auth.callback.Callback

class MainFragment : Fragment() {


    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater)
        val exempleList = generateItem(200)



//        val retrofitData = NasaAPI.retrofitService.getProperties()

//        println("hey" + retrofitData)

//        retrofitData.enqueue(object : retrofit2.Callback<List<Asteroid>?> {
//            override fun onResponse(
//                call: Call<List<Asteroid>?>,
//                response: Response<List<Asteroid>?>
//            ) {
//                val responseBody = response.body()!!
//                val stringBuilder = StringBuilder()
//
//                for (myData in responseBody) {
//                    stringBuilder.append(myData.id)
//                    stringBuilder.append("\n")
//                }
//            }
//
//            override fun onFailure(call: Call<List<Asteroid>?>, t: Throwable) {
//                println("Error" + t.message)
//            }
//        })

        binding.apply {
            asteroidRecycler.adapter = AsteroidAdapter(exempleList)
            asteroidRecycler.layoutManager = LinearLayoutManager(requireContext())
            asteroidRecycler.setHasFixedSize(true)
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    private fun generateItem(size: Int): List<AsteroidItem> {
        val list = ArrayList<AsteroidItem>()

        for (i in 0 until size) {
            val item = AsteroidItem("Text $i", "text2")
            list += item
        }
        return list
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return true
    }
}
