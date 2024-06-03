package com.example.oneclickdriveassignment.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.oneclickdriveassignment.R
import com.example.oneclickdriveassignment.databinding.ActivityMainBinding
import com.example.oneclickdriveassignment.utils.NoConsecutiveCommasInputFilter
import com.example.oneclickdriveassignment.utils.NumberCalculator

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupClickListeners()

        binding.input1.filters = arrayOf(NoConsecutiveCommasInputFilter())
        binding.input2.filters = arrayOf(NoConsecutiveCommasInputFilter())
        binding.input3.filters = arrayOf(NoConsecutiveCommasInputFilter())

    }

    private fun setupClickListeners() {
        binding.calculate.setOnClickListener {
            validateAndCalculate()
        }
    }

    private fun validateAndCalculate() {
        if (binding.input1.text.toString().endsWith(",")) {
            binding.input1.setText(binding.input1.text.toString().removeSuffix(","))
        }

        if (binding.input2.text.toString().endsWith(",")) {
            binding.input2.setText(binding.input2.text.toString().removeSuffix(","))
        }

        if (binding.input3.text.toString().endsWith(",")) {
            binding.input3.setText(binding.input3.text.toString().removeSuffix(","))
        }

        if (binding.input1.text.toString().isEmpty() ||
            binding.input2.text.toString().isEmpty() ||
            binding.input3.text.toString().isEmpty()
        ) {
            Toast.makeText(
                this,
                getString(R.string.please_enter_all_fields),
                Toast.LENGTH_SHORT
            )
                .show()
            return
        }

        val input1 = binding.input1.text.toString().split(",").map {
            try {
                it.toInt()
            } catch (_: Exception) {
                Toast.makeText(this, getString(R.string.number_too_large), Toast.LENGTH_SHORT)
                    .show()
                return
            }
        }

        val input2 = binding.input2.text.toString().split(",").map {
            try {
                it.toInt()
            } catch (_: Exception) {
                Toast.makeText(this, getString(R.string.number_too_large), Toast.LENGTH_SHORT)
                    .show()
                return
            }
        }

        val input3 = binding.input3.text.toString().split(",").map {
            try {
                it.toInt()
            } catch (_: Exception) {
                Toast.makeText(this, getString(R.string.number_too_large), Toast.LENGTH_SHORT)
                    .show()
                return
            }
        }

        val (intersect, union, highest) = NumberCalculator().calculate(input1, input2, input3)

        binding.apply {
            answers.visibility = View.VISIBLE
            if (intersect.isEmpty()) {
                intersectionTv.text = getString(R.string.none)
            } else {
                intersectionTv.text = intersect.joinToString(",") { it.toString() }
            }
            if (union.isEmpty()) {
                unionTv.text = getString(R.string.none)
            } else {
                unionTv.text = union.joinToString(",") { it.toString() }
            }
            highestTv.text = highest.toString()
        }

    }

}