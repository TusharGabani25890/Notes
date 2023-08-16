package com.example.notes.utils

import android.text.TextUtils

object Validations {

    fun validateCredentials(
        emailAddress: String, password: String, userName: String,
        isLogin: Boolean
    ): Pair<Boolean, String> {

        var result = Pair(true, "")
        if (TextUtils.isEmpty(emailAddress) || (!isLogin && TextUtils.isEmpty(userName)) || TextUtils.isEmpty(
                password
            )
        ) {
            result = Pair(false, "Please provide all the details")
        } else if (!Helper.isValidEmail(emailAddress)) {
            result = Pair(false, "Email is invalid")
        } else if (!TextUtils.isEmpty(password) && password.length <= 5) {
            result = Pair(false, "Password length should be greater than 5")
        }
        return result
    }


}