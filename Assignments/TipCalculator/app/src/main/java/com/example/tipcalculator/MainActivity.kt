package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tipButton.setOnClickListener{
            if(binding.billAmount.text.isEmpty())
            {
                binding.output.text = "YOU MUST ENTER A BILL AMOUNT"
            }
            else
            {
                binding.output.text = "The tips are as follows: \n" +
                        "\n10% = "+
                        ((binding.billAmount.text.toString().toDouble())+(.1*(binding.billAmount.text.toString().toDouble()))) +
                        "\n15% = "+
                        ((binding.billAmount.text.toString().toDouble())+(.15*(binding.billAmount.text.toString().toDouble()))) +
                        "\n20% = "+
                        ((binding.billAmount.text.toString().toDouble())+(.2*(binding.billAmount.text.toString().toDouble())))
            }
        }
    }
}