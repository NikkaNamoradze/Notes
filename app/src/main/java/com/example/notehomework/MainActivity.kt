package com.example.notehomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isDigitsOnly
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.core.view.marginEnd
import androidx.core.view.marginStart
import androidx.core.view.marginTop
import com.example.notehomework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var textList = mutableListOf<String>()
    private var numList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()


        binding.btnAddField.setOnClickListener {
            val input = binding.etValue.text.toString()
            if (input.isEmpty()) {
                Toast.makeText(this, "შესაყვენი ველი ვერ იქნება ცარიელი", Toast.LENGTH_SHORT).show()
            } else if (input.isDigitsOnly() && binding.checkbox.isChecked) {
                numList.add(input.toInt())
                binding.etValue.text?.clear()
                binding.checkbox.isChecked = false
            } else if (!input.isDigitsOnly() && !binding.checkbox.isChecked) {
                textList.add(input)
                binding.etValue.text?.clear()
                binding.checkbox.isChecked = false
            } else if (!input.isDigitsOnly() && binding.checkbox.isChecked) {
                Toast.makeText(this, "მოცემული ჩანაწერი არ არის რიცხვითი", Toast.LENGTH_SHORT)
                    .show()
            } else if (input.isDigitsOnly() && !binding.checkbox.isChecked) {
                Toast.makeText(this, "მოცემული ჩანაწერი არ არის სტრიქონული", Toast.LENGTH_SHORT)
                    .show()
            }

            binding.textInputs.text = textList.toString()
            binding.numsInputs.text = numList.toString()
        }

        //თავდაპირველად ვაპირებდი რომ დინამიურად შემექმნა თითოეული ტექსტვიუ რომელსაც შეიყვანდა მომხმარებელი ედით ტექსტში
        //და პრობლემა მქონდა რომ მხოლოდ 1 ელემენტს იღებდა და ერორი მქონდა ის სქროლ ვიუ რაშიც ვსვამდი ამ ტექსტ ვიუს მხოლოდ ერთ
        //შვილობილ ვიუს იღებსო და ბოლო ეს ალტერნატივა ვნახე.

    }
}