package com.example.mobiletest.fragment.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobiletest.R
import com.example.mobiletest.adapter.MovieAdapter
import com.example.mobiletest.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment() {

    private lateinit var movieViewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_list, container, false)
            view.btfloat.setOnClickListener {
                findNavController().navigate(R.id.action_listFragment_to_addFragment)
            }
            setHasOptionsMenu(true)

            val adapter = MovieAdapter()
            val recyclerView = view.recycleview
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())

            movieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
            movieViewModel.readAllData.observe(viewLifecycleOwner, Observer { movie ->
                adapter.setData(movie)
            })


        return view
    }

}