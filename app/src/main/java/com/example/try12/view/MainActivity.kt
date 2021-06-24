package com.example.try12.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import com.example.try12.Model
import com.example.try12.R
import com.example.try12.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.view.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket
import com.example.try12.viewModel.*
//import com.example.try12.model.*

class MainActivity : AppCompatActivity() {

    private lateinit var bindingH: ActivityMainBinding
    lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        Thread { connect()}.start()

        bindingH = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingH.root)

        //
        var bindingL = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val model = Model()
        viewModel = ViewModel(model)
        bindingL.viewModel = viewModel



        /// connecting  to second screen
        bindingH.root.buttonNext.setOnClickListener{
            val intent = Intent(this, SecondScreen::class.java) // package contest
            startActivity(intent) // will take us from 'this' to the second activity
        }
    }




    fun connect() {
        val client = Socket("192.168.32.1", 6400)
        val output = PrintWriter(client.getOutputStream(), true)
        val input = BufferedReader(InputStreamReader(client.inputStream))

//        println("Client sending [Hello]")
        output.print("set /controls/flight/aileron 0.5"+"\r\n")
        output.flush()
        println("Client receiving [${input.readLine()}]")
        client.close()
    }

    fun clickButton(view: View) {
        // checking if ip and port are filled - assuming for now they're both filled
        findViewById<EditText>(R.id.ipBlock)
        println("inside click button")
        viewModel.callConnect()
    }
}
