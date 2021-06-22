package com.example.try12
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.ServerSocket
import java.net.Socket
import java.io.PrintWriter

fun main () {
    connect()
}

// this will connect to the server (which is the flight gear)
fun connect() {
    val client = Socket("127.0.0.1", 6400)
    val output = PrintWriter(client.getOutputStream(), true)
    val input = BufferedReader(InputStreamReader(client.inputStream))

    println("Client sending [Hello]")
    output.println("set /controls/flight/aileron 0.5")
    output.flush()
    println("Client receiving [${input.readLine()}]")
    client.close()
}