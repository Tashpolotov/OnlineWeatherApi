package com.example.presenter.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.domain.model.WeatherInHourModel
import com.example.presenter.R
import com.example.presenter.WeatherAdapter
import com.example.presenter.databinding.FragmentWeatherFirstBinding
import com.example.presenter.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class WeatherFirstFragment : Fragment() {

    private lateinit var binding: FragmentWeatherFirstBinding
    private val adapter = WeatherAdapter()
    private val viewModel by viewModels<WeatherViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWeatherFirstBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvWeatherHour.adapter = adapter
        getInit()


        lifecycleScope.launchWhenCreated {
            viewModel.weatherInHourToday.collect{
                adapter.submitList(it)
            }
        }
        viewModel.getLoadWeatherInHourToday()
    }


    private fun getInit() {

    }
}