package com.example.guessnumbergame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guessnumbergame.databinding.FragmentFrontSideBinding

class FrontSide:BaseFragment() {
    lateinit var binding:FragmentFrontSideBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding= FragmentFrontSideBinding.inflate(inflater)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.buttonThink.setOnClickListener {
            val fragstart = requireActivity() as MainActivity
            FragmentManager.setFragAnimRight(FragmentGuessNumber(),fragstart) }
        binding.buttonGuess.setOnClickListener {
            val fragstart = requireActivity() as MainActivity
            FragmentManager.startFragmentAnimLeft(FragmentGuessPlayer(),fragstart) }
    }



    companion object {

        @JvmStatic
        fun newInstance() = FrontSide()
    }
}