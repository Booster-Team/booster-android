package com.booster.booster.viewmodel

import android.app.Application
import android.content.Intent
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.booster.booster.repository.GoogleLoginRepository
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    application: Application
) : AndroidViewModel(application) {

    private lateinit var googleLoginRepository: GoogleLoginRepository

    fun setRepository(repository: GoogleLoginRepository) {
        googleLoginRepository = repository
    }

    fun signIn(): Intent {
        return googleLoginRepository.signIn()
    }

    fun handleSignInResult(task: Task<GoogleSignInAccount>, onResult: (GoogleSignInAccount?) -> Unit) {
        viewModelScope.launch {
            try {
                val account = task.getResult(ApiException::class.java)
                onResult(account)
            } catch (e: ApiException) {
                onResult(null)
            }
        }
    }
}