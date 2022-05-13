package com.example.mobiletest.fragment.details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.mobiletest.R
import com.example.mobiletest.databinding.FragmentDetailsBinding
import com.example.mobiletest.model.VideoMovie
import com.example.mobiletest.utis.Constants.API_KEY
import com.example.mobiletest.utis.Constants.TAG_VIDEOS
import com.example.mobiletest.utis.loadImage
import com.example.mobiletest.viewmodel.DetailsViewModel
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import okhttp3.Cache.key

class DetailsFragment : Fragment(), Player.Listener{

    private val args : DetailsFragmentArgs by navArgs()
    private val viewModel : DetailsViewModel by viewModels()
    private val binding by lazy { FragmentDetailsBinding.inflate(layoutInflater) }
    private lateinit var player : ExoPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setlayout()
        setFavoriteListene()
        initializeMediaPlayer()
        return binding.root
    }

    private fun setFavoriteListene() {
        binding.favoriteDetails.setOnClickListener {
            binding.favoriteDetails.setImageResource(R.drawable.ic_favorite)
            Toast.makeText(requireContext(), "Filme Adicionado os favoritos", Toast.LENGTH_LONG).show()
            //TODO implementar o favorito aqui
        }
    }

    private fun setlayout() {
        viewModel.fech(args.apiMovie, API_KEY, TAG_VIDEOS)
        viewModel.resultado.observe(viewLifecycleOwner) {
            if (it.isSuccessful) {
                binding.TitleDetails.text = it.body()?.title
                binding.detailsMovieDetails.text = it.body()?.overview
                loadImage(binding.posterDetails, it.body()!!.poster_path)
                binding.voteDetails.text = it.body()?.vote_average.toString()
                Log.i("Key from video", it.body()?.videos?.results.toString())
            }
        }
    }

    private fun initializeMediaPlayer() {
        player = ExoPlayer.Builder(requireContext()).build()
        binding.mediaplayer.player = player
        player.addListener(this)
    }

    private fun addYoutubeMediaPleyer() {
        //TODO Implementar o media pleyer
//        val youtubeplayer = MediaItem.fromUri(//colocar a url)
//        player.addMediaItem(youtubeplayer)
//        player.prepare()
    }
}
