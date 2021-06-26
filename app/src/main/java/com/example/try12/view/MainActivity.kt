package com.example.try12.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.try12.Model
import com.example.try12.R
import com.example.try12.databinding.ActivityMainBinding
import com.example.try12.viewModel.*
import com.google.android.material.snackbar.Snackbar
import com.jackandphantom.joystickview.JoyStickView


class MainActivity : AppCompatActivity() {

    private lateinit var bindingH: ActivityMainBinding
    lateinit var viewModel: ViewModel
    lateinit var joystick: Joystick
    lateinit var joystickVM: JoystickVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingH = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingH.root)

        var bindingL = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val model = Model()
        viewModel = ViewModel(model)
        bindingL.viewModel = viewModel

        // create the vm of the joystick (with the model)
        val joyStickViewVar = findViewById<JoyStickView>(R.id.joystick)
        joystickVM = JoystickVM(model)
        joystick = Joystick(joyStickViewVar, joystickVM)


        joyStickViewVar.setOnMoveListener { angle, strength ->
            joystick.setMove(angle, strength.toDouble())
       }

    }




    fun clickButton(view: View) {
        // checking if ip and port are filled - assuming for now they're both filled
        if (viewModel.ip == "" || viewModel.port == "") {
            //if one or more not filled than print something to screen
            findViewById<TextView>(R.id.error).visibility = View.VISIBLE
        } else {
            findViewById<TextView>(R.id.error).visibility = View.INVISIBLE
            println("inside click button")
            viewModel.callConnect()
            while(viewModel.model.socketActivated != 1);
            if (viewModel.model.socketSuccess == 0 ){
                val snack = Snackbar.make(view, "Connection failed, try again", Snackbar.LENGTH_LONG)
                snack.show()
            }
        }
    }


    // closing the client that stayed open.
    override fun onDestroy() {
        super.onDestroy()
        if (viewModel.client != null){
            viewModel.client!!.close()
        }
    }
}
