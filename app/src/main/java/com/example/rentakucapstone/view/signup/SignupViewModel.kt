package com.example.rentakucapstone.view.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rentakucapstone.model.UserModel
import com.example.rentakucapstone.model.UserPreference
import kotlinx.coroutines.launch

class SignupViewModel(private val pref: UserPreference) : ViewModel() {
    fun saveUser(user: UserModel) {
        viewModelScope.launch {
            pref.saveUser(user)
        }
    }
}