package br.com.faculdadeimpacta.basqueteviewmodel.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import br.com.faculdadeimpacta.basqueteviewmodel.R
import br.com.faculdadeimpacta.basqueteviewmodel.databinding.FragmentPlacarBinding
import br.com.faculdadeimpacta.basqueteviewmodel.ui.viewmodels.BasqueteViewModel


class PlacarFragment : Fragment() {

    private var _binding: FragmentPlacarBinding? = null
    private val binding get() = _binding!!
    private val viewModel: BasqueteViewModel by viewModels()

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

        viewModel.getPlacarTimeCasa().observe(viewLifecycleOwner) { pontos ->
            binding.textViewPlacarCasa.text = pontos.toString()
        }
        viewModel.getPlacarTimeVisitante.observe(viewLifecycleOwner) { pontos ->
            binding.textViewPlacarVisitante.text = pontos.toString()
        }

        binding.buttonCasa3Pontos.setOnClickListener { viewModel.adicionarPontosTimeCasa(3) }
        binding.buttonCasa2Pontos.setOnClickListener { viewModel.adicionarPontosTimeCasa(2) }
        binding.buttonCasa1Ponto.setOnClickListener { viewModel.adicionarPontosTimeCasa(1) }

        binding.buttonVisitante3Pontos.setOnClickListener { viewModel.adicionarPontosTimeVisitante(3) }
        binding.buttonVisitante2Pontos.setOnClickListener { viewModel.adicionarPontosTimeVisitante(2) }
        binding.buttonVisitante1Ponto.setOnClickListener { viewModel.adicionarPontosTimeVisitante(1) }

        binding.buttonReset.setOnClickListener { viewModel.resetPlacar() }
    }

}