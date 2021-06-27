package com.example.try12

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class Model (){

    var socketSuccess = 0
    var socketActivated = 0
    var client: Socket? = null
    lateinit var output: PrintWriter

    private var outputInit: Int = 0 // checks if we initialized the output or not

    var ip: String = ""
        set(value) {
            field = value
        }
    var portString: String = ""
        set(value) {
            field = value
            if (field != "")
                port = field.toInt()
        }
    var port: Int = 0
        set(value) {
            field = value
        }
    var throttle: Double = 0.0
        set(value) {
            field = value / 100000
            if (outputInit == 1) {
                Thread {
                    try {
                        output.print("set /controls/engines/current-engine/throttle $field\r\n")
                        output.flush()
                    } catch (exc: Exception){}
                }.start()
            }
        }

    var aileron: Double = 0.0
        set(value) {
            field = value
            if (outputInit == 1) {
                Thread {
                    try {
                        output.print("set /controls/flight/aileron $aileron\r\n") // maybe need field instead
                        output.flush()
                    } catch (exc: Exception){}
                }.start()
            }
        }

    var elevator: Double = 0.0
        set(value) {
            field = value
            if (outputInit == 1) {
                Thread {
                    try {
                        output.print("set /controls/flight/elevator $elevator\r\n")
                        output.flush()
                    } catch (exc: Exception){}
                }.start()
            }
        }

    var rudder: Double = 0.0
        set(value) {
            field = (value - 100000) / 100000
            if (outputInit == 1) {
                Thread {
                    try {
                        output.print("set /controls/flight/rudder $rudder\r\n")
                        output.flush()
                    } catch (exc: Exception){}
                }.start()
            }
        }


    // this will connect to the server (which is the flight gear)
    fun connect() {
        try {
            client = Socket(ip, port)
            socketSuccess = 1
            socketActivated = 1
            output = PrintWriter(client!!.getOutputStream(), true)
            outputInit = 1

        } catch (exception: Exception) {
            socketSuccess = 0
            socketActivated = 1
            println("Connection to flight gear failed. Try again.")
        }
    }
}