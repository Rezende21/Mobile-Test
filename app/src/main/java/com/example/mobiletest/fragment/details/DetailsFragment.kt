package com.example.mobiletest.fragment.details

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.media.session.MediaSessionCompat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.mobiletest.R
import com.example.mobiletest.databinding.FragmentDetailsBinding
import com.example.mobiletest.model.MovieApi
import com.example.mobiletest.utis.loadImage
import com.example.mobiletest.viewmodel.DetailsViewModel

class DetailsFragment : Fragment() {

    private val args : DetailsFragmentArgs by navArgs()
    private val viewModel : DetailsViewModel by viewModels()
    private val binding by lazy { FragmentDetailsBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setlayout()
        setListenes()
        return binding.root
    }

    private fun setListenes() {
        binding.favoriteDetails.setOnClickListener {
            binding.favoriteDetails.setImageResource(R.drawable.ic_favorite)
            Toast.makeText(requireContext(), "Filme Adicionado os favoritos", Toast.LENGTH_LONG).show()
        }
    }

    private fun setlayout() {
        viewModel.fech(args.apiMovie)
        viewModel.resultado.observe(viewLifecycleOwner) {
            if (it.isSuccessful) {
                binding.TitleDetails.text = it.body()?.title
                binding.detailsMovieDetails.text = it.body()?.overview
                loadImage(binding.posterDetails, it.body()!!.poster_path)
                binding.voteDetails.text = it.body()?.vote_average.toString()

            }
        }
    }
}
