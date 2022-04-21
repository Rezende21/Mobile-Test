package com.example.mobiletest.fragment.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mobiletest.R
//import com.example.mobiletest.data.Movie
import com.example.mobiletest.viewmodel.MovieViewModel

class AddFragment : Fragment() {
//    private lateinit var movieViewModel : MovieViewModel
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        var view = inflater.inflate(R.layout.fragment_add, container, false)
//            view.bt_salvar.setOnClickListener {
//                insertonDataBase()
//            }
//        movieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
//
//        return view
//    }
//
//    private fun insertonDataBase(){
//        val title = edit_Title.text.toString()
//        val director = edit_Director.text.toString()
//        //val poster = edit_Poster.text.toString() // mudar do jeito que esta nao vai funcionar
//        val release = edit_Year.text.toString()
//        val duration = edit_Duration.text.toString()
//        val description = edit_Description.text.toString()
//        val score = edit_Score.text.toString()
//
//        if (checkData(title, director, release, duration, description, score)) {
////            val movie = Movie(0, title, director, release, duration, description, score)
////            movieViewModel.addMovie(movie)
//            Toast.makeText(requireContext(), "Filme inserido com sucesso!!", Toast.LENGTH_LONG).show()
//            findNavController().navigate(R.id.action_addFragment_to_listFragment)
//        } else {
//            Toast.makeText(requireContext(), "Por favor Preenxer todos os campos", Toast.LENGTH_LONG).show()
//        }
//    }
//
//    private fun checkData(edit_Title : String, edit_Director: String, edit_Year : String, edit_Duration: String, edit_Description: String, edit_Score: String ) : Boolean {
//        return !(TextUtils.isEmpty(edit_Title) && TextUtils.isEmpty(edit_Director) && TextUtils.isEmpty(edit_Year)
//                && TextUtils.isEmpty(edit_Duration) && TextUtils.isEmpty(edit_Description)
//                && TextUtils.isEmpty(edit_Score))
//
//    }
}