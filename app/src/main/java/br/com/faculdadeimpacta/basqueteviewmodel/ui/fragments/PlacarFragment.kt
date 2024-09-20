package br.com.faculdadeimpacta.basqueteviewmodel.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.faculdadeimpacta.basqueteviewmodel.R
import br.com.faculdadeimpacta.basqueteviewmodel.databinding.FragmentPlacarBinding


class PlacarFragment : Fragment() {

    private var _binding: FragmentPlacarBinding? = null
    private val binding get() = _binding!!
    private var placarTimeCasa = 0
    private var placarTimeVisitante = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPlacarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        binding.buttonCasa3Pontos.setOnClickListener { adicionarPontosTimeCasa(3) }
        binding.buttonCasa2Pontos.setOnClickListener { adicionarPontosTimeCasa(2) }
        binding.buttonCasa1Ponto.setOnClickListener { adicionarPontosTimeCasa(1) }

        binding.buttonVisitante3Pontos.setOnClickListener { adicionarPontosTimeVisitante(3) }
        binding.buttonVisitante2Pontos.setOnClickListener { adicionarPontosTimeVisitante(2) }
        binding.buttonVisitante1Ponto.setOnClickListener { adicionarPontosTimeVisitante(1) }

        binding.buttonReset.setOnClickListener {
            adicionarPontosTimeCasa(-placarTimeCasa)
            adicionarPontosTimeVisitante(-placarTimeVisitante)
        }
    }

    fun adicionarPontosTimeCasa(quantidadePontos: Int) {
        placarTimeCasa += quantidadePontos
        binding.textViewPlacarCasa.text = placarTimeCasa.toString()
    }

    fun adicionarPontosTimeVisitante(quantidadePontos: Int) {
        placarTimeVisitante += quantidadePontos
        binding.textViewPlacarVisitante.text = placarTimeVisitante.toString()
    }

}