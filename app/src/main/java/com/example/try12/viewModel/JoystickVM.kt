package com.example.try12.viewModel

import com.example.try12.Model

class JoystickVM (var model:Model){
    var aileronVM: Double = 0.0
        set(value) {
            field = value
            model.aileron = value
        }

    var elevatorVM: Double = 0.0
        set(value) {
            field = value
            model.elevator = value
        }
}