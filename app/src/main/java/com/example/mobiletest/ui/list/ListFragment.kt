package com.example.mobiletest.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mobiletest.adapter.MovieAdapter
import com.example.mobiletest.databinding.FragmentListBinding
import com.example.mobiletest.data.remote.MovieApi
import com.example.mobiletest.state.ResourceState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private val adapter by lazy { MovieAdapter {
        onClik(it)
    }}
    private val binding by lazy { FragmentListBinding.inflate(layoutInflater) }
    private val movieViewModel by viewModels<MovieViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        setRecycleView()
        setobserver()
        return binding.root
    }

    private fun onClik(it: MovieApi) {
        val action = ListFragmentDirections.actionListFragmentToDetailsFragment(it.id)
        findNavController().navigate(action)
    }

    private fun setobserver() {
        movieViewModel.listMovie()
        movieViewModel.results.observe(viewLifecycleOwner){ movie ->
            when(movie) {
                is ResourceState.Success -> {
                    adapter.submitList(movie.data?.results)
                    //Toast.makeText(requireContext(), "${movie.data?.page}", Toast.LENGTH_LONG).show()
                }
                is ResourceState.Error -> {}
                is ResourceState.Loading -> {
                }
                else -> {}
            }
        }
    }

    private fun setRecycleView() {
        binding.recycleview.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.recycleview.adapter = adapter
    }
}
