package com.example.try12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Thread { connect()}.start()
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
}
