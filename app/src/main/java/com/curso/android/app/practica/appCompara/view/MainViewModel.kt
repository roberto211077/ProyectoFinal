package com.curso.android.app.practica.appCompara.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curso.android.app.practica.appCompara.model.Compara


class MainViewModel: ViewModel() {

    val compara: LiveData<Compara> get() = _compara

    private var _compara = MutableLiveData<Compara>(Compara(""))

    fun CompararTextos(text1: String, text2: String){
        var valor: String

        if (text1.compareTo(text2) == 0)
        {
             valor = "iguales"

        }else{
             valor = "distintos"

        }
        updateCompara(valor)
    }

    fun updateCompara(valor: String){
        _compara.value = Compara(valor)
    }


}