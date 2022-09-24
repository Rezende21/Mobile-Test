package com.example.mobiletest.ui.details

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
import com.example.mobiletest.data.remote.VideoMovie
import com.example.mobiletest.state.ResourceState
import com.example.mobiletest.utis.Constants.BASE_URL_VIDEOS
import com.example.mobiletest.utis.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment(){

    private val args : DetailsFragmentArgs by navArgs()
    private val viewModel by viewModels<DetailsViewModel>()
    private val binding by lazy { FragmentDetailsBinding.inflate(layoutInflater) }
    var keyToVideo = arrayOfNulls<VideoMovie>(20)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initializeMediaPlayer()
        setlayout()
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.favoriteDetails.setOnClickListener {
            binding.favoriteDetails.setImageResource(R.drawable.ic_favorite)
            Toast.makeText(requireContext(), "ainda em desenvolvimento", Toast.LENGTH_LONG).show()
            //TODO implementar o favorito aqui
        }

        binding.toolbarDetails.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun setlayout() {
        viewModel.fech(args.apiMovie.toString())
        viewModel.result.observe(viewLifecycleOwner) {
            when(it) {
                is ResourceState.Success -> {
                    binding.TitleDetails.text = it.data?.title
                    binding.detailsMovieDetails.text = it.data?.overview
                    binding.voteDetails.text = it.data?.vote_average.toString()
                    loadImage(binding.posterDetails, it.data!!.poster_path)
                    keyToVideo = it.data.videos.results.toTypedArray()

                    addYoutubeMediaPleyer()
                }
                is ResourceState.Error -> {
                    Log.e("Details Fragment", "${it.message}")
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }
                is ResourceState.Loading -> {
                }
                else -> {}
            }
        }
    }

    private fun initializeMediaPlayer() {

    }

    private fun addYoutubeMediaPleyer() {
        val numberVideo = 0
        val getKeyFromList = keyToVideo[numberVideo]
        //TODO colocar um player de youtube pois esse player nao roda link de youtube
        if (getKeyFromList != null) {
            Log.i("verificar url1", BASE_URL_VIDEOS  + getKeyFromList.key)
            Log.i("verificar url2", getKeyFromList.key)
        }
    }
}
