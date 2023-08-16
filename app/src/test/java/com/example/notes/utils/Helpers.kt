package com.example.notes.utils

import java.io.InputStreamReader

object Helpers {

    fun readFileResource(fileName : String) : String{
        val inputStream = Helpers::class.java.getResourceAsStream(fileName)
        val builder = StringBuilder()
        val reader = InputStreamReader(inputStream,"UTF-8")
        reader.readLines().forEach{
            builder.append(it)
        }
        return builder.toString()
    }
}