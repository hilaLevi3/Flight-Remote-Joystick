package com.example.try12.viewModel

import com.example.try12.Model
import java.net.Socket

class ViewModel(var model: Model) {

    var client: Socket? = null

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

    var throttleVM: Int = 0
        set(value) {
            field = value
            model.throttle = value.toDouble()
            throttleString = model.throttle.toString()
        }

    var throttleString: String = model.throttle.toString()
        get() {
            return model.throttle.toString()
        }
        set(value) {
            field = value
        }


    var rudderVM: Int = 100000 // making rudder start in 0
        set(value) {
            field = value
            model.rudder = value.toDouble()
        }


    fun callConnect() {
        Thread{
            model.connect()
            if (model.client != null){
                client = model.client
            }
        }.start()
    }
}