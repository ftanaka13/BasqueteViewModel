package br.com.faculdadeimpacta.basqueteviewmodel.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BasqueteViewModel : ViewModel() {

    private val placarTimeCasa = MutableLiveData<Int>(0)
    private val placarTimeVisitante = MutableLiveData<Int>(0)

    fun getPlacarTimeCasa(): LiveData<Int> = placarTimeCasa
    val getPlacarTimeVisitante: LiveData<Int> = placarTimeVisitante

    fun adicionarPontosTimeCasa(quantidadePontos: Int) {
        placarTimeCasa.value = placarTimeCasa.value?.plus(quantidadePontos)
    }

    fun adicionarPontosTimeVisitante(quantidadePontos: Int) {
        placarTimeVisitante.value = placarTimeVisitante.value?.plus(quantidadePontos)
    }

    fun resetPlacar() {
        placarTimeCasa.value = 0
        placarTimeVisitante.value = 0
    }

}