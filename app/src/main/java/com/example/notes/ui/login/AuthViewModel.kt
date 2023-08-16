package com.example.notes.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.models.UserRequest
import com.example.notes.models.UserResponse
import com.example.notes.repository.UserRepository
import com.example.notes.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    private val _userResponseMutableLiveData = MutableLiveData<NetworkResult<UserResponse>>()
    val userResponseLiveData: LiveData<NetworkResult<UserResponse>>
        get() = _userResponseMutableLiveData


    fun registerUser(userRequest: UserRequest) {
        viewModelScope.launch {
            _userResponseMutableLiveData.postValue(NetworkResult.Loading())
            val response = userRepository.registerUser(userRequest)
            _userResponseMutableLiveData.postValue(response)
        }
    }

    fun loginUser(userRequest: UserRequest) {
        viewModelScope.launch {
            _userResponseMutableLiveData.postValue(NetworkResult.Loading())
            val response = userRepository.loginUser(userRequest)
            _userResponseMutableLiveData.postValue(response)
        }
    }
}