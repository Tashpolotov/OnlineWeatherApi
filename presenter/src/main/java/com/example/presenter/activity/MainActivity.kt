package com.example.presenter.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.presenter.R
import com.example.presenter.databinding.ActivityMainBinding
import com.example.presenter.fragment.WeatherFirstFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val fragment = WeatherFirstFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fr_container, fragment).commit()

    }
}