package com.example.notes.api

import com.example.notes.models.UserRequest
import com.example.notes.utils.Helpers
import com.google.gson.GsonBuilder
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class UserAPITest {

    lateinit var mockWebServer : MockWebServer
    lateinit var userAPI: UserAPI

    @Before
    fun setUp(){
        mockWebServer = MockWebServer()

        val gson = GsonBuilder()
            .setLenient()
            .create()
        userAPI = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build().create(UserAPI::class.java)
    }

    @Test
    fun login_Success()=runTest{
        val mockResponse = MockResponse()
        val content=Helpers.readFileResource("/loginResponse.json")
        mockResponse.setResponseCode(200)
        mockResponse.setBody(content)
        mockWebServer.enqueue(mockResponse)

        val userRequest = UserRequest("test@gmail.com","123456", "")
        val response = userAPI.signin(userRequest)
        mockWebServer.takeRequest()

        Assert.assertEquals(true,response.code()==200)
        Assert.assertEquals(true,response.body()?.token.equals("asdfsd23r398y29387jhkjdfbkdsd"))
    }

    @Test
    fun login_Failure()=runTest{
        val mockResponse = MockResponse()
        mockResponse.setResponseCode(400)
        mockResponse.setBody("Invalid Credentials")
        mockWebServer.enqueue(mockResponse)

        val userRequest = UserRequest("test123@gmail.com","123456", "")
        val response = userAPI.signin(userRequest)
        mockWebServer.takeRequest()

        Assert.assertEquals(true,response.code()==400)
    }


    @After
    fun tearDown(){
        mockWebServer.shutdown()
    }
}