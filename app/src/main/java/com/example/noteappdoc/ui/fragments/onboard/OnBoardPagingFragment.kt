package com.example.noteappdoc.ui.fragments.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.noteappdoc.R
import com.example.noteappdoc.databinding.FragmentOnBoardPegingBinding


class OnBoardPagingFragment : Fragment() {

    private var _binding: FragmentOnBoardPegingBinding? = null
    private val binding: FragmentOnBoardPegingBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardPegingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() = with(binding) {
        when(requireArguments().getInt(ARG_ONBOARD_POSITION)) {
            0->{
                onTxt.text = "Очень удобный функционал"
                binding.lottieAnimationSecond.setAnimation(R.raw.first)
            }
            1->{
                onTxt.text = "Быстрый, качественный продукт"
                binding.lottieAnimationSecond.setAnimation(R.raw.second )
            }
            2->{
                onTxt.text = "Куча функций и интересных фишек"
                binding.start.isVisible = true
                binding.lottieAnimationSecond.setAnimation(R.raw.third)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object{
        const val ARG_ONBOARD_POSITION = "onBoard"
    }
}