package com.sr.dicepractice.screens.roll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import com.sr.dicepractice.appconstants.Constants.LOG_APP_NAME
import com.sr.dicepractice.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModelRoll: ViewModelRoll by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d(" :$LOG_APP_NAME: MainActivity: :onCreate: ")
        binding = ActivityMainBinding.inflate(layoutInflater)
        val contentView = binding.root
        setContentView(contentView)
        configureBinding(binding)
    }

    private fun configureBinding(binding: ActivityMainBinding) {
        Timber.d(" :$LOG_APP_NAME: MainActivity: :configureBinding: ")
        binding.viewModel = viewModelRoll
        binding.lifecycleOwner = this
    }
}