package com.example.notes.repository

import androidx.constraintlayout.widget.ConstraintSet.Motion
import com.example.notes.api.UserAPI
import com.example.notes.models.User
import com.example.notes.models.UserRequest
import com.example.notes.models.UserResponse
import com.example.notes.ui.login.getOrAwaitValue
import com.example.notes.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.*

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response

class UserRepositoryTest {

    private val testDispatcher = StandardTestDispatcher()

    @Mock
    lateinit var userAPI: UserAPI

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun loginUser_Success()= runTest{
        val userRequest = UserRequest("test@gmail.com","123456", "")
        val userResponse = UserResponse("123456ABCDEF", User("","","","",""))
        Mockito.`when`(userAPI.signin(userRequest)).thenReturn(Response.success(userResponse))

        val userRepository = UserRepository(userAPI)
        val response = userRepository.loginUser(userRequest)
        testDispatcher.scheduler.advanceUntilIdle()
        Assert.assertEquals(true, response is NetworkResult.Success)
        Assert.assertEquals("123456ABCDEF", response.data!!.token)
    }

    @Test
    fun loginUser_Failure()= runTest{
        val userRequest = UserRequest("test123@gmail.com","123456", "")
        Mockito.`when`(userAPI.signin(userRequest)).thenReturn(Response.error(400,"Invalid Credentials".toResponseBody()))

        val userRepository = UserRepository(userAPI)
        val response = userRepository.loginUser(userRequest)
        testDispatcher.scheduler.advanceUntilIdle()
        Assert.assertEquals(true, response is NetworkResult.Error)
        Assert.assertEquals("Something Went Wrong", response.message)
    }

    @Test
    fun registerUser_Success()= runTest{
        val userRequest = UserRequest("test@gmail.com","123456", "test")
        val userResponse = UserResponse("123456ABCDEF", User("","","","",""))
        Mockito.`when`(userAPI.signup(userRequest)).thenReturn(Response.success(userResponse))

        val userRepository = UserRepository(userAPI)
        val response = userRepository.registerUser(userRequest)
        testDispatcher.scheduler.advanceUntilIdle()
        Assert.assertEquals(true, response is NetworkResult.Success)
        Assert.assertEquals("123456ABCDEF", response.data!!.token)
    }

    @Test
    fun registerUser_Failure()= runTest{
        val userRequest = UserRequest("test123@gmail.com","123456", "test123")
        Mockito.`when`(userAPI.signup(userRequest)).thenReturn(Response.error(401,"Unauthorized".toResponseBody()))

        val userRepository = UserRepository(userAPI)
        val response = userRepository.registerUser(userRequest)
        testDispatcher.scheduler.advanceUntilIdle()
        Assert.assertEquals(true, response is NetworkResult.Error)
        Assert.assertEquals("Something Went Wrong", response.message)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}