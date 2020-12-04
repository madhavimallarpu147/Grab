package com.mrhgroups.grab.ui.main.auth.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mrhgroups.grab.ui.main.auth.Repository

class ViewModelFactory:ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(Repository()) as T
        }

        throw IllegalArgumentException("Unknown class name")
    }
}