package com.curso.android.app.practica.appCompara.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.curso.android.app.practica.appCompara.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.compara.observe(this){
            println("Recibimos un nuevo valor de compara. $it")
            binding.TextViewResultado.text = "${it.resultado}"

        }

        binding.buttonCompara.setOnClickListener {
            var valor1 = binding.editText1.text.toString()
            var valor2 = binding.editText2.text.toString()

            mainViewModel.CompararTextos(valor1,valor2)
        }
    }
}