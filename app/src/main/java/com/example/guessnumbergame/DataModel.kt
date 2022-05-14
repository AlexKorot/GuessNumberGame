package com.example.guessnumbergame

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel:ViewModel() {
    val choicePlayer:MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()}
    val compNumber :MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
}