package com.example.notes.repository

import com.example.notes.api.UserAPI
import com.example.notes.models.UserRequest
import com.example.notes.models.UserResponse
import com.example.notes.utils.NetworkResult
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(private val userAPI: UserAPI) {

    suspend fun registerUser(userRequest: UserRequest) : NetworkResult<UserResponse> {
        val response = userAPI.signup(userRequest)
        return handleResponse(response)
    }

    suspend fun loginUser(userRequest: UserRequest): NetworkResult<UserResponse> {
        val response = userAPI.signin(userRequest)
        return handleResponse(response)
    }

    private fun handleResponse(response: Response<UserResponse>): NetworkResult<UserResponse> {
        if (response.isSuccessful && response.body() != null) {
            return NetworkResult.Success(response.body()!!)
        } else {
            return NetworkResult.Error("Something Went Wrong")
        }
    }
}