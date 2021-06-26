package com.example.try12.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.try12.viewModel.JoystickVM
import com.jackandphantom.joystickview.JoyStickView
import kotlin.math.cos
import kotlin.math.sin

class Joystick (joystickView: JoyStickView, var joystickVM: JoystickVM) : AppCompatActivity(){
    var joystick: JoyStickView = joystickView

    var elevator:Double = 0.0
    var aileron:Double = 0.0

    fun setMove(angle: Double, strength: Double){
        elevator = (sin(angle) * strength) / 100
        aileron = (cos(angle) * strength) / 100
        joystickVM.aileronVM = aileron
        joystickVM.elevatorVM = elevator
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
    }
}