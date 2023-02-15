package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception
import javax.xml.xpath.XPathExpression

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btn0.setOnClickListener {
            appendVal("0", false)
        }
        binding.btn1.setOnClickListener {
            appendVal("1", false)
        }
        binding.btn2.setOnClickListener {
            appendVal("2", false)
        }
        binding.btn3.setOnClickListener {
            appendVal("3", false)
        }
        binding.btn4.setOnClickListener {
            appendVal("4", false)
        }
        binding.btn5.setOnClickListener {
            appendVal("5", false)
        }
        binding.btn6.setOnClickListener {
            appendVal("6", false)
        }
        binding.btn7.setOnClickListener {
            appendVal("7", false)
        }
        binding.btn8.setOnClickListener {
            appendVal("8", false)
        }
        binding.btn9.setOnClickListener {
            appendVal("9", false)
        }
        binding.btnDot.setOnClickListener {
            appendVal(".", false)
        }



        binding.btnMult.setOnClickListener {
            appendVal("*", false)
        }
        binding.btnDiv.setOnClickListener {
            appendVal("/", false)
        }
        binding.btnAdd.setOnClickListener {
            appendVal("+", false)
        }
        binding.btnSub.setOnClickListener {
            appendVal("-", false)
        }
        binding.btnClear.setOnClickListener {
            binding.display.text = ""
            binding.answer.text = ""
        }


        binding.btnBack.setOnClickListener {
            val expression = binding.display.text.toString()
            if (expression.isNotEmpty()) {
                binding.display.text = expression.substring(0, expression.length - 1)
            }
        }

        binding.btnEqual.setOnClickListener {
            try {
                val expression = ExpressionBuilder(binding.display.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    binding.answer.text = longResult.toString()
                } else
                    binding.answer.text = result.toString()
            } catch (e: Exception) {
                Log.d("EXCEPTION", "Message: ${e.message}")
            }
            appendVal("", true)
        }
    }

    private fun appendVal(string: String, isClear: Boolean) {
        if (isClear) {
            binding.display.text = ""
            binding.display.append(string)
        } else {
            binding.display.append(string)

        }
    }
}