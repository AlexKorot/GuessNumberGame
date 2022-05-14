package com.example.guessnumbergame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guessnumbergame.databinding.FragmentEndGameBinding
import com.example.guessnumbergame.databinding.FragmentGuessNumberBinding

class FragmentEndGame:BaseFragment() {
    lateinit var binding: FragmentEndGameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentEndGameBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btPlay.setOnClickListener {
            val fragstart = requireActivity() as MainActivity

         //   FragmentManager.setFragAnimRight(FrontSide(),fragstart)
 fragstart.finish()

        }
    }


    companion object {

        @JvmStatic
        fun newInstance() = FragmentEndGame()
    }
}