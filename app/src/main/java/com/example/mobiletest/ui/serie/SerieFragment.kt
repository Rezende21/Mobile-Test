package com.example.mobiletest.ui.serie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mobiletest.databinding.FragmentSerieBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SerieFragment : Fragment() {

    private val binding by lazy { FragmentSerieBinding.inflate(layoutInflater) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setLayout()
        setListeners()
        return binding.root
    }

    private fun setLayout() {
        TODO("Not yet implemented")
    }

    private fun setListeners() {
        TODO("Not yet implemented")
    }

}