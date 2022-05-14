package com.example.guessnumbergame

import androidx.appcompat.app.AppCompatActivity
var currentFragment:BaseFragment?=null
object FragmentManager {

    fun setFragment(newFrag: BaseFragment, activity: AppCompatActivity){
        val transaction = activity.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.place_holder,newFrag).commit()
        currentFragment=newFrag

    }

    open fun setFragAnimRight (newFrag: BaseFragment,activity: AppCompatActivity) {


        activity.supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.card_flip_right_in,
                R.anim.card_flip_right_out,
                R.anim.card_flip_left_in,
                R.anim.card_flip_left_out
            ).replace(R.id.place_holder, newFrag )
            .addToBackStack(null)
            .commit()

    }


    open fun startFragmentAnimLeft(newFrag: BaseFragment,activity: AppCompatActivity) {


        activity.supportFragmentManager.beginTransaction()
            .setCustomAnimations(

               R.anim.card_flip_left_in,
               R.anim.card_flip_left_out,
                R.anim.card_flip_right_in,
               R.anim.card_flip_right_out
            ).replace(R.id.place_holder, newFrag)
            .addToBackStack(null)
            .commit()

    }


}