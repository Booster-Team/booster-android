package com.booster.booster.repository

import android.app.Activity
import android.content.Intent
import com.booster.booster.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task

class GoogleLoginRepository(
    private val activity: Activity
) {

    private val googleSignInClient: GoogleSignInClient by lazy {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(activity.getString(R.string.web_api_key))
            .requestEmail()
            .build()
        GoogleSignIn.getClient(activity, gso)
    }

    fun signIn(): Intent {
        return googleSignInClient.signInIntent
    }

    fun getSignInResult(data: Intent?): Task<GoogleSignInAccount> {
        return GoogleSignIn.getSignedInAccountFromIntent(data)
    }

    fun hasAccount(): Boolean {
        val account = GoogleSignIn.getLastSignedInAccount(activity)
        return account != null
    }
}