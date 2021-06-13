package com.junio.navigationcomponent.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.junio.navigationcomponent.R

class LoginViewModel : ViewModel() {

    sealed class AuthenticationState {
        class InvalidAuthentication(val fields: List<Pair<String, Int>>) : AuthenticationState()
    }

    val authenticationStateEvent = MutableLiveData<AuthenticationState>()

    fun authentication(username: String, password: String) {
        if (isValidForm(username, password)){

        }
    }

    private fun isValidForm(username: String, password: String) : Boolean {
        val invalidFields = arrayListOf<Pair<String, Int>>()

        if (username.isEmpty())
            invalidFields.add(INPUT_USERNAME)

        if (password.isEmpty())
            invalidFields.add(INPUT_PASSWORD)

        if (invalidFields.isNotEmpty()){
            authenticationStateEvent.value = AuthenticationState.InvalidAuthentication(invalidFields)
            return false
        }

        return true
    }

    companion object {
        val INPUT_USERNAME = "INPUT_USERNAME" to R.string.login_input_layout_error_invalid_username
        val INPUT_PASSWORD = "INPUT_PASSWORD" to R.string.login_input_layout_error_invalid_password
    }
}