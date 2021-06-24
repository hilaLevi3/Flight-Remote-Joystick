package com.example.try12.viewModel

import com.example.try12.Model
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket
//import com.example.try12.model.*

class ViewModel(var model: Model) {
    //var model = Model()

    var ip: String = ""
        set(value) {
            field =  value
            model.ip = field
        }
    var port: String = ""
        set(value) {
            field = value
            model.portString = field
        }
    var seekBarProgress: Int = 0
        set(value) {
            field = value
            model.throttle = value.toDouble()
            println(seekBarProgress)
        }

    var textProgress: String? = null
        get() {
            return model.str
        }
        set(value) {
            field = value

        }
    fun callConnect() {
        Thread{ model.connect() }.start()
    }
}