package com.example.guessnumbergame


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.guessnumbergame.databinding.FragmentGuessNumberBinding
import kotlin.math.roundToInt

class FragmentGuessNumber:BaseFragment() {
    private val dataModel: DataModel by activityViewModels()
      var thinkNumber=" "
    lateinit var binding: FragmentGuessNumberBinding
    var min = 0
    var max = 100
    var mindRange = ((min + max) / 2).toDouble().roundToInt()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentGuessNumberBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var text = getString(R.string.if_your)+"$mindRange"+getString(R.string.press)
        binding.btEnter.setOnClickListener {
            binding.apply {
                thinkNumber=editTextTextPersonName.text.toString()
                editTextTextPersonName.visibility = View.INVISIBLE
                tvThink.text =thinkNumber

                binding.textResult.text = text
            }
        }
         choiceYourOpt()
         guessNumber()

    }








    fun choiceYourOpt(){

        binding.btSmaller.setOnClickListener {
            dataModel.choicePlayer.value=1
        }
        binding.btEquals.setOnClickListener {
            dataModel.choicePlayer.value=0
        }
        binding.btMore.setOnClickListener {
            dataModel.choicePlayer.value=2
        }
    }



    fun guessNumber() {






            dataModel.choicePlayer.observe(activity as LifecycleOwner) {

                when (it) {
                    0 -> {
                        binding.textResult.text = "your number $mindRange"
                        val fragstart = requireActivity() as MainActivity
                        FragmentManager.setFragAnimRight(FragmentEndGame.newInstance(),fragstart)
                    }
                   1 -> {
                        max = mindRange
                        mindRange = ((min + max) / 2).toDouble().roundToInt()
                       var text = getString(R.string.if_your)+"$mindRange"+getString(R.string.press)
                       binding.textResult.text =text



                    }
                   2 -> {
                        min = mindRange
                        mindRange = ((min + max) / 2).toDouble().roundToInt()
                        if (mindRange != 100) {
                            mindRange += 1
                        }
                       var text = getString(R.string.if_your)+"$mindRange"+getString(R.string.press)
                            binding.textResult.text =text



                    }
                }
            }

    }

   // companion object {

     //   @JvmStatic
       // fun newInstance() = FragmentGuessNumber()
   // }
}
