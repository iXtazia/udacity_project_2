package com.udacity.asteroidradar.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.MainActivity
import com.udacity.asteroidradar.R
import com.udacity.asteroidradar.adapter.AsteroidAdapter
import com.udacity.asteroidradar.databinding.FragmentMainBinding
import com.udacity.asteroidradar.item.AsteroidItem
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater)
        val data = arrayListOf<String>()

        val exempleList = generateItem(200)

        println("test$exempleList")
        asteroid_recycler.adapter = AsteroidAdapter(exempleList)
        asteroid_recycler.layoutManager = LinearLayoutManager(this)
        asteroid_recycler.setHasFixedSize(true)


//        binding.lifecycleOwner = this
//
//        binding.viewModel = viewModel
//        binding.asteroidRecycler.adapter = adapter

//        viewModel.nights


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
