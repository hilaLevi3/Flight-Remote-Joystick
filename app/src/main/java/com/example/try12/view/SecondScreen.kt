package com.example.try12.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.try12.databinding.ActivityMainBinding

class SecondScreen : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_second_screen)
/*
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
*/
        val actionBar = supportActionBar
        actionBar?.title = "second screen"
        actionBar?.setDisplayHomeAsUpEnabled(true)

    }
}