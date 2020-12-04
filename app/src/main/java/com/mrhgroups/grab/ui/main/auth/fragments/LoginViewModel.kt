package com.mrhgroups.grab.ui.main.auth.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mrhgroups.grab.ui.main.auth.Repository



class LoginViewModel(private val repository: Repository) :ViewModel() {
    /**
     * Live Data Instance
     */
    private var mName = MutableLiveData<String>()
    fun setName(name: String) {
        if(name.length <5 ){
            mName.value="String lentgh shd be greater than 5"
        }
        mName.value=name
    }

    fun getName(): LiveData<String> {
        return mName
    }
}