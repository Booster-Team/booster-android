package com.booster.booster.viewmodel

import android.app.Application
import android.content.Intent
import androidx.lifecycle.AndroidViewModel
import com.booster.booster.repository.GoogleLoginRepository
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    application: Application
) : AndroidViewModel(application) {

    private lateinit var googleLoginRepository: GoogleLoginRepository

    private val _signInResult = MutableStateFlow<FirebaseUser?>(null)
    val signInResult: StateFlow<FirebaseUser?> = _signInResult

    fun setRepository(repository: GoogleLoginRepository) {
        googleLoginRepository = repository
    }

    fun signIn(): Intent {
        return googleLoginRepository.signIn()
    }

    fun handleSignInResult(data: Intent?) {
        val task = googleLoginRepository.getSignInResult(data)
        try {
            val account = task.getResult(ApiException::class.java)
            account?.idToken?.let { idToken ->
                val credential = GoogleAuthProvider.getCredential(idToken, null)
                FirebaseAuth.getInstance().signInWithCredential(credential)
                    .addOnCompleteListener { authTask ->
                        if (authTask.isSuccessful) {
                            _signInResult.value = FirebaseAuth.getInstance().currentUser
                        } else {
                            _signInResult.value = null
                        }
                    }
            } ?: run {
                _signInResult.value = null
            }
        } catch (e: ApiException) {
            e.printStackTrace()
            _signInResult.value = null
        }
    }
}