package com.example.try12

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class Model (var _throttle: Double = 0.0){

    var ip: String = ""
        set(value) {
            field = value
            println("inside model ip setter")
            println("ip is:$field")
        }
    var portString: String = ""
        set(value) {
            field = value
            if (field != "")
                port = field.toInt()
            println("inside model portString setter")
            println("port is:$field")
        }
    var port: Int = 0
        set(value) {
            field = value
            println("inside model port setter")
            println("port is:$field")
        }
    var throttle: Double = _throttle
        set(value) {
            field = value / 100000
            println("throttle is:$field")
            updateStr()
        }
    var str: String = ""

    fun updateStr() {
        str = throttle.toString()
    }

    // this will connect to the server (which is the flight gear)
    fun connect() {

        try {
//            val client = Socket("192.168.32.1", 6400)
            val client = Socket(ip, port)
            val output = PrintWriter(client.getOutputStream(), true)
            val input = BufferedReader(InputStreamReader(client.inputStream))

            println("Client sending [Hello]")
            output.print("set /controls/flight/aileron $throttle"+"\r\n")
            output.flush()
            println("Client receiving [${input.readLine()}]")
            client.close()
        } catch (str: Exception) {
            println(str)
        }
    }
}