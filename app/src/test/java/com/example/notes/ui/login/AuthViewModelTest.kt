package com.example.notes.ui.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.notes.models.User
import com.example.notes.models.UserRequest
import com.example.notes.models.UserResponse
import com.example.notes.repository.UserRepository
import com.example.notes.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class AuthViewModelTest {


    private val testDispatcher = StandardTestDispatcher()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var userRepository: UserRepository


    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun registerUser_Success()= runTest{
        val userRequest = UserRequest("test@gmail.com","123456", "test")
        val userResponse = UserResponse("123456ABCDEF",User("","","","",""))
        Mockito.`when`(userRepository.registerUser(userRequest))
            .thenReturn(NetworkResult.Success(userResponse))

        val authModel= AuthViewModel(userRepository)
        authModel.registerUser(userRequest)
        testDispatcher.scheduler.advanceUntilIdle()
        val response = authModel.userResponseLiveData.getOrAwaitValue()
        Assert.assertEquals(true, response is NetworkResult.Success)
        Assert.assertEquals("123456ABCDEF", response.data!!.token)
    }

    @Test
    fun registerUser_Failure()= runTest{
        val userRequest = UserRequest("test123@gmail.com","123456", "test123")
        Mockito.`when`(userRepository.registerUser(userRequest))
            .thenReturn(NetworkResult.Error("Something Went Wrong"))

        val authModel= AuthViewModel(userRepository)
        authModel.registerUser(userRequest)
        testDispatcher.scheduler.advanceUntilIdle()
        val response = authModel.userResponseLiveData.getOrAwaitValue()
        Assert.assertEquals(true, response is NetworkResult.Error)
        Assert.assertEquals("Something Went Wrong", response.message)
    }

    @Test
    fun loginUser_Success()= runTest{
        val userRequest = UserRequest("test@gmail.com","123456", "")
        val userResponse = UserResponse("123456ABCDEF",User("","","","",""))
        Mockito.`when`(userRepository.loginUser(userRequest))
            .thenReturn(NetworkResult.Success(userResponse))

        val authModel= AuthViewModel(userRepository)
        authModel.loginUser(userRequest)
        testDispatcher.scheduler.advanceUntilIdle()
        val response = authModel.userResponseLiveData.getOrAwaitValue()
        Assert.assertEquals(true, response is NetworkResult.Success)
        Assert.assertEquals("123456ABCDEF", response.data!!.token)
    }

    @Test
    fun loginUser_Failure()= runTest{
        val userRequest = UserRequest("test123@gmail.com","123456", "")
        Mockito.`when`(userRepository.loginUser(userRequest))
            .thenReturn(NetworkResult.Error("Invalid Credentials"))

        val authModel= AuthViewModel(userRepository)
        authModel.loginUser(userRequest)
        testDispatcher.scheduler.advanceUntilIdle()
        val response = authModel.userResponseLiveData.getOrAwaitValue()
        Assert.assertEquals(true, response is NetworkResult.Error)
        Assert.assertEquals("Invalid Credentials", response.message)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}

