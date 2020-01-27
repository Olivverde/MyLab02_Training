package com.example.mylab02_trainingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

//Import all the necessary packages
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //attributes
    private lateinit var count: TextView
    private lateinit var pic: ImageView
    private var endGame = 20
    private var totalRounds = 0

    /**
     * Initialize the app
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        count = findViewById(R.id.count_0)
        pic = findViewById(R.id.pics)
    }

    /**
     * Runs the lap's button. Shows an alert in lap #10 and #20. Congrats the user when he reaches
     * the maximum amount of laps
     */
    fun round(view: View){

        accounting_button.setOnLongClickListener(){
            Toast.makeText(this, "Faltan ${endGame - totalRounds} para alcanzar la meta", Toast.LENGTH_SHORT).show()
            true
        }

        //If the amount of laps is less than 20
        if(totalRounds < 20){
            totalRounds += 1
            var t = totalRounds.toString()
            count.setText(t)
        }

        //If the user accomplish 20 laps, it will be congratulated
        if (totalRounds == 20){
            pic.setImageResource(R.drawable.trophy)
            Toast.makeText(this,"Has logrado la meta",Toast.LENGTH_LONG).show()

        }
        //If the user accomplish 10 laps, an alert will be showed
        else if (totalRounds == 10){
            pic.setImageResource(R.drawable.waifu)

        }
        //If the user haven't accomplished any of the two goals, nothing will be showed
        else{
            pic.setImageResource(R.drawable.background)
        }

    }

    /**
     * Runs the restart's button. Sets the lap's value to zero and remove all the congrats
     */
    fun restart(view: View){

        totalRounds = 0
        var t = totalRounds.toString()
        count.setText(t)
        pic.setImageResource(R.drawable.background)
    }
}
