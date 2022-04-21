package com.example.mobiletest.fragment.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.mobiletest.adapter.MovieAdapter
import com.example.mobiletest.databinding.FragmentListBinding
import com.example.mobiletest.viewmodel.MovieViewModel

class ListFragment : Fragment() {

    private val adapter by lazy { MovieAdapter() }
    private val binding by lazy { FragmentListBinding.inflate(layoutInflater) }
    private val movieViewModel: MovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        setRecycleView()
        setobserver()
        return binding.root
    }

    private fun setobserver() {
        movieViewModel.listMovie()
        movieViewModel.responsabilidade.observe(viewLifecycleOwner){ movie ->
            if (movie.isSuccessful) {
                adapter.submitList(movie.body()?.results)
            } else {
                Toast.makeText(requireContext(), "Erro na conecxão ${movie.code()}", Toast.LENGTH_LONG).show()
            }

        }
    }

    private fun setRecycleView() {
        binding.recycleview.adapter = adapter
    }
}
