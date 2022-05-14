package com.example.guessnumbergame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.guessnumbergame.databinding.FragmentGuessPlayerNumberBinding

import kotlin.math.roundToInt

class FragmentGuessPlayer:BaseFragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: FragmentGuessPlayerNumberBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentGuessPlayerNumberBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root

    }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
     val compNum = Math.ceil(Math.random() * 100).roundToInt()

           binding.btEnter.setOnClickListener{

              dataModel.compNumber.value = binding.edNumber.text.toString().toInt()

           dataModel.compNumber.observe(activity as LifecycleOwner){
               var playerGuess=it
               if (playerGuess<compNum){
                   binding.textView6.text=getString(R.string.smaller)}
               else if(playerGuess>compNum){
                   binding.textView6.text=getString(R.string.more_number)}
                   else if(playerGuess==compNum){
                       binding.textView6.text=getString(R.string.win)+"$compNum"
                   val fragstart = requireActivity() as MainActivity
                   FragmentManager.setFragAnimRight(FragmentEndGame.newInstance(),fragstart)
                   }

                }
           }
    //  binding.btClear.setOnClickListener {
      //    binding.edNumber.setText(" ")
      //}
  }



// companion object {
  //   @JvmStatic
   //  fun newInstance() = FragmentGuessPlayer()
// }
}